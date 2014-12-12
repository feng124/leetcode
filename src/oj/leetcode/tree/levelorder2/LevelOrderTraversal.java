package oj.leetcode.tree.levelorder2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 
 * Given a binary tree, return the bottom-up level order traversal of its nodes'
 * values. (ie, from left to right, level by level from leaf to root).
 * 
 * For example: Given binary tree {3,9,20,#,#,15,7},
 * 
 *      3 
 *     / \ 
 *    9  20 
 *       / \ 
 *      15  7
 * 
 * return its bottom-up level order traversal as:
 * 
 * [ 
 *   [15,7], 
 *   [9,20], 
 *   [3] 
 * ]
 *
 */
public class LevelOrderTraversal {
	
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		final List<List<Integer>> ret = new ArrayList<List<Integer>>();
		if (root != null) {
			final Deque<TreeEntry> queue = new ArrayDeque<TreeEntry>();
			final Deque<TreeEntry> stack = new ArrayDeque<TreeEntry>();
			int max_depth = Integer.MIN_VALUE;
			stack.push(new TreeEntry(root, 0));
			while(!stack.isEmpty()) {
				TreeEntry entry = stack.pop();
				int depth = entry.depth;
				
				TreeNode node = entry.node;
				if (node.right != null) {
					stack.push(new TreeEntry(node.right, depth+1));
				}
				if (node.left != null) {
					stack.push(new TreeEntry(node.left, depth+1));
				}
				
				if (depth > max_depth) {
					max_depth = depth;
				}
				queue.addLast(entry);
			}
			
			for(int i = 0; i <= max_depth; i++) {
				ret.add(new ArrayList<Integer>());
			}
			
			for(TreeEntry entry : queue) {
				int index = max_depth - entry.depth;
				List<Integer> list = ret.get(index);
				list.add(entry.node.val);
			}
			queue.clear();
		}
		
		return ret;
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
