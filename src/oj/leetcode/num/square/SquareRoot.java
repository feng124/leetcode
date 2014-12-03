package oj.leetcode.num.square;

/**
 * 
 * Implement int sqrt(int x).
 * 
 * Compute and return the square root of x.
 *
 */
public class SquareRoot {

	private final static double SQUARE_2 = Math.sqrt(2);

	public int sqrt(int x) {
		if (x < 0) {
			throw new IllegalArgumentException("x is less than 0!");
		}

		int ret = 0;
		int r = 0;
		long bound = 1L;
		while (bound < x) {
			r++;
			bound = bound << 1;
		}

		ret = 1 << (r / 2);
		if ((r % 2) == 1) {
			ret = (int) Math.floor(ret * SQUARE_2);
			bound = ret * ret;
		}
		if (bound > x) {
			while (ret >= 0) {
				if (bound <= x) {
					break;
				}
				bound = bound - 2 * ret + 1;
				ret -= 1;
			}
		}

		return ret;
	}

}
