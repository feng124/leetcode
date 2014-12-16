package oj.leetcode.tree.order.in;

import static org.junit.Assert.*;

import java.util.List;

import oj.leetcode.tree.TreeBuilder;
import oj.leetcode.tree.TreeNode;

import org.junit.Test;

public class InOrderTraversalTest {

	private final InOrderTraversal inst = new InOrderTraversal();

	@Test
	public void test() {

		TreeNode tree = TreeBuilder.buildBinaryTree(new String[] { "5", "4",
				"8", "11", "#", "13", "4", "7", "2", "#", "#", "#", "1" });
		List<Integer> ret = inst.inorderTraversal(tree);
		assertEquals(ret.size(), 9);
		int[] A = toArray(ret);
		assertArrayEquals(A, new int[] { 7, 11, 2, 4, 5, 13, 8, 4, 1 });

		tree = TreeBuilder.buildBinaryTree(new String[] { "1", "#", "2", "3",
				"#" });
		ret = inst.inorderTraversal(tree);
		assertEquals(ret.size(), 3);
		A = toArray(ret);
		assertArrayEquals(A, new int[] { 1, 3, 2 });
		
		tree = TreeBuilder.buildBinaryTree(new String[] {"1", "2", "#", "#", "3"});
		ret = inst.inorderTraversal(tree);
		assertEquals(ret.size(), 3);
		A = toArray(ret);
		assertArrayEquals(A, new int[] {2, 3, 1});
	}
	
	private int[] toArray(List<Integer> list) {
		int[] ret = new int[list.size()];
		for(int i = 0; i < list.size(); i++) {
			ret[i] = list.get(i);
		}
		return ret;
	}

}
