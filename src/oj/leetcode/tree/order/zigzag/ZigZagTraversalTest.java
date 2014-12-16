package oj.leetcode.tree.order.zigzag;

import static org.junit.Assert.*;

import java.util.List;

import oj.leetcode.tree.TreeBuilder;
import oj.leetcode.tree.TreeNode;

import org.junit.Test;

public class ZigZagTraversalTest {

	private final ZigZagTraversal inst = new ZigZagTraversal();

	@Test
	public void test() {
		TreeNode tree = TreeBuilder.buildBinaryTree(new String[] { "5", "4",
				"8", "11", "#", "13", "4", "7", "2", "#", "#", "#", "1" });
		List<List<Integer>> ret = inst.zigzagLevelOrder(tree);
		assertEquals(ret.size(), 4);
		int[] array = toArray(ret.get(0));
		assertArrayEquals(array, new int[] { 5 });
		array = toArray(ret.get(1));
		assertArrayEquals(array, new int[] { 8, 4 });
		array = toArray(ret.get(2));
		assertArrayEquals(array, new int[] { 11, 13, 4 });
		array = toArray(ret.get(3));
		assertArrayEquals(array, new int[] { 1, 2, 7 });

		tree = TreeBuilder.buildBinaryTree(new String[] { "3", "9", "20", "#",
				"#", "15", "7" });
		ret = inst.zigzagLevelOrder(tree);
		assertEquals(ret.size(), 3);
		array = toArray(ret.get(0));
		assertArrayEquals(array, new int[] { 3 });
		array = toArray(ret.get(1));
		assertArrayEquals(array, new int[] { 20, 9 });
		array = toArray(ret.get(2));
		assertArrayEquals(array, new int[] { 15, 7 });

		tree = TreeBuilder.buildBinaryTree(new String[] { "6" });
		ret = inst.zigzagLevelOrder(tree);
		assertEquals(ret.size(), 1);
		array = toArray(ret.get(0));
		assertArrayEquals(array, new int[] { 6 });
	}

	private int[] toArray(List<Integer> list) {
		int[] array = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			array[i] = list.get(i);
		}
		return array;
	}

}
