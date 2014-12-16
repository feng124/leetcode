package oj.leetcode.tree.order.level;

import static org.junit.Assert.*;

import java.util.List;

import oj.leetcode.tree.TreeBuilder;
import oj.leetcode.tree.TreeNode;

import org.junit.Test;

public class LevelOrderTraversalTest {

	private final LevelOrderTraversal inst = new LevelOrderTraversal();

	@Test
	public void test() {

		TreeNode tree = TreeBuilder.buildBinaryTree(new String[] { "3", "9", "20", "#",
				"#", "15", "7" });
		List<List<Integer>> level_lists = inst.levelOrder(tree);
		assertEquals(level_lists.size(), 3);
		List<Integer> level_vals = level_lists.get(0);
		assertEquals(level_vals.size(), 1);
		assertEquals(level_vals.get(0).intValue(), 3);
		level_vals = level_lists.get(1);
		assertEquals(level_vals.size(), 2);
		assertEquals(level_vals.get(0).intValue(), 9);
		assertEquals(level_vals.get(1).intValue(), 20);
		level_vals = level_lists.get(2);
		assertEquals(level_vals.size(), 2);
		assertEquals(level_vals.get(0).intValue(), 15);
		assertEquals(level_vals.get(1).intValue(), 7);
		
		tree = TreeBuilder.buildBinaryTree(new String[] { "5", "4", "8", "11",
				"#", "13", "4", "7", "2", "#", "#", "#", "1" });
		level_lists = inst.levelOrder(tree);
		assertEquals(level_lists.size(), 4);
		level_vals = level_lists.get(0);
		assertEquals(level_vals.size(), 1);
		assertEquals(level_vals.get(0).intValue(), 5);
		level_vals = level_lists.get(1);
		assertEquals(level_vals.size(), 2);
		assertEquals(level_vals.get(0).intValue(), 4);
		assertEquals(level_vals.get(1).intValue(), 8);
		level_vals = level_lists.get(2);
		assertEquals(level_vals.size(), 3);
		assertEquals(level_vals.get(0).intValue(), 11);
		assertEquals(level_vals.get(1).intValue(), 13);
		assertEquals(level_vals.get(2).intValue(), 4);
		level_vals = level_lists.get(3);
		assertEquals(level_vals.size(), 3);
		assertEquals(level_vals.get(0).intValue(), 7);
		assertEquals(level_vals.get(1).intValue(), 2);
		assertEquals(level_vals.get(2).intValue(), 1);
	}

}
