package oj.leetcode.tree.order.pre;

import static org.junit.Assert.*;

import java.util.List;

import oj.leetcode.tree.TreeBuilder;
import oj.leetcode.tree.TreeNode;

import org.junit.Test;

public class PreorderTraversalTest {

	@Test
	public void test() {

		PreorderTraversal pt = new PreorderTraversal();
		TreeNode root = TreeBuilder.buildBinaryTree(null);
		List<Integer> preorder_list = pt.preorderTraversal(root);
		assertEquals(preorder_list.size(), 0);

		String[] toks = new String[] { "1", "2", "3", "#", "#", "4" };
		root = TreeBuilder.buildBinaryTree(toks);
		preorder_list = pt.preorderTraversal(root);
		assertEquals(preorder_list.size(), 4);
		assertEquals(preorder_list.get(0).intValue(), 1);
		assertEquals(preorder_list.get(1).intValue(), 2);
		assertEquals(preorder_list.get(2).intValue(), 3);
		assertEquals(preorder_list.get(3).intValue(), 4);
		
		toks = new String[] { "1", "2", "3", "#", "#", "#", "4" };
		root = TreeBuilder.buildBinaryTree(toks);
		preorder_list = pt.preorderTraversal(root);
		assertEquals(preorder_list.size(), 4);
		assertEquals(preorder_list.get(0).intValue(), 1);
		assertEquals(preorder_list.get(1).intValue(), 2);
		assertEquals(preorder_list.get(2).intValue(), 3);
		assertEquals(preorder_list.get(3).intValue(), 4);
		
		toks = new String[] { "1", "2", "4", "#", "#", "#", "3" };
		root = TreeBuilder.buildBinaryTree(toks);
		preorder_list = pt.preorderTraversal(root);
		assertEquals(preorder_list.size(), 4);
		assertEquals(preorder_list.get(0).intValue(), 1);
		assertEquals(preorder_list.get(1).intValue(), 2);
		assertEquals(preorder_list.get(2).intValue(), 4);
		assertEquals(preorder_list.get(3).intValue(), 3);
		
		
		toks = new String[] {"1", "#", "2", "3"};
		root = TreeBuilder.buildBinaryTree(toks);
		preorder_list = pt.preorderTraversal(root);
		assertEquals(preorder_list.size(), 3);
		assertEquals(preorder_list.get(0).intValue(), 1);
		assertEquals(preorder_list.get(1).intValue(), 2);
		assertEquals(preorder_list.get(2).intValue(), 3);
	}

}
