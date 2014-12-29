package oj.leetcode.num.palindrome;

/**
 * 
 * Determine whether an integer is a palindrome. Do this without extra space.
 * 
 * Some hints:
 * 
 * Could negative integers be palindromes? (ie, -1)
 * 
 * If you are thinking of converting the integer to string, note the restriction
 * of using extra space.
 * 
 * You could also try reversing an integer. However, if you have solved the
 * problem "Reverse Integer", you know that the reversed integer might overflow.
 * How would you handle such case?
 * 
 * There is a more generic way of solving this problem.
 * 
 *
 */
public class PalindromeNumber {

	public boolean isPalindrome(int x) {
		if (x < 0) {
			return false;
		}
		
		int rr = 0;
		int div = x;
		do {
			int rest = div;
			div = div / 10;
			rest = rest - div * 10;
			rr = rr * 10 + rest;
			if (div == 0) {
				break;
			}
		} while (true);

		return (x == rr ? true : false);
	}

}
