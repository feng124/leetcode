package oj.leetcode.string.zigzag;

/**
 * 
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number
 * of rows like this: (you may want to display this pattern in a fixed font for
 * better legibility)
 * 
 * P   A   H   N 
 * A P L S I I G 
 * Y   I   R
 * 
 * And then read line by line: "PAHNAPLSIIGYIR"
 * 
 * Write the code that will take a string and make this conversion given a
 * number of rows:
 * 
 * string convert(string text, int nRows);
 * 
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 *
 */
public class ZigZagConvert {

	public String convert(String s, int nRows) {
		if (nRows < 1) {
			throw new IllegalArgumentException("");
		}

		if (nRows == 1) {
			return s;
		}

		int indent = (nRows - 1) * 2;
		int length = s.length();
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < nRows; ++i) {
			int idt = indent - 2 * i;
			int idx = i;
			if (idt == indent || idt == 0) {
				while (idx < length) {
					buf.append(s.charAt(idx));
					idx += indent;
				}
			} else {
				while (idx < length) {
					buf.append(s.charAt(idx));
					idx += idt;
					idt = indent - idt;
				}
			}
		}
		return buf.toString();
	}
}
