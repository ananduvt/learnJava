package avt.learn.learnJava.problems.codeSignal;

import java.util.stream.IntStream;

public class AdjacentElementsProduct {

        // Given an array of integers, find the pair of adjacent elements that has the
        // largest product and return that product.

        // Example

        // For inputArray = [3, 6, -2, -5, 7, 3], the output should be
        // solution(inputArray) = 21.

        // 7 and 3 produce the largest product.

        public static void main(String[] args) {

        }

        int solution(int[] inputArray) {
                return IntStream.range(1, inputArray.length).map(i -> inputArray[i] * inputArray[i - 1]).max()
                                .getAsInt();

        }

}
