package oj.leetcode.num.reverse;

/**
 * 
 * Reverse digits of an integer.
 * 
 * Example1: x = 123, return 321 Example2: x = -123, return -321
 *
 */
public class ReverseInteger {
	
	public int reverse(int x) {
		int sign = (int) Math.signum(x);
		int num = x * sign;
		int res = 0;
		double ret = 0L;
		while (num != 0) {
			res = num % 10;
			num = (num - res) / 10;
			ret = ret * 10 + res;
		}
		if (ret > Integer.MAX_VALUE || ret < Integer.MIN_VALUE) {
			return 0;
		}
		return (int) ((int)sign * ret);
	}
}
