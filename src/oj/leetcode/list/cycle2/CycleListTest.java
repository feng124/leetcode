package oj.leetcode.list.cycle2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CycleListTest {

	private CycleList inst = null;

	@Before
	public void setUp() throws Exception {
		inst = new CycleList();
	}

	@Test
	public void test() {
		ListNode head = buildCycleList(new int[] { 1 });
		ListNode start = inst.detectCycle(head);
		assertEquals(head, start);

		head = buildNormalList(new int[] { 1 });
		start = inst.detectCycle(head);
		assertNull(start);
//
		head = buildCycleList(new int[] { 1, 2 });
		start = inst.detectCycle(head);
		assertEquals(start, head);
//
		head = buildNormalList(new int[] { 1, 2 });
		start = inst.detectCycle(head);
		assertNull(start);

		head = buildNormalList(new int[] { 1, 2, 3, 4, 5, 6, 7, 8 });
		start = inst.detectCycle(head);
		assertNull(start);
//
		head = buildNormalList(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 });
		start = inst.detectCycle(head);
		assertNull(start);

		head = buildCycleList(new int[] { 1, 2, 3, 4, 5, 6, 7, 8 });
		start = inst.detectCycle(head);
		assertNotNull(start);

		head = buildCycleList(new int[] { 1, 2, 3, 4, 5, 6, 7, 8 }, 4);
		start = inst.detectCycle(head);
		assertEquals(start.val, 5);

		head = buildCycleList(new int[] { 3, 2, 0, -4 }, 1);
		start = inst.detectCycle(head);
		assertEquals(start.val, 2);
	}

	private ListNode buildNormalList(int[] array) {
		ListNode head = null;
		if (array != null && array.length > 0) {
			head = new ListNode(array[0]);
			ListNode cur = head;
			for (int i = 1; i < array.length; i++) {
				cur.next = new ListNode(array[i]);
				cur = cur.next;
			}
		}
		return head;
	}

	private ListNode buildCycleList(int[] array, int start) {
		ListNode head = buildNormalList(array);
		if (head != null) {
			ListNode last = head;
			while (last.next != null) {
				last = last.next;
			}
			ListNode ref = head;
			if (start != 0) {
				for (int i = 0; i < start; i++) {
					ref = ref.next;
				}
			}
			last.next = ref;
		}
		return head;
	}

	private ListNode buildCycleList(int[] array) {
		return buildCycleList(array, 0);
	}

}
