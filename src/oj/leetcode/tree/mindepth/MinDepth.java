package oj.leetcode.tree.mindepth;

import java.util.ArrayDeque;
import java.util.Deque;

import oj.leetcode.tree.TreeNode;

/**
 * 
 * Given a binary tree, find its minimum depth.
 * 
 * The minimum depth is the number of nodes along the shortest path from the
 * root node down to the nearest leaf node.
 *
 */
public class MinDepth {

	public int minDepth(TreeNode root) {
		
		if (root == null) {
			return 0;
		}

		int min_depth = Integer.MAX_VALUE;
		final Deque<TreeEntry> stack = new ArrayDeque<TreeEntry>();
		stack.push(new TreeEntry(root, 1));
		while (!stack.isEmpty()) {
			TreeEntry cur = stack.pop();
			TreeNode node = cur.node;
			if (node.left == null && node.right == null) {
				int depth = cur.depth;
				if (depth < min_depth) {
					min_depth = depth;
				}
			}
			if (node.left != null) {
				int depth = cur.depth + 1;
				stack.push(new TreeEntry(node.left, depth));
			}
			if (node.right != null) {
				int depth = cur.depth + 1;
				stack.push(new TreeEntry(node.right, depth));
			}
		}

		return min_depth;
		
	}

	class TreeEntry {

		TreeNode node;
		int depth;

		TreeEntry(TreeNode node, int depth) {
			this.node = node;
			this.depth = depth;
		}
	}
}
