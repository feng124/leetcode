package oj.leetcode.num.reverse;

import static org.junit.Assert.*;

import org.junit.Test;

public class ReverseIntegerTest {

	private final ReverseInteger inst = new ReverseInteger();
	
	@Test
	public void test() {
		
		int num = 378;
		int rev = inst.reverse(num);
		assertEquals(rev, 873);
		
		num = -920;
		num = inst.reverse(num);
		assertEquals(num, -29);
		
		num = 1534236469;
		num = inst.reverse(num);
		assertEquals(num, 0);
		
		num = -986;
		num = inst.reverse(num);
		assertEquals(num, -689);

	}

}
