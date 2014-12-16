package oj.leetcode.tree.sumroot;

import static org.junit.Assert.*;

import java.util.ArrayDeque;
import java.util.Deque;

import org.junit.Test;

public class SumRoot2LeafTest {
	
	private final SumRoot2Leaf inst = new SumRoot2Leaf();

	@Test
	public void test() {
		TreeNode root = buildBinaryTree(new String[] { "5", "4", "8", "1",
				"#", "3", "4", "7", "2", "#", "#", "#", "1" });
		int sum = inst.sumNumbers(root);
		assertEquals(sum, 17253);
		
		root = buildBinaryTree(new String[] {"5"});
		sum = inst.sumNumbers(root);
		assertEquals(sum, 5);
	}
	
	private TreeNode buildBinaryTree(String[] toks) {
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
