package oj.leetcode.tree.order.post;

import static org.junit.Assert.*;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

import org.junit.Test;

public class PostorderTraversalTest {
	
	private final PostorderTraversal pt = new PostorderTraversal();

	@Test
	public void test() {
		
		String[] toks = new String[] { "1", "2", "3", "#", "#", "4" };
		TreeNode root = buildBinTree(toks);
		List<Integer> postorder = pt.postorderTraversal(root);
		assertEquals(postorder.size(), 4);
		assertEquals(postorder.get(0).intValue(), 2);
		assertEquals(postorder.get(1).intValue(), 4);
		assertEquals(postorder.get(2).intValue(), 3);
		assertEquals(postorder.get(3).intValue(), 1);
		
		toks = new String[] { "1" };
		root = buildBinTree(toks);
		postorder = pt.postorderTraversal(root);
		assertEquals(postorder.size(), 1);
		assertEquals(postorder.get(0).intValue(), 1);
		
		toks = new String[] { "1", "2", "3", "#", "#", "#", "4", "5" };
		root = buildBinTree(toks);
		postorder = pt.postorderTraversal(root);
		assertEquals(postorder.size(), 5);
		assertEquals(postorder.get(0).intValue(), 2);
		assertEquals(postorder.get(1).intValue(), 5);
		assertEquals(postorder.get(2).intValue(), 4);
		assertEquals(postorder.get(3).intValue(), 3);
		assertEquals(postorder.get(4).intValue(), 1);
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
