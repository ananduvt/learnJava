package avt.learn.learnJava.problems.leetCode;
import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

    // Given a string s, find the length of the longest
    // substring
    // without repeating characters.
    // Example 1:

    // Input: s = "abcabcbb"
    // Output: 3
    // Explanation: The answer is "abc", with the length of 3.
    // Example 2:

    // Input: s = "bbbbb"
    // Output: 1
    // Explanation: The answer is "b", with the length of 1.

    public static void main(String[] args) {
        // System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("abcabcbb"));
        // System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("bbbbb"));
        // System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("pwwkew"));
        // System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(""));
        // System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("abc"));
        // System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(" "));
        // System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("aab"));
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("asljlj"));
    }

    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;
        Set<Character> charSet = new HashSet<>();
        int left = 0;

        for (int right = 0; right < n; right++) {
            if (!charSet.contains(s.charAt(right))) {
                charSet.add(s.charAt(right));
                maxLength = Math.max(maxLength, right - left + 1);
            } else {
                while (charSet.contains(s.charAt(right))) {
                    charSet.remove(s.charAt(left));
                    left++;
                }
                charSet.add(s.charAt(right));
            }
        }

        return maxLength;
    }

}
