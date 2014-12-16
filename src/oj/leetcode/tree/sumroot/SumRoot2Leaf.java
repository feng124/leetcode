package oj.leetcode.tree.sumroot;

import java.util.ArrayDeque;
import java.util.Deque;

import oj.leetcode.tree.TreeNode;

/**
 * 
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path
 * could represent a number.
 * 
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * 
 * Find the total sum of all root-to-leaf numbers.
 * 
 * For example,
 * 
 * 1 / \ 2 3
 * 
 * The root-to-leaf path 1->2 represents the number 12.
 * 
 * The root-to-leaf path 1->3 represents the number 13.
 * 
 * Return the sum = 12 + 13 = 25.
 *
 */
public class SumRoot2Leaf {

	private final Deque<TreeEntry> stack = new ArrayDeque<TreeEntry>();

	public int sumNumbers(TreeNode root) {

		int sum = 0;
		if (root != null) {
			stack.push(new TreeEntry(root, root.val));
			while (!stack.isEmpty()) {
				TreeEntry cur = stack.pop();
				TreeNode node = cur.node;
				if (node.left == null && node.right == null) {
					sum += cur.val;
				}

				int val = cur.val * 10;
				if (node.right != null) {
					stack.push(new TreeEntry(node.right, val + node.right.val));
				}
				if (node.left != null) {
					stack.push(new TreeEntry(node.left, val + node.left.val));
				}
			}
		}

		return sum;

	}

	class TreeEntry {
		TreeNode node;
		int val;

		TreeEntry(TreeNode node, int val) {
			this.node = node;
			this.val = val;
		}
	}
}
