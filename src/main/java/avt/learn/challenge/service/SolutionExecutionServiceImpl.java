package avt.learn.challenge.service;

import avt.learn.challenge.base.Problem;
import avt.learn.challenge.base.Solution;
import lombok.extern.slf4j.Slf4j;
import org.reflections.Reflections;
import org.reflections.scanners.Scanners;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;
import java.util.Set;

@Slf4j
@Service
public class SolutionExecutionServiceImpl implements SolutionExecutionService {

    private final ApplicationContext context;

    @Value("${problem.print.description:false}")
    private boolean printProblemStatement;

    @Value("${problem.execution.stopOnFail:false}")
    private boolean stopOnProblemFail;

    public SolutionExecutionServiceImpl(ApplicationContext context) {
        this.context = context;
    }

    public void invokeJavaProblems(String packageName) {

        Reflections reflections = new Reflections(new ConfigurationBuilder().setUrls(ClasspathHelper.forPackage(packageName)).setScanners(Scanners.TypesAnnotated));

        log.info("Loading all class with annotation : {}", Problem.class);
        Set<Class<?>> annotatedClasses = reflections.getTypesAnnotatedWith(Problem.class, true);
        log.info("Annotated classes: {}", annotatedClasses);

        for (Class<?> annotatedClass : annotatedClasses) {
            try {
                Method[] methods = annotatedClass.getDeclaredMethods();
                log.info("Checking for solutions from class : {}", annotatedClass.getSimpleName());
                for (Method method : methods) {
                    if (method.isAnnotationPresent(Solution.class)) {
                        Object bean = context.getBean(annotatedClass);
                        Method getProblemStatementMethod = annotatedClass.getMethod("getProblemStatement");
                        Method getInputOutputsMethod = annotatedClass.getMethod("getInputOutputs");
                        String problemStatement = (String) getProblemStatementMethod.invoke(bean);
                        Object[][] inputOutputs = (Object[][]) getInputOutputsMethod.invoke(bean);
                        log.info("Invoking method : {}", annotatedClass.getSimpleName());
                        executeProblem(bean, method.getName(), problemStatement, inputOutputs);
                    }
                }
            } catch (Exception e) {
                log.error("Failed to load solution method", e);
                log.error("Class : {}", annotatedClass.getName());
            }
        }
    }

    private void executeProblem(Object bean, String methodName, String problemStatement, Object[][] inOuts) {
        log.info("Problem Name : {}", bean.getClass().getSimpleName());
        if (printProblemStatement) log.info("\nProblem Statement : {}", problemStatement);

        int count = 1;
        for (Object[] inOut : inOuts) {
            if (!executeSolution(bean, methodName, (Object[]) inOut[0], inOut[1], count++) || stopOnProblemFail) {
                log.info("Testcase failed. Further execution stopped");
                break;
            }
        }
    }

    private boolean executeSolution(Object bean, String methodName, Object[] params, Object expected, int count) {
        boolean isTestPass = false;
        try {
            Class<?>[] paramTypes = new Class[params.length];
            for (int i = 0; i < params.length; i++) {
                paramTypes[i] = params[i].getClass();
            }
            Method method = bean.getClass().getMethod(methodName, paramTypes);
            Object result = method.invoke(bean, params);
            isTestPass = result.equals(expected);

            log.info("\nTest results {}\nInputs : {}\nExpected : {}\nActual : {}\nTest case {}", count, params, expected, result, (isTestPass ? "Passed ✅" : "Failed ❌"));

        } catch (Exception e) {
            log.error("Testing Failed", e);
            e.printStackTrace();
        }

        return isTestPass;
    }
}
