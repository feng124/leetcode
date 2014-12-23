package oj.leetcode.num.majority;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Given an array of size n, find the majority element. The majority element is
 * the element that appears more than [n/2] times.
 * 
 * You may assume that the array is non-empty and the majority element always
 * exist in the array.
 * 
 */
public class MajorityElement {
	
	private final Map<Integer, Integer> num_count = new HashMap<Integer, Integer>();

	public int majorityElement(int[] num) {
		int ref = Integer.MIN_VALUE;
		int max_count = Integer.MIN_VALUE;
		for(int i = 0; i < num.length; i++) {
			int count = 1;
			if (num_count.containsKey(num[i])) {
				count += num_count.get(num[i]);
			}
			num_count.put(num[i], count);
			if (count > max_count) {
				max_count = count;
				ref = num[i];
			}
		}
		num_count.clear();
		return ref;
	}

}
