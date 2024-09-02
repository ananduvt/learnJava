package avt.learn.challenge.problem.codesignal;

import java.util.Arrays;

public class SortbyHeight {

    // Some people are standing in a row in a park. There are trees between them
    // which cannot be moved. Your task is to rearrange the people by their heights
    // in a non-descending order without moving the trees. People can be very tall!

    // Example

    // For a = [-1, 150, 190, 170, -1, -1, 160, 180], the output should be
    // solution(a) = [-1, 150, 160, 170, -1, -1, 180, 190].

    public static void main(String[] args) {
        // System.out.println(new SortbyHeight().solution(new int[] { -1, 150, 190, 170, -1, -1, 160, 180 }));
        System.out.println(new SortbyHeight().solution(new int[] { 4, 2, 9, 11, 2, 16 }));

    }

    int[] solution(int[] a) {

        int[] sortedArrays = Arrays.stream(a).sorted().filter(n -> n != -1).toArray();

        if(a.length == sortedArrays.length) return sortedArrays;
        for (int i = 0, j = 0; i < a.length; i++) {
            if (a[i] != -1) {
                a[i] = sortedArrays[j++];
            }
        }
        return a;
    }

}
