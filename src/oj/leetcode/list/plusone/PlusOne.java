package oj.leetcode.list.plusone;

/**
 * 
 * Given a non-negative number represented as an array of digits, plus one to
 * the number.
 * 
 * The digits are stored such that the most significant digit is at the head of
 * the list.
 *
 */
public class PlusOne {

	public int[] plusOne(int[] digits) {
		int carry = 1;
		for (int i = digits.length - 1; i > 0; i--) {
			digits[i] += carry;
			carry = 0;
			if (digits[i] == 10) {
				digits[i] = 0;
				carry = 1;
			}
		}
		if (carry == 1) {
			digits[0] += carry;
			if (digits[0] == 10) {
				digits[0] = 0;
				int[] _digits = new int[digits.length + 1];
				System.arraycopy(digits, 0, _digits, 1, digits.length);
				_digits[0] = 1;
				digits = _digits;
			}
		}
		return digits;
	}

}
