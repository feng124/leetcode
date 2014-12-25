package oj.leetcode.string.last;

import static org.junit.Assert.*;

import org.junit.Test;

public class LengthOfLastWordTest {
	
	private final LengthOfLastWord inst = new LengthOfLastWord();

	@Test
	public void test() {
		int length = inst.lengthOfLastWord("hello world");
		assertEquals(length, 5);
		
		length = inst.lengthOfLastWord("hello");
		assertEquals(length, 5);
		
		length = inst.lengthOfLastWord("    ");
		assertEquals(length, 0);
		
		length = inst.lengthOfLastWord("hello world    ");
		assertEquals(length, 5);
	}

}
