package oj.leetcode.tree.pathsum2;

import static org.junit.Assert.*;

import java.util.List;

import oj.leetcode.tree.TreeBuilder;
import oj.leetcode.tree.TreeNode;

import org.junit.Test;

public class PathSumTest {

	private final PathSum inst = new PathSum();

	@Test
	public void test() {
		TreeNode tree = TreeBuilder.buildBinaryTree(new String[] { "5", "4",
				"8", "11", "#", "13", "4", "7", "2", "#", "#", "5", "1" });
		int sum = 22;
		List<List<Integer>> res = inst.pathSum(tree, sum);
		assertEquals(res.size(), 2);
		int[][] arrays = toArrays(res);
		assertArrayEquals(arrays[0], new int[] { 5, 4, 11, 2 });
		assertArrayEquals(arrays[1], new int[] { 5, 8, 4, 5 });

		sum = 20;
		res = inst.pathSum(tree, sum);
		assertEquals(res.size(), 0);

		tree = TreeBuilder.buildBinaryTree(new String[] { "5" });
		sum = 5;
		res = inst.pathSum(tree, sum);
		assertEquals(res.size(), 1);
		arrays = toArrays(res);
		assertArrayEquals(arrays[0], new int[] { 5 });
		
		sum = 6;
		res = inst.pathSum(tree, sum);
		assertEquals(res.size(), 0);
	}

	private int[][] toArrays(List<List<Integer>> res) {
		int[][] ret = new int[res.size()][];
		for (int i = 0; i < res.size(); i++) {
			ret[i] = toArray(res.get(i));
		}
		return ret;
	}

	private int[] toArray(List<Integer> list) {
		int[] ret = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			ret[i] = list.get(i);
		}
		return ret;
	}

}
