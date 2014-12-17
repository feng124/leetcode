package oj.leetcode.tree.order.same;

import java.util.ArrayDeque;
import java.util.Deque;

import oj.leetcode.tree.TreeNode;

/**
 * 
 * Given two binary trees, write a function to check if they are equal or not.
 * 
 * Two binary trees are considered equal if they are structurally identical and
 * the nodes have the same value.
 * 
 */
public class SameTree {
	
	private final Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
	
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		}
		
		boolean is_same = false;
		if (p != null && q != null) {
			is_same = true;
			stack.addFirst(p);
			stack.addLast(q);
			while(!stack.isEmpty()) {
				TreeNode left = stack.pollFirst();
				TreeNode right = stack.pollLast();
				
				if (left.val != right.val) {
					stack.clear();
					is_same = false;
					break;
				}
				
				is_same = push2Stack(left.right, right.right);
				if (!is_same) {
					stack.clear();
					break;
				}
				is_same = push2Stack(left.left, right.left);
				if (!is_same) {
					stack.clear();
					break;
				}
			}
		}
		return is_same;
	}

	private boolean push2Stack(TreeNode left, TreeNode right) {
		
		if (left == null && right == null) {
			return true;
		}
		
		if (left != null && right != null) {
			stack.addFirst(left);
			stack.addLast(right);
			return true;
		}
		
		return false;
	}
}
