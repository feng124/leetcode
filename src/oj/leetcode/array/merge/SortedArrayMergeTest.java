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
		assertArrayEquals(m, new int[] { 5, 6 });

		m = inst.mergeSortedArray(B, A);
		assertArrayEquals(m, new int[] { 5, 6 });

		B = new int[] { 6, 6, 7 };
		m = inst.mergeSortedArray(A, B);
		assertArrayEquals(m, new int[] { 5, 6, 6, 7 });

		B = new int[] { 1, 2, 3, 3 };
		m = inst.mergeSortedArray(A, B);
		assertArrayEquals(m, new int[] { 1, 2, 3, 3, 5 });

		A = new int[] { 5, 9 };
		B = new int[] { 2, 4, 6, 8 };
		m = inst.mergeSortedArray(A, B);
		assertArrayEquals(m, new int[] { 2, 4, 5, 6, 8, 9 });

		A = new int[] { 1, 3, 5, 7 };
		B = new int[] { 0, 2, 4, 6, 8, 10 };
		m = inst.mergeSortedArray(A, B);
		assertArrayEquals(m, new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 10 });

		m = inst.mergeSortedArray(null, B);
		assertArrayEquals(m, new int[] { 0, 2, 4, 6, 8, 10 });

		m = inst.mergeSortedArray(new int[] {}, B);
		assertArrayEquals(m, new int[] { 0, 2, 4, 6, 8, 10 });

		m = inst.mergeSortedArray(null, null);
		assertNull(m);

		m = inst.mergeSortedArray(new int[] {}, new int[] {});
		assertArrayEquals(m, new int[] {});

		m = inst.mergeSortedArray(B, null);
		assertArrayEquals(m, new int[] { 0, 2, 4, 6, 8, 10 });

		A = new int[10000];
		B = new int[10000];
		for (int i = 0; i < A.length; i++) {
			A[i] = 2 * i;
			B[i] = A[i]+1;
		}
		m = inst.mergeSortedArray(A, B);
		for(int i = 0; i < m.length; i++) {
			assertEquals(m[i], i);
		}
		
		m = inst.mergeSortedArray(B, A);
		for(int i = 0; i < m.length; i++) {
			assertEquals(m[i], i);
		}
	}

}
