package oj.leetcode.string.palindrome;

import static org.junit.Assert.*;

import org.junit.Test;

public class PalindromeTest {

	@Test
	public void test() {
		Palindrome pd = new Palindrome();
		boolean isPalind;
//		
		isPalind = pd.isPalindrome("A man, a plan, a canal: Panama");
		assertTrue(isPalind);
		
		isPalind = pd.isPalindrome("race a car");
		assertFalse(isPalind);
		
		isPalind = pd.isPalindrome(".,");
		assertTrue(isPalind);
		
		isPalind = pd.isPalindrome("A.,a");
		assertTrue(isPalind);
		
		isPalind = pd.isPalindrome("Ab.,a");
		assertTrue(isPalind);
		
		isPalind = pd.isPalindrome("Ab.dc,a");
		assertFalse(isPalind);
		
		isPalind = pd.isPalindrome("1a2");
		assertFalse(isPalind);
	}

}
