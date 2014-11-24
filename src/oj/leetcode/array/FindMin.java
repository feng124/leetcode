package oj.leetcode.array;

/**
 * 
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * 
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * 
 * Find the minimum element.
 * 
 * You may assume no duplicate exists in the array.
 * 
 */

public class FindMin {

	public int findMin(int[] num) {
		if(num == null || num.length == 0) {
			throw new IllegalArgumentException();
		}
		
		int pivot = num[0];
		if (num.length > 1) {
			int start = 0;
			int end = num.length-1;
			while(start < end) {
				if ((end-start) == 1) {
					pivot = (num[start] < num[end] ? num[start] : num[end]);
					break;
				}
				int mid = (start+end+1)/2;
				boolean left = (num[start] > num[mid]);
				boolean right = (num[mid] > num[end]);
				if (left && !right) {
					end = mid;
				}else if (!left && right) {
					start = mid;
				}else if (left && right){
					pivot = num[end];
					break;
				}else {
					pivot = num[start];
					break;
				}
			}
		}
		return pivot;
	}
	
}
