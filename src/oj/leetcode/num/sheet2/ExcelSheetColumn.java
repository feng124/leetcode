package oj.leetcode.num.sheet2;

/**
 * 
 * Related to question Excel Sheet Column Title
 * 
 * Given a column title as appear in an Excel sheet, return its corresponding
 * column number.
 * 
 * For example:
 * 
 * A -> 1 
 * B -> 2 
 * C -> 3 
 * ... 
 * Z -> 26 
 * AA -> 27 
 * AB -> 28
 *
 */
public class ExcelSheetColumn {

	public int titleToNumber(String s) {
		int ret = 0;
		for (int i = 0; i < s.length(); ++i) {
			char ch = s.charAt(i);
			int val = ch - 'A' + 1;
			ret = ret * 26 + val;
		}
		return ret;
	}
}
