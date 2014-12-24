package oj.leetcode.list.plusone;

import static org.junit.Assert.*;

import org.junit.Test;

public class PlusOneTest {
	
	private final PlusOne inst = new PlusOne();

	@Test
	public void test() {
		int[] digits = new int[] {9, 8, 9};
		digits = inst.plusOne(digits);
		assertArrayEquals(digits, new int[] {9, 9, 0});
		
		digits = new int[] {9, 9, 9};
		digits = inst.plusOne(digits);
		assertArrayEquals(digits, new int[] {1, 0, 0, 0});
	}

}
