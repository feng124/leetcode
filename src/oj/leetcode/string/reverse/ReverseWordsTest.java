package oj.leetcode.string.reverse;

import static org.junit.Assert.*;

import org.junit.Test;

public class ReverseWordsTest {
	
	private ReverseWords rw = null;
	private String query = null;
	private String guess = null;

	@Test
	public void test() {
		rw = new ReverseWords();

		query = "    ";
		guess = rw.reverseWords(query);
		assertEquals(guess, "");
		
		query = "s          ";
		guess = rw.reverseWords(query);
		assertEquals(guess, "s");
		
		query = "             s";
		guess = rw.reverseWords(query);
		assertEquals(guess, "s");
		
		query = "  s  ";
		guess = rw.reverseWords(query);
		assertEquals(guess, "s");
		
		query = "s";
		guess = rw.reverseWords(query);
		assertEquals(guess, "s");
		
		query = "the sky is blue";
		guess = rw.reverseWords(query);
		assertEquals(guess, "blue is sky the");
		
		query = "  the  sky is   blue     ";
		guess = rw.reverseWords(query);
		assertEquals(guess, "blue is sky the");
		
	}

}
