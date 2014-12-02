package oj.leetcode.tree.postorder;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

/**
 *
 * Given a binary tree, return the postorder traversal of its nodes' values.
 * 
 * For example: Given binary tree {1,#,2,3},
 * 
 *     1
 *      \
 *       2
 *      /
 *     3
 * 
 * return [3,2,1].
 * 
 * Note: Recursive solution is trivial, could you do it iteratively?
 *
 */
public class PostorderTraversal {

	private final Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
	private final List<TreeNode> visited = new ArrayList<TreeNode>();

	public List<Integer> postorderTraversal(TreeNode root) {
		if (root == null) {
			return Collections.emptyList();
		}

		stack.clear();
		visited.clear();

		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode cur = stack.peek();
			if (isVisited(cur.right) && isVisited(cur.left)) {
				visited.add(cur);
				stack.pop();
			}

			if (!isVisited(cur.right)) {
				stack.push(cur.right);
			}
			if (!isVisited(cur.left)) {
				stack.push(cur.left);
			}
		}

		List<Integer> ret = new ArrayList<Integer>();
		for (TreeNode node : visited) {
			ret.add(node.val);
		}
		return ret;
	}

	private boolean isVisited(TreeNode node) {
		if (node == null || visited.contains(node)) {
			return true;
		}

		return false;
	}
}
