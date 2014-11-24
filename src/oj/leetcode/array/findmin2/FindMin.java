package oj.leetcode.array.findmin2;

/**
 *
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * 
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * 
 * Find the minimum element.
 * 
 * The array may contain duplicates.
 *
 */
public class FindMin {

	public int findMin(int[] num) {
		if (num == null || num.length == 0) {
			throw new IllegalArgumentException();
		}

		int middle = num.length / 2;
		int left_min = findMin(num, 0, middle);
		int right_min = findMin(num, middle, num.length);

		int min = (num[left_min] <= num[right_min] ? left_min : right_min);
		return num[min];
	}

	private int findMin(int[] num, int begin, int end) {
		int span = end - begin;

		if (span < 0) {
			throw new IllegalArgumentException("begin is less than end!");
		}

		if (span < 2) {
			return begin;
		}

		int middle = (end + begin) / 2;
		int left_min = findMin(num, begin, middle);
		int right_min = findMin(num, middle, end);
		return (num[left_min] <= num[right_min] ? left_min : right_min);
	}
}
