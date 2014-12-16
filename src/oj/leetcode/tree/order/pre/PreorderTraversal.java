package oj.leetcode.tree.order.pre;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

/**
 * 
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * 
 * For example: Given binary tree {1,#,2,3},
 * 
 *    1
 *     \
 *      2
 *     / 
 *    3
 * 
 * return [1,2,3].
 * 
 * Note: Recursive solution is trivial, could you do it iteratively?
 *
 */
public class PreorderTraversal {
	
	private final Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
	
	public List<Integer> preorderTraversal(TreeNode root) {
		if (root == null) {
			return Collections.emptyList();
		}
		
		List<Integer> ret = new ArrayList<Integer>();
		stack.clear();
		stack.push(root);
		while(!stack.isEmpty()) {
			TreeNode cur = stack.pop();
			ret.add(cur.val);
			if (cur.right != null) {
				stack.push(cur.right);
			}
			if (cur.left != null) {
				stack.push(cur.left);
			}
		}
		
		return ret;
	}
}
