package oj.leetcode.num.palindrome;

import static org.junit.Assert.*;

import org.junit.Test;

public class PalindromeNumberTest {
	
	private final PalindromeNumber inst = new PalindromeNumber();

	@Test
	public void test() {
		boolean palin = inst.isPalindrome(575);
		assertTrue(palin);
		
		palin = inst.isPalindrome(5);
		assertTrue(palin);
		
		palin = inst.isPalindrome(57);
		assertFalse(palin);
		
		palin = inst.isPalindrome(-1);
		assertTrue(palin);
	}

}
