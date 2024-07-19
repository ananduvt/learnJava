


public class CheckPallindrome {

    // Given the string, check if it is a palindrome.

    // Example

    // For inputString = "aabaa", the output should be
    // solution(inputString) = true;
    // For inputString = "abac", the output should be
    // solution(inputString) = false;
    // For inputString = "a", the output should be
    // solution(inputString) = true.
    public static void main(String[] args) {

        // System.out.println(new Pallindrome().Solution("aba"));
        // System.out.println(new Pallindrome().Solution("abbcbba"));
        // System.out.println(new Pallindrome().Solution("abaaaba"));
        // System.out.println(new Pallindrome().Solution("abcbaba"));

        Object[][] inOuts = { { new Object[] { "aba" }, true },
                { new Object[] { "abcbaba" }, false } };

        TestUtil.testSolutions(new CheckPallindrome(), "Solution", inOuts);

    }

    public boolean Solution(String inputString) {

        return inputString.equals(new StringBuilder(inputString).reverse().toString());
    }

}