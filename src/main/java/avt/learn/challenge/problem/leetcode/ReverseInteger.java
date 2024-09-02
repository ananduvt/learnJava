package avt.learn.challenge.problem.leetcode;

// Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-2^31, 2^31 - 1], then return 0.

// Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

// Example 1:

// Input: x = 123
// Output: 321
// Example 2:

// Input: x = -123
// Output: -321
// Example 3:

// Input: x = 120
// Output: 21

public class ReverseInteger {

	private static final Object[][] inOuts = { { new Object[] { 123 }, 321 }, { new Object[] {}, false },
			{ new Object[] { "abaaaba" }, true }, { new Object[] { "abcbabadd" }, false },
			{ new Object[] { "abccbas" }, false }, { new Object[] { "a" }, false } };

	public static void main(String[] args) {
		System.out.println(new ReverseInteger().reverse1(1534236469));
	}

	public int reverse1(int x) {

		boolean isNeg = String.valueOf(x).charAt(0) == '-';
		try {
			int reverse = Integer.parseInt(
					new StringBuilder(isNeg ? String.valueOf(x).substring(1) : String.valueOf(x)).reverse().toString());
			return isNeg ? reverse * -1 : reverse;
		} catch (Exception e) {
			return 0;
		}

	}

	public int reverse2(int x) {
		int rev = 0;
		while (x != 0) {
			int pop = x % 10;
			x /= 10;
			if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7))
				return 0;
			if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8))
				return 0;
			rev = rev * 10 + pop;
		}
		return rev;
	}
}
