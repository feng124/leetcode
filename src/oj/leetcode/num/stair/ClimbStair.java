package oj.leetcode.num.stair;

/**
 * 
 * You are climbing a stair case. It takes n steps to reach to the top.
 * 
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can
 * you climb to the top?
 *
 */
public class ClimbStair {

	public int climbStairs(int n) {

		// if (n == 1) {
		// return 1;
		// }
		// if (n == 2) {
		// return 2;
		// }
		//
		// return climbStairs(n - 1) + climbStairs(n - 2);

		if (n == 1) {
			return 1;
		}
		if (n == 2) {
			return 2;
		}

		int step_1 = 1;
		int step_2 = 2;
		for (int i = 3; i < n; i++) {
			int tmp = step_2;
			step_2 += step_1;
			step_1 = tmp;
		}
		return (step_1 + step_2);

	}
}
