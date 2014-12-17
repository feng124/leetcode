package oj.leetcode.tree.pathsum2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

import oj.leetcode.tree.TreeNode;

/**
 * 
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's
 * sum equals the given sum. For example: Given the below binary tree and sum =
 * 22,
 * 
 *               5
 *              / \ 
 *             4   8 
 *            /   / \ 
 *           11  13  4 
 *          / \     / \ 
 *         7   2   5   1
 * 
 * return
 * 
 * [ 
 *   [5,4,11,2], 
 *   [5,8,4,5] 
 * ]
 *
 */
public class PathSum {

	private final Deque<TreeEntry> stack = new ArrayDeque<TreeEntry>();

	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		if (root == null) {
			return Collections.emptyList();
		}

		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		stack.push(new TreeEntry(root, null, 0));
		while (!stack.isEmpty()) {
			TreeEntry entry = stack.pop();
			TreeNode node = entry.node;

			int path_sum = entry.path_sum + node.val;
			if (node.left == null && node.right == null) {
				if (path_sum == sum) {
					List<Integer> path = new ArrayList<Integer>();
					while(entry != null) {
						path.add(0, entry.node.val);
						entry = entry.parent;
					}
					if (!path.isEmpty()) {
						ret.add(path);
					}
				}
			}

			
			if (node.right != null) {
				stack.push(new TreeEntry(node.right, entry, path_sum));
			}
			if (node.left != null) {
				stack.push(new TreeEntry(node.left, entry, path_sum));
			}
		}
		return ret;
	}

	class TreeEntry {
		TreeNode node;
		TreeEntry parent;
		int path_sum;

		TreeEntry(TreeNode node, TreeEntry parent, int path_sum) {
			this.node = node;
			this.parent = parent;
			this.path_sum = path_sum;
		}
	}
}
