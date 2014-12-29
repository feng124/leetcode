package oj.leetcode.string.parenthese;

import static org.junit.Assert.*;

import org.junit.Test;

public class ParentheseValidatorTest {
	
	private final ParentheseValidator inst = new ParentheseValidator();

	@Test
	public void test() {
		boolean valid = inst.isValid("()");
		assertTrue(valid);
		
		valid = inst.isValid("[()]");
		assertTrue(valid);
		
		valid = inst.isValid("[(])");
		assertFalse(valid);
		
		valid = inst.isValid("()[]{}");
		assertTrue(valid);
		
		valid = inst.isValid(")");
		assertFalse(valid);
	}

}
