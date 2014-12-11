package oj.leetcode.array.merge;

import java.util.Arrays;

/**
 * 
 * There are two sorted arrays A and B of size m and n respectively. Merge these
 * two sorted arrays. The time complexity of your solution should be
 * O(log(m+n)).
 *
 */
public class ArrayMerge {

	public int[] mergeSortedArray(int[] A, int[] B) {
		if (A == null || A.length == 0) {
			return B;
		}
		
		if (B == null || B.length == 0) {
			return A;
		}

		int[] ret = new int[A.length + B.length];
		int ip = 0;
		int[] array = B;
		int rr = 0;
		int ref = A[rr];
		int lw = 0;
		while (true) {
			int rw = binarySearch(array, lw, array.length, ref);
			System.arraycopy(array, lw, ret, ip, rw - lw);
			ip += (rw - lw);
			if (rw == array.length) {
				array = (array == A ? B : A);
				System.arraycopy(array, rr, ret, ip, array.length - rr);
				break;
			}

			lw = rr;
			rr = rw;
			ref = array[rw];
			array = (array == A ? B : A);
		}

		return ret;
	}

	private int binarySearch(int[] array, int from, int to, int ref) {

		int ip = Arrays.binarySearch(array, from, to, ref);
		if (ip < 0) {
			ip = -ip - 1;
		}
		for (; ip < array.length; ip++) {
			if (array[ip] != ref) {
				break;
			}
		}

		return ip;

	}
}
