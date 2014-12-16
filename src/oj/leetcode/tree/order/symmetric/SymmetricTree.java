package oj.leetcode.tree.order.symmetric;

import java.util.ArrayDeque;
import java.util.Deque;

import oj.leetcode.tree.TreeNode;

/**
 * 
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric
 * around its center).
 * 
 * For example, this binary tree is symmetric:
 * 
 *         1
 *        / \
 *       2   2
 *      / \ / \
 *     3  4 4  3
 * 
 * But the following is not:
 * 
 *         1
 *        / \
 *       2   2
 *        \   \ 
 *         3   3
 * 
 * Note: Bonus points if you could solve it both recursively and iteratively.
 *
 */
public class SymmetricTree {

	boolean recursive = false;

	public boolean isSymmetric(TreeNode root) {

		if (root == null) {
			return true;
		}

		if (recursive) {
			return isSymmetricInRecursive(root.left, root.right);
		} else {
			return isSymmetricInIterative(root.left, root.right);
		}
	}

	private boolean isSymmetricInIterative(TreeNode left, TreeNode right) {

		if (left == null && right == null) {
			return true;
		}

		boolean symmetric = false;
		if (left != null && right != null) {
			final Deque<TreeNode> deque = new ArrayDeque<TreeNode>();
			deque.addFirst(left);
			deque.addLast(right);
			symmetric = true;
			while (!deque.isEmpty()) {
				TreeNode left_node = deque.pollFirst();
				TreeNode right_node = deque.pollLast();
				if (left_node.val != right_node.val) {
					symmetric = false;
					break;
				}

				if (left_node.left == null && right_node.right != null) {
					symmetric = false;
					break;
				}
				if (left_node.left != null && right_node.right == null) {
					symmetric = false;
					break;
				}
				if (left_node.left != null && right_node.right != null) {
					deque.addFirst(left_node.left);
					deque.addLast(right_node.right);
				}

				if (left_node.right == null && right_node.left != null) {
					symmetric = false;
					break;
				}
				if (left_node.right != null && right_node.left == null) {
					symmetric = false;
					break;
				}
				if (left_node.right != null && right_node.left != null) {
					deque.addFirst(left_node.right);
					deque.addLast(right_node.left);
				}
			}
		}
		return symmetric;
	}

	private boolean isSymmetricInRecursive(TreeNode left, TreeNode right) {
		if (left == null && right == null) {
			return true;
		}

		if (left != null && right != null) {
			if (left.val != right.val) {
				return false;
			}

			boolean symmetric = isSymmetricInRecursive(left.left, right.right);
			if (symmetric) {
				symmetric = isSymmetricInRecursive(left.right, right.left);
			}
			return symmetric;
		}
		return false;

	}

}
