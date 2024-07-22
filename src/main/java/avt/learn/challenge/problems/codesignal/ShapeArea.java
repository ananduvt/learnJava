package avt.learn.challenge.problems.codesignal;
public class ShapeArea {

    // Below we will define an n-interesting polygon. Your task is to find the area
    // of a polygon for a given n.

    // A 1-interesting polygon is just a square with a side of length 1. An
    // n-interesting polygon is obtained by taking the n - 1-interesting polygon and
    // appending 1-interesting polygons to its rim, side by side. You can see the
    // 1-, 2-, 3- and 4-interesting polygons in the picture below.

    // Example

    // For n = 2, the output should be
    // solution(n) = 5;
    // For n = 3, the output should be
    // solution(n) = 13.

    public static void main(String[] args) {

    }

    int solution(int n) {

        return (2 * n * n) - (2 * n) + 1;
    }

}
