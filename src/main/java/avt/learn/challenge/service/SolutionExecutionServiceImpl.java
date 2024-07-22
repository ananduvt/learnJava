package avt.learn.challenge.service;

import java.lang.reflect.Method;
import java.util.Set;

import org.reflections.Reflections;
import org.reflections.scanners.Scanners;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import avt.learn.challenge.base.Problem;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SolutionExecutionServiceImpl implements SolutionExecutionService{

	@Value("${problem.print.description:false}")
	private boolean printProblemStatement;

	@Value("${problem.execution.stopOnFail:false}")
	private boolean stopOnProblemFail;

	private ApplicationContext context;

	public SolutionExecutionServiceImpl(ApplicationContext context) {
		this.context = context;
	}

	public void executeProblem(Class<?> clazz, String problemStatement, String methodName, Object[][] inOuts) {
		log.info("Problem Name : {}", clazz.getSimpleName());
		if (printProblemStatement)
			log.info("\nProblem Statement : {}", problemStatement);

		int count = 1;
		for (Object[] inOut : inOuts) {
			if (!executeSolution(clazz, methodName, (Object[]) inOut[0], inOut[1], count++) || stopOnProblemFail)
				break;
		}
	}

	private boolean executeSolution(Class<?> clazz, String methodName, Object[] params, Object expected, int count) {
		boolean isTestPass = false;
		try {
			Object bean = context.getBean(clazz);
			Class<?>[] paramTypes = new Class[params.length];
			for (int i = 0; i < params.length; i++) {
				paramTypes[i] = params[i].getClass();
			}
			Method method = clazz.getMethod(methodName, paramTypes);
			Object result = method.invoke(bean, params);
			isTestPass = result.equals(expected);

			log.info("\nTest results {}\nInputs : {}\nExpected : {}\nActual : {}\nTest case {}", count, params,
					expected, result, (isTestPass ? "Passed" : "Failed"));

		} catch (Exception e) {
			log.error("Testing Failed", e);
			e.printStackTrace();
		}

		return isTestPass;
	}

	public void invokeJavaProblems(String packageName) {

		Class<? extends Problem> annotationClass = Problem.class;
		log.info("Loading all class with annotation : {}", Problem.class);

		Reflections reflections = new Reflections(new ConfigurationBuilder()
				.setUrls(ClasspathHelper.forPackage(packageName)).setScanners(Scanners.TypesAnnotated));

		Set<Class<?>> annotatedClasses = reflections.getTypesAnnotatedWith(annotationClass);
		log.info("Annotated classes: {}", annotatedClasses);

		for (Class<?> annotatedClass : annotatedClasses) {
			try {
				Method method = annotatedClass.getMethod("execute");
				Object bean = context.getBean(annotatedClass);
				log.info("Invoking main method of class : {}", annotatedClass.getSimpleName());
				method.invoke(bean);
			} catch (Exception e) {
				log.error("Failed to load main method", e);
				log.error("Class : {}", annotatedClass.getName());
			}
		}
	}
}
