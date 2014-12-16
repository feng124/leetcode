package oj.leetcode.tree.order.pre;

import static org.junit.Assert.*;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

import org.junit.Test;

public class PreorderTraversalTest {

	@Test
	public void test() {

		PreorderTraversal pt = new PreorderTraversal();
		TreeNode root = buildBinTree(null);
		List<Integer> preorder_list = pt.preorderTraversal(root);
		assertEquals(preorder_list.size(), 0);

		String[] toks = new String[] { "1", "2", "3", "#", "#", "4" };
		root = buildBinTree(toks);
		preorder_list = pt.preorderTraversal(root);
		assertEquals(preorder_list.size(), 4);
		assertEquals(preorder_list.get(0).intValue(), 1);
		assertEquals(preorder_list.get(1).intValue(), 2);
		assertEquals(preorder_list.get(2).intValue(), 3);
		assertEquals(preorder_list.get(3).intValue(), 4);
		
		toks = new String[] { "1", "2", "3", "#", "#", "#", "4" };
		root = buildBinTree(toks);
		preorder_list = pt.preorderTraversal(root);
		assertEquals(preorder_list.size(), 4);
		assertEquals(preorder_list.get(0).intValue(), 1);
		assertEquals(preorder_list.get(1).intValue(), 2);
		assertEquals(preorder_list.get(2).intValue(), 3);
		assertEquals(preorder_list.get(3).intValue(), 4);
		
		toks = new String[] { "1", "2", "4", "#", "#", "#", "3" };
		root = buildBinTree(toks);
		preorder_list = pt.preorderTraversal(root);
		assertEquals(preorder_list.size(), 4);
		assertEquals(preorder_list.get(0).intValue(), 1);
		assertEquals(preorder_list.get(1).intValue(), 2);
		assertEquals(preorder_list.get(2).intValue(), 4);
		assertEquals(preorder_list.get(3).intValue(), 3);
		
		
		toks = new String[] {"1", "#", "2", "3"};
		root = buildBinTree(toks);
		preorder_list = pt.preorderTraversal(root);
		assertEquals(preorder_list.size(), 3);
		assertEquals(preorder_list.get(0).intValue(), 1);
		assertEquals(preorder_list.get(1).intValue(), 2);
		assertEquals(preorder_list.get(2).intValue(), 3);
	}

	private TreeNode buildBinTree(String[] toks) {
		if (toks == null || toks.length == 0) {
			return null;
		}

		if (toks[0].equals("#")) {
			throw new IllegalArgumentException();
		}

		final Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
		TreeNode root = new TreeNode(Integer.parseInt(toks[0]));
		stack.push(root);
		for (int i = 1; i < toks.length;) {
			TreeNode cur = stack.pop();
			if ((i + 1) < toks.length) {
				if (!toks[i + 1].equals("#")) {
					cur.right = new TreeNode(Integer.parseInt(toks[i + 1]));
					stack.push(cur.right);
				}
			}
			if (!toks[i].equals("#")) {
				cur.left = new TreeNode(Integer.parseInt(toks[i]));
				stack.push(cur.left);
			}
			i += 2;
		}
		return root;
	}

}
