package avt.learn.learnJava.problems.codeSignal;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Statues {

    // Ratiorg got statues of different sizes as a present from CodeMaster for his
    // birthday, each statue having an non-negative integer size. Since he likes to
    // make things perfect, he wants to arrange them from smallest to largest so
    // that each statue will be bigger than the previous one exactly by 1. He may
    // need some additional statues to be able to accomplish that. Help him figure
    // out the minimum number of additional statues needed.

    // Example

    // For statues = [6, 2, 3, 8], the output should be
    // solution(statues) = 3.

    // Ratiorg needs statues of sizes 4, 5 and 7.
    public static void main(String[] args) {
        System.out.println(new Statues().solution(new int[] { 6, 2, 3, 8 }));
        System.out.println(new Statues().solution2(new int[] { 6, 2, 3, 8 }));

    }

    int solution(int[] statues) {

        Arrays.sort(statues);
        int diffSum=0;
        for (int i = 1;i<statues.length;i++){
            diffSum += statues[i]-statues[i-1]-1;
        }
        return diffSum;

    }

    int solution2(int[] statues) {

        Arrays.sort(statues);
       return IntStream.range(1, statues.length)
                        .map(i->statues[i]-statues[i-1]-1)
                        .sum();

    }

}