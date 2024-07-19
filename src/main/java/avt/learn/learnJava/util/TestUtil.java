package avt.learn.learnJava.util;

import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestUtil {

	static final Logger logger = Logger.getLogger(TestUtil.class.getName());

	public static void testSolutions(Object instance, String methodName, Object[][] inOuts) {
		for (Object[] inOut : inOuts) {
			testSolution(instance, methodName, (Object[]) inOut[0], inOut[1]);
		}
	}

	static void testSolution(Object instance, String methodName, Object[] params, Object expected) {
		try {
			Class<?> clazz = instance.getClass();
			Class<?>[] paramTypes = new Class[params.length];
			for (int i = 0; i < params.length; i++) {
				paramTypes[i] = params[i].getClass();
			}

			Method method = clazz.getMethod(methodName, paramTypes);
			Object result = method.invoke(instance, params);
			boolean success = result.equals(expected);
			if (success) {
				logger.log(Level.INFO, "Test Success");
				logger.log(Level.INFO, "Input : ");

			} else {
				logger.log(Level.SEVERE, "Test Failed");

			}

		} catch (Exception e) {
			logger.log(Level.SEVERE, "Test Failed", e);
			e.printStackTrace();
		}
	}
}
