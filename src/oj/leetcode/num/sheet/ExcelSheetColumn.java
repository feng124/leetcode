package oj.leetcode.num.sheet;

/**
 * 
 * Given a positive integer, return its corresponding column title as appear in
 * an Excel sheet.
 * 
 * For example:
 * 
 * 1 -> A 2 -> B 3 -> C ... 26 -> Z 27 -> AA 28 -> AB
 *
 */
public class ExcelSheetColumn {

	private final static char[] CHAR_MAP = new char[] { 'Z', 'A', 'B', 'C',
			'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
			'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

	public String convertToTitle(int n) {
		if (n < 1) {
			return null;
		}

		StringBuffer buf = new StringBuffer();
		int num = n;
		do {
			if (num < 27 && num > 0) {
				buf.append(CHAR_MAP[num]);
				break;
			}
			int rem = num - (num / 26) * 26;
			if (rem == 0) {
				rem = 26;
			}
			buf.append(CHAR_MAP[rem]);
			num = num - rem;
			num /= 26;

		} while (true);

		return buf.reverse().toString();
	}

}
