package oj.leetcode.num.pascal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * Given numRows, generate the first numRows of Pascal's triangle.
 * 
 * For example, given numRows = 5, Return
 * [
 *       [1], 
 *      [1,1], 
 *     [1,2,1], 
 *    [1,3,3,1], 
 *   [1,4,6,4,1] 
 * ]
 *
 */
public class PascalTriangle {

	public List<List<Integer>> generate(int numRows) {
		
		if (numRows < 0) {
			throw new IllegalArgumentException("numRows is less than 0!");
		}
		
		if (numRows == 0) {
		    return Collections.emptyList();
		}
		
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		ret.add(new ArrayList<Integer>());
		ret.get(0).add(1);
		for(int i = 1; i < numRows; i++) {
			List<Integer> last = ret.get(ret.size()-1);
			ret.add(new ArrayList<Integer>());
			List<Integer> row = ret.get(ret.size()-1);
			row.add(1);
			for(int j = 0; j < i-1; j++) {
				int sum = last.get(j)+last.get(j+1);
				row.add(sum);
			}
			row.add(1);
		}
		
		return ret;
	}

}
