package avt.learn.learnJava.problems.codeSignal;

import org.springframework.stereotype.Component;

import avt.learn.learnJava.base.BaseProblem;

@Component
public class CheckPallindrome extends BaseProblem {

	private static final String PROBLEM_STATEMENT = """
			Given the string, check if it is a palindrome.
			Example
			For inputString = "aabaa", the output should be solution(inputString) = true;
			For inputString = "abac", the output should be solution(inputString) = false;
			For inputString = "a", the output should be solution(inputString) = true.
			""";

	private static final Object[][] inOuts = { 
			{ new Object[] { "aba" }, true }, 
			{ new Object[] { "abcbaba" }, false },
			{ new Object[] { "abaaaba" }, true }, 
			{ new Object[] { "abcbabadd" }, false },
			{ new Object[] { "abccbas" }, false }, 
			{ new Object[] { "a" }, false } };
	
	@Override
	public void execute() {
		solutionExecutionService.executeProblem(CheckPallindrome.class, PROBLEM_STATEMENT, "solution", inOuts);
	}

	public boolean solution(String inputString) {
		return inputString.equals(new StringBuilder(inputString).reverse().toString());
	}
	
	public static void main(String[] args) {
		
	}

}