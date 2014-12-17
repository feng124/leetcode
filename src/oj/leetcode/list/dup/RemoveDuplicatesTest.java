package oj.leetcode.list.dup;

import static org.junit.Assert.*;
import oj.leetcode.list.ListNode;

import org.junit.Test;

public class RemoveDuplicatesTest {

	private final RemoveDuplicates inst = new RemoveDuplicates();

	@Test
	public void test() {
		ListNode head = buildList(new int[] { 1, 1, 2 });
		ListNode dups = inst.deleteDuplicates(head);
		int[] array = toArray(dups);
		assertArrayEquals(array, new int[] { 1, 2 });

		head = buildList(new int[] { 1, 1, 1, 1, 1, 1 });
		dups = inst.deleteDuplicates(head);
		array = toArray(dups);
		assertArrayEquals(array, new int[] { 1 });

		head = buildList(new int[] { 1, 2, 3, 4, 3, 2, 1 });
		dups = inst.deleteDuplicates(head);
		array = toArray(dups);
		assertArrayEquals(array, new int[] { 1, 2, 3, 4, 3, 2, 1 });
	}

	private int[] toArray(ListNode list) {
		int size = 0;
		ListNode cur = list;
		while (cur != null) {
			size++;
			cur = cur.next;
		}
		int[] array = new int[size];
		cur = list;
		for (int i = 0; i < size; i++) {
			array[i] = cur.val;
			cur = cur.next;
		}
		return array;
	}

	private ListNode buildList(int[] array) {
		if (array == null || array.length == 0) {
			return null;
		}
		ListNode head = new ListNode(array[0]);
		ListNode cur = head;
		for (int i = 1; i < array.length; i++) {
			cur.next = new ListNode(array[i]);
			cur = cur.next;
		}
		return head;
	}

}
