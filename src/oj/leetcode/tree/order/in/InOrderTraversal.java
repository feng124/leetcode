package oj.leetcode.tree.order.in;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

import oj.leetcode.tree.TreeNode;

/**
 * 
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * 
 * For example: Given binary tree { 1, #, 2, 3 },
 * 
 *    1
 *     \
 *      2
 *     /
 *    3
 * 
 * return [1,3,2].
 * 
 * Note: Recursive solution is trivial, could you do it iteratively?
 *
 */
public class InOrderTraversal {
	
	private final Deque<TreeNode> stack = new ArrayDeque<TreeNode>();

	public List<Integer> inorderTraversal(TreeNode root) {
		
		if (root == null) {
			return Collections.emptyList();
		}
		
		List<Integer> ret = new ArrayList<Integer>();
		final List<TreeNode> visited = new ArrayList<TreeNode>();
		stack.push(root);
		while(!stack.isEmpty()) {
			TreeNode cur = stack.peek();
			if (cur.left != null && !visited.contains(cur.left)) {
				stack.push(cur.left);
				continue;
			}
			ret.add(cur.val);
			visited.add(cur);
			stack.pop();
			if (cur.right != null) {
				stack.push(cur.right);
			}
		}
		visited.clear();
		
		return ret;
	}
	
}
