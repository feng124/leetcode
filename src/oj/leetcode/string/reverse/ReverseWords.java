package oj.leetcode.string.reverse;

/**
 *
 * Given an input string, reverse the string word by word.
 * 
 * For example, Given s = "the sky is blue", return "blue is sky the".
 * 
 * Clarification:
 * 
 * 1. What constitutes a word? A sequence of non-space characters constitutes a
 * word. 2. Could the input string contain leading or trailing spaces? Yes.
 * However, your reversed string should not contain leading or trailing spaces.
 * 3. How about multiple spaces between two words? Reduce them to a single space
 * in the reversed string.
 *
 */
public class ReverseWords {

	public String reverseWords(String s) {
		if (s == null || s.isEmpty()) {
			return s;
		}

		StringBuffer buf = new StringBuffer();

		int ws = s.length() - 1;
		while (ws >= 0) {
			int we = ws + 1;
			for (; we > 0; we--) {
				if (s.charAt(we - 1) != ' ') {
					break;
				}
			}
			if (we == 0) {
				break;
			}
			
			ws = we;
			for (; ws > 0; ws--) {
				if (s.charAt(ws - 1) == ' ') {
					break;
				}
			}

			if (ws < we) {
				if (buf.length() > 0) {
					buf.append(' ');
				}
				buf.append(s.substring(ws, we));
			}
			ws--;
		}

		return buf.toString();
	}
}
