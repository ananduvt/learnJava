package avt.learn.challenge.problems.codesignal;

import java.util.stream.Stream;

public class IsLucky {
    // Ticket numbers usually consist of an even number of digits. A ticket number
    // is considered lucky if the sum of the first half of the digits is equal to
    // the sum of the second half.

    // Given a ticket number n, determine if it's lucky or not.

    // Example

    // For n = 1230, the output should be
    // solution(n) = true;
    // For n = 239017, the output should be
    // solution(n) = false.

    public static void main(String[] args) {
        System.out.println(new IsLucky().solution(1230));
        System.out.println(new IsLucky().solution(239017));

    }

    boolean solution(int n) {

        String s = String.valueOf(n);
        int val1 = Stream.of(s.substring(0, s.length() / 2).split("")).mapToInt(Integer::parseInt).sum();
        int val2 = Stream.of(s.substring(s.length() / 2, s.length()).split("")).mapToInt(Integer::parseInt).sum();

        return val1 == val2;
    }

    boolean solution2(int n) {
        String s = n + "";
        int sum = 0;
        for (int i = 0; i < s.length() / 2; i++) {
            sum += (s.charAt(i) - s.charAt(s.length() - 1 - i));
        }
        return sum == 0;
    }
}
