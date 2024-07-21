package avt.learn.learnJava.problems.codeSignal;

import java.util.Arrays;
import java.util.stream.Stream;

public class ReverseInParentheses {

    // Write a function that reverses characters in (possibly nested) parentheses in
    // the input string.

    // Input strings will always be well-formed with matching ()s.

    // Example

    // For inputString = "(bar)", the output should be
    // solution(inputString) = "rab";
    // For inputString = "foo(bar)baz", the output should be
    // solution(inputString) = "foorabbaz";
    // For inputString = "foo(bar)baz(blim)", the output should be
    // solution(inputString) = "foorabbazmilb";
    // For inputString = "foo(bar(baz))blim", the output should be
    // solution(inputString) = "foobazrabblim".
    // Because "foo(bar(baz))blim" becomes "foo(barzab)blim" and then
    // "foobazrabblim".
    public static void main(String[] args) {
        // System.out.println(new ReverseInParentheses().solution("(bar)"));
        // System.out.println(new ReverseInParentheses().solution("foo(bar)baz"));
        System.out.println(new ReverseInParentheses().solution("foo(bar)baz(blim)"));
    }

    String solution(String inputString) {
        return formatString(inputString);
    }

    public String formatString(String s) {
        if (s.contains("(")) {
            int first = s.lastIndexOf((int) '(');
            int last = s.indexOf((int) ')', first);
            return formatString(s.substring(0, first)
                    + formatString(new StringBuilder(s.substring(first+1, last )).reverse().toString())
                    + s.substring(last + 1, s.length()));
        }
        return s;
    }

}
