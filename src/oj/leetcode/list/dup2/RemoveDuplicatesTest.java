package oj.leetcode.list.dup2;

import static org.junit.Assert.*;
import oj.leetcode.list.ListBuilder;
import oj.leetcode.list.ListNode;

import org.junit.Test;

public class RemoveDuplicatesTest {
	
	private final RemoveDuplicates inst = new RemoveDuplicates();

	@Test
	public void test() {
		ListNode head = ListBuilder.buildList(new int[] { 1, 1, 2 });
		ListNode dups = inst.deleteDuplicates(head);
		int[] array = ListBuilder.toArray(dups);
		assertArrayEquals(array, new int[] { 2 });

		head = ListBuilder.buildList(new int[] { 1, 1, 1, 1, 1, 1 });
		dups = inst.deleteDuplicates(head);
		assertNull(dups);

		head = ListBuilder.buildList(new int[] { 1, 2, 3, 4, 3, 2, 1 });
		dups = inst.deleteDuplicates(head);
		array = ListBuilder.toArray(dups);
		assertArrayEquals(array, new int[] { 1, 2, 3, 4, 3, 2, 1 });
	}

}
