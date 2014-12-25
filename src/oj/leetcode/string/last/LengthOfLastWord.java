package oj.leetcode.string.last;

/**
 * 
 * Given a string s consists of upper/lower-case alphabets and empty space
 * characters ' ', return the length of last word in the string.
 * 
 * If the last word does not exist, return 0.
 * 
 * Note: A word is defined as a character sequence consists of non-space
 * characters only.
 * 
 * For example, Given s = "Hello World", return 5.
 *
 */
public class LengthOfLastWord {

	public int lengthOfLastWord(String s) {
		int length = 0;
		int last = s.length() - 1;
		for (; last >= 0; last--) {
			char ch = s.charAt(last);
			if (ch != ' ') {
				break;
			}
		}
		if (last != -1) {
			int first = last - 1;
			for (; first >= 0; first--) {
				char ch = s.charAt(first);
				if (ch == ' ') {
					break;
				}
			}
			length = last - first;
			
		}
		return length;
	}
}
