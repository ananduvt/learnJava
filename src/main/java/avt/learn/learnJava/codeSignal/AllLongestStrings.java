package src.main.java.learnjava.codeSignal;
import java.util.Arrays;
import java.util.stream.Stream;

public class AllLongestStrings {

    // Given an array of strings, return another array containing all of its longest
    // strings.

    // Example

    // For inputArray = ["aba", "aa", "ad", "vcd", "aba"], the output should be
    // solution(inputArray) = ["aba", "vcd", "aba"].
    public static void main(String[] args) {

        System.out.println(new AllLongestStrings().solution(new String[] { "aba", "aa", "ad", "vcd", "aba" }));
    }

    String[] solution(String[] inputArray) {
        int maxLen = Stream.of(inputArray).mapToInt(s -> s.length()).max().orElse(0);
        return Stream.of(inputArray).filter(s -> s.length() == maxLen).toArray(String[]::new);
    }

}
