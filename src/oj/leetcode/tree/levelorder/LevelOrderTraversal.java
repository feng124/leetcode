package oj.leetcode.tree.levelorder;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 
 * Given a binary tree, return the level order traversal of its nodes' values.
 * (ie, from left to right, level by level).
 * 
 * For example: Given binary tree {3,9,20,#,#,15,7},
 * 
 *     3 
 *    / \ 
 *   9  20 
 *      / \ 
 *     15  7
 * 
 * return its level order traversal as:
 * 
 * [ 
 *   [3], 
 *   [9,20], 
 *   [15,7] 
 * ]
 *
 */
public class LevelOrderTraversal {

	public List<List<Integer>> levelOrder(TreeNode root) {
		final List<List<Integer>> ret = new ArrayList<List<Integer>>();
		if (root != null) {
		
			final Deque<TreeEntry> queue = new ArrayDeque<TreeEntry>();
			queue.addLast(new TreeEntry(root, 0));
			while(!queue.isEmpty()) {
				TreeEntry entry = queue.pollFirst();
				
				int depth = entry.depth;
				TreeNode node = entry.node;
				if (node.left != null) {
					queue.addLast(new TreeEntry(node.left, depth+1));
				}
				if (node.right != null) {
					 queue.addLast(new TreeEntry(node.right, depth+1));
				}
				
				addEntry(ret, entry);
			}
		
		}
		return ret;
	}
	
	private void addEntry(List<List<Integer>> res, TreeEntry entry) {
		int depth = entry.depth;
		if (depth == res.size()) {
			res.add(new ArrayList<Integer>());
		}
		List<Integer> level_list = res.get(depth);
		level_list.add(entry.node.val);
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
