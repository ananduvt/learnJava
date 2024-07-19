import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CommonCharacterCount {
    // Given two strings, find the number of common characters between them.

    // Example

    // For s1 = "aabcc" and s2 = "adcaa", the output should be
    // solution(s1, s2) = 3.

    // Strings have 3 common characters - 2 "a"s and 1 "c".

    public static void main(String[] args) {
        System.out.println(new CommonCharacterCount().solution("aabcc", "adcaa"));
        System.out.println(new CommonCharacterCount().solution("zzzz", "zzzzzzz"));
        System.out.println(new CommonCharacterCount().solution("abca", "xyzbac"));
        System.out.println(new CommonCharacterCount().solution("a", "b"));
    }

    int solution(String s1, String s2) {

        Map<Character, Long> collect = s1.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        Map<Character, Long> collect1 = s2.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        int count = 0;
        for (Entry<Character, Long> entrySet : collect.entrySet()) {
            char c = entrySet.getKey();
            if (collect1.containsKey(c)) {
                count += Math.min(collect.get(c), collect1.get(c));
            }
        }

        return count;
    }

    int solution2(String s1, String s2) {
        int cnt = 0;

        char[] s1Char = s1.toCharArray();
        char[] s2Char = s2.toCharArray();

        for (int i = 0; i < s1Char.length; i++) {
            for (int j = 0; j < s2Char.length; j++) {
                if (s1Char[i] == s2Char[j]) {
                    cnt++;
                    s1Char[i] = ' ';
                    s2Char[j] = ' ';
                    break;
                }
            }
        }
        return cnt;
    }
}
