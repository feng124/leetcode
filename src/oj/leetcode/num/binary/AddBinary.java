package oj.leetcode.num.binary;

/**
 * 
 * Given two binary strings, return their sum (also a binary string).
 * 
 * For example, a = "11" b = "1" Return "100".
 *
 */
public class AddBinary {

	public String addBinary(String a, String b) {

		StringBuffer buf = new StringBuffer(a);
		StringBuffer _buf = new StringBuffer(b);
		if (buf.length() < _buf.length()) {
			_buf.insert(0, '0');
			int diff = _buf.length() - buf.length();
			for (int i = 0; i < diff; i++) {
				buf.insert(0, '0');
			}
		} else {
			buf.insert(0, '0');
			int diff = buf.length() - _buf.length();
			for (int i = 0; i < diff; i++) {
				_buf.insert(0, '0');
			}
		}

		int carry = 0;
		for (int i = buf.length() - 1; i >= 0; i--) {
			int cha = buf.charAt(i) - '0';
			int chb = _buf.charAt(i) - '0';
			int sum = cha + chb + carry;
			if (sum == 0) {
				buf.setCharAt(i, '0');
				carry = 0;
			} else if (sum == 1) {
				buf.setCharAt(i, '1');
				carry = 0;
			} else if (sum == 2) {
				buf.setCharAt(i, '0');
				carry = 1;
			} else {
				buf.setCharAt(i, '1');
				carry = 1;
			}
		}

		if (buf.charAt(0) == '0') {
			buf = buf.deleteCharAt(0);
		}
		return buf.toString();
	}

}
