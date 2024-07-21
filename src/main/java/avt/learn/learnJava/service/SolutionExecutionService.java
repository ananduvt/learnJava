package avt.learn.learnJava.service;

public interface SolutionExecutionService {
	public void executeProblem(Class<?> clazz, String problemStatement, String methodName, Object[][] inOuts);

	public void invokeJavaProblems(String packageName);
}
