package oj.leetcode.list.remove;

import static org.junit.Assert.*;
import oj.leetcode.list.ListBuilder;
import oj.leetcode.list.ListNode;

import org.junit.Test;

public class RemoveFromEndTest {

	private final RemoveFromEnd inst = new RemoveFromEnd();

	@Test
	public void test() {
		ListNode head = ListBuilder.buildList(new int[] { 1, 2, 3, 4, 5 });
		ListNode cur = inst.removeNthFromEnd(head, 2);
		int[] vals = ListBuilder.toArray(cur);
		assertArrayEquals(vals, new int[] { 1, 2, 3, 5 });

		head = ListBuilder.buildList(new int[] { 1, 2, 3, 4, 5 });
		cur = inst.removeNthFromEnd(head, 1);
		vals = ListBuilder.toArray(cur);
		assertArrayEquals(vals, new int[] { 1, 2, 3, 4 });

		head = ListBuilder.buildList(new int[] { 1, 2, 3, 4, 5 });
		cur = inst.removeNthFromEnd(head, 5);
		vals = ListBuilder.toArray(cur);
		assertArrayEquals(vals, new int[] { 2, 3, 4, 5 });
	}

}
