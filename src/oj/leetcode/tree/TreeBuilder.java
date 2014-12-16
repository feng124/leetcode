package oj.leetcode.tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class TreeBuilder {

	public static TreeNode buildBinaryTree(String[] toks) {
		if (toks == null || toks.length == 0) {
			return null;
		}

		if (toks[0].equals("#")) {
			throw new IllegalArgumentException();
		}

		final Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
		TreeNode root = new TreeNode(Integer.parseInt(toks[0]));
		queue.addLast(root);
		for (int i = 1; i < toks.length; i += 2) {
			TreeNode cur = queue.pollFirst();
			if (!toks[i].equals("#")) {
				cur.left = new TreeNode(Integer.parseInt(toks[i]));
				queue.addLast(cur.left);
			}
			if (!toks[i+1].equals("#")) {
				cur.right = new TreeNode(Integer.parseInt(toks[i+1]));
				queue.addLast(cur.right);
			}
			
		}
		return root;
	}
}
