package oj.leetcode.tree.maxdepth;

import java.util.ArrayDeque;
import java.util.Deque;

import oj.leetcode.tree.TreeNode;

/**
 * 
 * Given a binary tree, find its maximum depth.
 * 
 * The maximum depth is the number of nodes along the longest path from the root
 * node down to the farthest leaf node.
 *
 */
public class MaxDepth {

	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int max_depth = Integer.MIN_VALUE;
		final Deque<TreeEntry> stack = new ArrayDeque<TreeEntry>();
		stack.push(new TreeEntry(root, 1));
		while (!stack.isEmpty()) {
			TreeEntry cur = stack.pop();
			TreeNode node = cur.node;
			if (node.left == null && node.right == null) {
				int depth = cur.depth;
				if (depth > max_depth) {
					max_depth = depth;
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

		return max_depth;
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
