package oj.leetcode.tree.order.post;

import static org.junit.Assert.*;

import java.util.List;

import oj.leetcode.tree.TreeBuilder;
import oj.leetcode.tree.TreeNode;

import org.junit.Test;

public class PostorderTraversalTest {
	
	private final PostorderTraversal pt = new PostorderTraversal();

	@Test
	public void test() {
		
		String[] toks = new String[] { "1", "2", "3", "#", "#", "4" };
		TreeNode root = TreeBuilder.buildBinaryTree(toks);
		List<Integer> postorder = pt.postorderTraversal(root);
		assertEquals(postorder.size(), 4);
		assertEquals(postorder.get(0).intValue(), 2);
		assertEquals(postorder.get(1).intValue(), 4);
		assertEquals(postorder.get(2).intValue(), 3);
		assertEquals(postorder.get(3).intValue(), 1);
		
		toks = new String[] { "1" };
		root = TreeBuilder.buildBinaryTree(toks);
		postorder = pt.postorderTraversal(root);
		assertEquals(postorder.size(), 1);
		assertEquals(postorder.get(0).intValue(), 1);
		
		toks = new String[] { "1", "2", "3", "#", "#", "#", "4", "5" };
		root = TreeBuilder.buildBinaryTree(toks);
		postorder = pt.postorderTraversal(root);
		assertEquals(postorder.size(), 5);
		assertEquals(postorder.get(0).intValue(), 2);
		assertEquals(postorder.get(1).intValue(), 5);
		assertEquals(postorder.get(2).intValue(), 4);
		assertEquals(postorder.get(3).intValue(), 3);
		assertEquals(postorder.get(4).intValue(), 1);
	}
	
}
