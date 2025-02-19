package avt.learn.challenge.problem.codesignal;
public class CenturyFromYear {

    // Given a year, return the century it is in. The first century spans from the
    // year 1 up to and including the year 100, the second - from the year 101 up to
    // and including the year 200, etc.

    // Example

    // For year = 1905, the output should be
    // solution(year) = 20;
    // For year = 1700, the output should be
    // solution(year) = 17.
    public static void main(String[] args) {

    }

    int solution(int year) {
        if (year % 100 == 0) {
            return (int) Math.ceil(year / 100);
        } else {
            return ((int) Math.ceil(year / 100) + 1);
        }
    }

}
