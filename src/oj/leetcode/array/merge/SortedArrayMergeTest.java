package oj.leetcode.array.merge;

import static org.junit.Assert.*;

import org.junit.Test;

public class SortedArrayMergeTest {

	private final SortedArrayMerge inst = new SortedArrayMerge();

	@Test
	public void test() {

		int[] A = new int[] { 5 };
		int[] B = new int[] { 6 };
		int[] m = inst.mergeSortedArray(A, B);
		assertEquals(m.length, 2);
		assertEquals(m[0], 5);
		assertEquals(m[1], 6);

		m = inst.mergeSortedArray(B, A);
		assertEquals(m.length, 2);
		assertEquals(m[0], 5);
		assertEquals(m[1], 6);

		B = new int[] { 6, 6, 7 };
		m = inst.mergeSortedArray(A, B);
		assertEquals(m.length, 4);
		assertEquals(m[0], 5);
		assertEquals(m[1], 6);
		assertEquals(m[2], 6);
		assertEquals(m[3], 7);

		B = new int[] { 1, 2, 3, 3 };
		m = inst.mergeSortedArray(A, B);
		assertEquals(m.length, 5);
		assertEquals(m[0], 1);
		assertEquals(m[1], 2);
		assertEquals(m[2], 3);
		assertEquals(m[3], 3);
		assertEquals(m[4], 5);

		A = new int[] { 5, 9 };
		B = new int[] { 2, 4, 6, 8 };
		m = inst.mergeSortedArray(A, B);
		assertEquals(m.length, 6);
		assertEquals(m[0], 2);
		assertEquals(m[1], 4);
		assertEquals(m[2], 5);
		assertEquals(m[3], 6);
		assertEquals(m[4], 8);
		assertEquals(m[5], 9);

		A = new int[] { 1, 3, 5, 7 };
		B = new int[] { 0, 2, 4, 6, 8, 10 };
		m = inst.mergeSortedArray(A, B);
		assertEquals(m.length, 10);
		assertEquals(m[0], 0);
		assertEquals(m[1], 1);
		assertEquals(m[2], 2);
		assertEquals(m[3], 3);
		assertEquals(m[4], 4);
		assertEquals(m[5], 5);
		assertEquals(m[6], 6);
		assertEquals(m[7], 7);
		assertEquals(m[8], 8);
		assertEquals(m[9], 10);
		
		m = inst.mergeSortedArray(null, B);
		assertEquals(m.length, 6);
		assertEquals(m[0], 0);
		assertEquals(m[1], 2);
		assertEquals(m[2], 4);
		assertEquals(m[3], 6);
		assertEquals(m[4], 8);
		assertEquals(m[5], 10);
		
		m = inst.mergeSortedArray(new int[] {}, B);
		assertEquals(m.length, 6);
		assertEquals(m[0], 0);
		assertEquals(m[1], 2);
		assertEquals(m[2], 4);
		assertEquals(m[3], 6);
		assertEquals(m[4], 8);
		assertEquals(m[5], 10);
		
		m = inst.mergeSortedArray(null, null);
		assertNull(m);
		
		m = inst.mergeSortedArray(new int[] {}, new int[] {});
		assertEquals(m.length, 0);
		
		m = inst.mergeSortedArray(B, null);
		assertEquals(m.length, 6);
		assertEquals(m[0], 0);
		assertEquals(m[1], 2);
		assertEquals(m[2], 4);
		assertEquals(m[3], 6);
		assertEquals(m[4], 8);
		assertEquals(m[5], 10);
	
	}

}
