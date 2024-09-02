package avt.learn.challenge.problem.codesignal;

import avt.learn.challenge.base.BaseProblem;
import avt.learn.challenge.base.Problem;
import avt.learn.challenge.base.Solution;

@Problem
public class CheckPallindrome extends BaseProblem {

	@Override
	public String setProblemStatement() {
		return """
				Given the string, check if it is a palindrome.
				Example
				For inputString = "aabaa", the output should be solution(inputString) = true;
				For inputString = "abac", the output should be solution(inputString) = false;
				For inputString = "a", the output should be solution(inputString) = true.
				""";
	}

	@Override
	public Object[][] setProblemInputOutputs() {
		return new Object[][]{ 
			{ new Object[] { "aba" }, true }, 
			{ new Object[] { "abcbaba" }, false },
			{ new Object[] { "abaaaba" }, true }, 
			{ new Object[] { "abcbabadd" }, false },
			{ new Object[] { "abccbas" }, false }, 
			{ new Object[] { "a" }, true } };
	}

	@Solution
	public Object solution(String inputString) {
		return inputString.contentEquals(new StringBuilder(inputString).reverse());
	}

	public static void main(String[] args) {


	}

}