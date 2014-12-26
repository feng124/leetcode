package oj.leetcode.num.stair;

import static org.junit.Assert.*;

import org.junit.Test;

public class ClimbStairTest {

	private final ClimbStair inst = new ClimbStair();

	@Test
	public void test() {

		int distinct = inst.climbStairs(1);
		assertEquals(distinct, 1);

		distinct = inst.climbStairs(2);
		assertEquals(distinct, 2);

		distinct = inst.climbStairs(3);
		assertEquals(distinct, 3);

		distinct = inst.climbStairs(4);
		assertEquals(distinct, 5);

		distinct = inst.climbStairs(44);
		assertEquals(distinct, 1134903170);
	}

}
