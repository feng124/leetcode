package oj.leetcode.num.peak;

/**
 * 
 * A peak element is an element that is greater than its neighbors.
 * 
 * Given an input array where num[i] ≠ num[i+1], find a peak element and return
 * its index.
 * 
 * The array may contain multiple peaks, in that case return the index to any
 * one of the peaks is fine.
 * 
 * You may imagine that num[-1] = num[n] = -∞.
 * 
 * For example, in array [1, 2, 3, 1], 3 is a peak element and your function
 * should return the index number 2.
 *
 */
public class PeakElement {

	public int findPeakElement(int[] num) {
		if (num == null || num.length == 0) {
			throw new IllegalArgumentException();
		}
		
		if (num.length == 1) {
			return 0;
		}
		
		int peak_index = -1;
		for(int i = 0; i < num.length; i++) {
			int left_val = Integer.MIN_VALUE;
			if (i > 0) {
				left_val = num[i-1];
			}
			int right_val = Integer.MIN_VALUE;
			if (i < num.length-1) {
				right_val = num[i+1];
			}
			
			if (num[i] > left_val && num[i] > right_val) {
				peak_index = i;
				break;
			}
			
		}
		return peak_index;
	}

}
