package oj.leetcode.tree.levelorder2;

import static org.junit.Assert.*;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

import org.junit.Test;

public class LevelOrderTraversalTest {

	private final LevelOrderTraversal inst = new LevelOrderTraversal();
	
	@Test
	public void test() {
		
		List<List<Integer>> level_lists = inst.levelOrderBottom(null);
		assertEquals(level_lists.size(), 0);
		
		TreeNode tree = buildBinaryTree(new String[] { "3", "9", "20", "#",
				"#", "15", "7" });
		level_lists = inst.levelOrderBottom(tree);
		assertEquals(level_lists.size(), 3);
		List<Integer> level_vals = level_lists.get(2);
		assertEquals(level_vals.size(), 1);
		assertEquals(level_vals.get(0).intValue(), 3);
		level_vals = level_lists.get(1);
		assertEquals(level_vals.size(), 2);
		assertEquals(level_vals.get(0).intValue(), 9);
		assertEquals(level_vals.get(1).intValue(), 20);
		level_vals = level_lists.get(0);
		assertEquals(level_vals.size(), 2);
		assertEquals(level_vals.get(0).intValue(), 15);
		assertEquals(level_vals.get(1).intValue(), 7);
		
		tree = buildBinaryTree(new String[] { "5", "4", "8", "11",
				"#", "13", "4", "7", "2", "#", "#", "#", "1" });
		level_lists = inst.levelOrderBottom(tree);
		assertEquals(level_lists.size(), 4);
		level_vals = level_lists.get(3);
		assertEquals(level_vals.size(), 1);
		assertEquals(level_vals.get(0).intValue(), 5);
		level_vals = level_lists.get(2);
		assertEquals(level_vals.size(), 2);
		assertEquals(level_vals.get(0).intValue(), 4);
		assertEquals(level_vals.get(1).intValue(), 8);
		level_vals = level_lists.get(1);
		assertEquals(level_vals.size(), 3);
		assertEquals(level_vals.get(0).intValue(), 11);
		assertEquals(level_vals.get(1).intValue(), 13);
		assertEquals(level_vals.get(2).intValue(), 4);
		level_vals = level_lists.get(0);
		assertEquals(level_vals.size(), 3);
		assertEquals(level_vals.get(0).intValue(), 7);
		assertEquals(level_vals.get(1).intValue(), 2);
		assertEquals(level_vals.get(2).intValue(), 1);
		
	}
	
	private TreeNode buildBinaryTree(String[] toks) {
		if (toks == null || toks.length == 0) {
			return null;
		}

		if (toks[0].equals("#")) {
			throw new IllegalArgumentException();
		}

		final Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
		TreeNode root = new TreeNode(Integer.parseInt(toks[0]));
		queue.addLast(root);
		for (int i = 1; i < toks.length; i += 2) {
			TreeNode cur = queue.pollFirst();
			if (!toks[i].equals("#")) {
				cur.left = new TreeNode(Integer.parseInt(toks[i]));
				queue.addLast(cur.left);
			}
			if (!toks[i + 1].equals("#")) {
				cur.right = new TreeNode(Integer.parseInt(toks[i + 1]));
				queue.addLast(cur.right);
			}

		}
		return root;
	}

}
