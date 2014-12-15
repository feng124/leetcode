package oj.leetcode.num.peak;

import static org.junit.Assert.*;

import org.junit.Test;

public class PeakElementTest {

	private final PeakElement inst = new PeakElement();

	@Test
	public void test() {
		int[] num = null;
		int peak = -1;

		num = new int[] { 1, 2, 3, 1 };
		peak = inst.findPeakElement(num);
		assertEquals(peak, 2);

		num = new int[] { 3 };
		peak = inst.findPeakElement(num);
		assertEquals(peak, 0);

		num = new int[] { 3, 1, 2, 1 };
		peak = inst.findPeakElement(num);
		assertEquals(peak, 0);

		num = new int[] { 1, 2, 3 };
		peak = inst.findPeakElement(num);
		assertEquals(peak, 2);

		num = new int[] { -2147483648 };
		peak = inst.findPeakElement(num);
		assertEquals(peak, 0);

		num = new int[] { 2147483647 };
		peak = inst.findPeakElement(num);
		assertEquals(peak, 0);
	}

}
