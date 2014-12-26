package oj.leetcode.num.countsay;

/**
 * 
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 * 
 * 1 is read off as "one 1" or 11.
 * 
 * 11 is read off as "two 1s" or 21.
 * 
 * 21 is read off as "one 2, then one 1" or 1211.
 * 
 * Given an integer n, generate the nth sequence.
 * 
 * Note: The sequence of integers will be represented as a string.
 *
 */
public class CountSay {

	public String countAndSay(int n) {
		if (n < 0) {
			throw new IllegalArgumentException("");
		}

		StringBuffer buf = new StringBuffer("1");
		for (int i = 1; i < n; ++i) {
			int len = buf.length();
			for (int j = 0; j < len;) {
				char ch = buf.charAt(j);
				int cnt = 1;
				while ((j + cnt) < len) {
					if (buf.charAt(j+cnt) != ch) {
						break;
					}
					cnt++;
				}
				buf.append(cnt);
				buf.append(ch);
				j += cnt;
			}
			buf = buf.delete(0, len);
		}
		return buf.toString();
	}

}
