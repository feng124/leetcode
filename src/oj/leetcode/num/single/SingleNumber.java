package oj.leetcode.num.single;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * Given an array of integers, every element appears twice except for one. Find
 * that single one.
 * 
 * Note: Your algorithm should have a linear runtime complexity. Could you
 * implement it without using extra memory?
 *
 */
public class SingleNumber {

	private final Set<Integer> array = new HashSet<Integer>();
	
	public int singleNumber(int[] A) {
		array.clear();
		
		int diff = 0;
		for(int i = 0; i < A.length; i++) {
			if (!array.contains(A[i])) {
				array.add(A[i]);
				diff += A[i];
			}else {
				diff -= A[i];
			}
		}
		
		return diff;
	}
}
