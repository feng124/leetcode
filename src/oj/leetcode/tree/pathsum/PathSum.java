package oj.leetcode.tree.pathsum;

import java.util.ArrayDeque;
import java.util.Deque;

import oj.leetcode.tree.TreeNode;

/**
 * 
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path
 * such that adding up all the values along the path equals the given sum. For
 * example: Given the below binary tree and sum = 22,
 * 
 *          5
 *         / \
 *        4   8
 *       /   / \ 
 *      11  13  4 
 *     / \       \ 
 *    7   2       1
 * 
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 *
 */
public class PathSum {

	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) {
			return false;
		}

		final Deque<TreeEntry> stack = new ArrayDeque<TreeEntry>();
		stack.push(new TreeEntry(root, 0));
		while (!stack.isEmpty()) {
			TreeEntry cur = stack.pop();
			TreeNode node = cur.node;
			if (node.left == null && node.right == null) {
				int path_sum = cur.path_sum + node.val;
				if (path_sum == sum) {
					return true;
				}
			}
			if (node.left != null) {
				int path_sum = cur.path_sum + node.val;
				stack.push(new TreeEntry(node.left, path_sum));
			}
			if (node.right != null) {
				int path_sum = cur.path_sum + node.val;
				stack.push(new TreeEntry(node.right, path_sum));
			}
		}

		return false;
	}

	class TreeEntry {
		TreeNode node;
		int path_sum;

		TreeEntry(TreeNode node, int path_sum) {
			this.node = node;
			this.path_sum = path_sum;
		}
	}

}
