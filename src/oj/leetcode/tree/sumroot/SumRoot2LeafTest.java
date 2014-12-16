package oj.leetcode.tree.sumroot;

import static org.junit.Assert.*;

import oj.leetcode.tree.TreeBuilder;
import oj.leetcode.tree.TreeNode;

import org.junit.Test;

public class SumRoot2LeafTest {
	
	private final SumRoot2Leaf inst = new SumRoot2Leaf();

	@Test
	public void test() {
		TreeNode root = TreeBuilder.buildBinaryTree(new String[] { "5", "4", "8", "1",
				"#", "3", "4", "7", "2", "#", "#", "#", "1" });
		int sum = inst.sumNumbers(root);
		assertEquals(sum, 17253);
		
		root = TreeBuilder.buildBinaryTree(new String[] {"5"});
		sum = inst.sumNumbers(root);
		assertEquals(sum, 5);
	}
	

}
