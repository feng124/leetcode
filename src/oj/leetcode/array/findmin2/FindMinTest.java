package oj.leetcode.array.findmin2;

import static org.junit.Assert.*;

import org.junit.Test;

public class FindMinTest {

	@Test
	public void test() {

		FindMin fm = new FindMin();

		int pivot = fm.findMin(new int[] { 7, 0, 1, 2, 4, 5, 6 });
		assertEquals(pivot, 0);

		pivot = fm.findMin(new int[] { 7, 0, 0, 0, 0 });
		assertEquals(pivot, 0);

		pivot = fm.findMin(new int[] { 7, 7, 7, 7 });
		assertEquals(pivot, 7);

		pivot = fm.findMin(new int[] { 3, 3, 3, 3, 3 });
		assertEquals(pivot, 3);

		pivot = fm.findMin(new int[] { 3, 3, 3, 3, 4 });
		assertEquals(pivot, 3);
	}

}
