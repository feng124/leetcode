package oj.leetcode.tree.order.zigzag;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

import oj.leetcode.tree.TreeNode;

/**
 * 
 * Given a binary tree, return the zigzag level order traversal of its nodes'
 * values. (ie, from left to right, then right to left for the next level and
 * alternate between).
 * 
 * For example: Given binary tree {3,9,20,#,#,15,7},
 * 
 *       3
 *      / \
 *     9  20
 *        / \
 *       15  7
 * 
 * return its zigzag level order traversal as:
 * 
 * [ 
 *   [3], 
 *   [20,9], 
 *   [15,7]
 * ]
 * 
 * confused what "{1,#,2,3}" means?
 *
 */
public class ZigZagTraversal {
	
	private final Deque<TreeNode> queue = new ArrayDeque<TreeNode>();

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		if (root == null) {
			return Collections.emptyList();
		}
		
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		queue.addLast(root);
		int level = 0;
		while(!queue.isEmpty()) {
			
			int size = queue.size();
			Integer[] array = new Integer[size];
			for(int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				
				if (level % 2 == 0) {
					array[i] = node.val;
				}else {
					int p = size-i-1;
					array[p] = node.val;
				}
				
				if (node.left != null) {
					queue.addLast(node.left);
				}
				if (node.right != null) {
					queue.addLast(node.right);
				}
			}
			ret.add(Arrays.asList(array));
			
			level++;
		}
		
		return ret;
	}
	
	
}
