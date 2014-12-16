package oj.leetcode.tree.balanced;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

import oj.leetcode.tree.TreeNode;

/**
 * 
 * Given a binary tree, determine if it is height-balanced.
 * 
 * For this problem, a height-balanced binary tree is defined as a binary tree
 * in which the depth of the two subtrees of every node never differ by more
 * than 1.
 *
 */
public class BalancedBinaryTree {

	private final Deque<TreeNode> stack = new ArrayDeque<TreeNode>();

	private final Map<TreeNode, Integer> visited_map = new HashMap<TreeNode, Integer>();

	public boolean isBalanced(TreeNode root) {

		if (root == null) {
			return true;
		}

		stack.push(root);
		boolean is_balanced = true;
		while (!stack.isEmpty()) {
			TreeNode cur = stack.peek();

			if (cur.left == null && cur.right == null) {
				visited_map.put(cur, 1);
				stack.pop();
				continue;
			}

			int right_height = -1;
			if (cur.right == null) {
				right_height = 0;
			} else if (visited_map.containsKey(cur.right)) {
				right_height = visited_map.get(cur.right);
			}

			int left_height = -1;
			if (cur.left == null) {
				left_height = 0;
			} else if (visited_map.containsKey(cur.left)) {
				left_height = visited_map.get(cur.left);
			}

			if (right_height != -1 && left_height != -1) {
				int diff = left_height - right_height;
				if (diff >= 2 || diff <= -2) {
					is_balanced = false;
					break;
				}
				int height = (left_height > right_height ? left_height
						: right_height) + 1;
				visited_map.put(cur, height);
				stack.pop();
			}
			
			if (right_height == -1) {
				stack.push(cur.right);
			}
			if (left_height == -1) {
				stack.push(cur.left);
			}
		}

		stack.clear();
		visited_map.clear();

		return is_balanced;
	}

}
