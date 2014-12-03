package oj.leetcode.num.pascal2;

import java.util.Arrays;
import java.util.List;

/**
 * 
 * Given an index k, return the kth row of the Pascal's triangle.
 * 
 * For example, given k = 3, Return [1,3,3,1].
 * 
 * Note: Could you optimize your algorithm to use only O(k) extra space?
 *
 */
public class PascalTriangle {

	public List<Integer> getRow(int rowIndex) {
		if (rowIndex < 0) {
			throw new IllegalArgumentException("rowIndex is less than 0!");
		}

		Integer[] last_row = new Integer[rowIndex + 1];
		last_row[0] = 1;
		for (int i = 1; i <= rowIndex; i++) {
			last_row[i] = 1;
			int ref = last_row[i - 1];
			for (int j = i - 1; j > 0; j--) {
				ref = last_row[j];
				last_row[j] = ref + last_row[j - 1];
			}
		}
		return Arrays.asList(last_row);
	}

}
