package oj.leetcode.string.palindrome;

/**
 *
 * Given a string, determine if it is a palindrome, considering only
 * alphanumeric characters and ignoring cases.
 * 
 * For example, "A man, a plan, a canal: Panama" is a palindrome. "race a car"
 * is not a palindrome.
 * 
 * Note: Have you consider that the string might be empty? This is a good
 * question to ask during an interview.
 * 
 * For the purpose of this problem, we define empty string as valid palindrome.
 *
 */
public class Palindrome {

	public boolean isPalindrome(String s) {
		if (s.isEmpty()) {
			return true;
		}

		boolean palind = true;
		String buf = s.toLowerCase();
		int sta = 0;
		int end = buf.length()-1;
		while(sta <= end) {
			do {
				char ch = buf.charAt(sta);
				if (isValidChar(ch)) {
					break;
				}
				sta++;
			}while(sta < buf.length());
			
			do {
				char ch = buf.charAt(end);
				if (isValidChar(ch)) {
					break;
				}
				end--;
  			}while(end >= 0);
			
			if (sta == end) {
				break;
			}
			if (sta < end) {
				char ch = buf.charAt(sta);
				char ref = buf.charAt(end);
				if (ch != ref) {
					palind = false;
					break;
				}
				sta++;
				end--;
			}
		}

		return palind;
	}

	private boolean isValidChar(char ch) {
		if (ch >= '0' && ch <= '9') {
			return true;
		}
		if (ch >= 'a' && ch <= 'z') {
			return true;
		}
		return false;
	}

}
