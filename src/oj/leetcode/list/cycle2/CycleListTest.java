package oj.leetcode.list.cycle2;

import static org.junit.Assert.*;
import oj.leetcode.list.ListBuilder;
import oj.leetcode.list.ListNode;

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
		ListNode head = ListBuilder.buildCycleList(new int[] { 1 });
		ListNode start = inst.detectCycle(head);
		assertEquals(head, start);

		head = ListBuilder.buildList(new int[] { 1 });
		start = inst.detectCycle(head);
		assertNull(start);
//
		head = ListBuilder.buildCycleList(new int[] { 1, 2 });
		start = inst.detectCycle(head);
		assertEquals(start, head);
//
		head = ListBuilder.buildList(new int[] { 1, 2 });
		start = inst.detectCycle(head);
		assertNull(start);

		head = ListBuilder.buildList(new int[] { 1, 2, 3, 4, 5, 6, 7, 8 });
		start = inst.detectCycle(head);
		assertNull(start);
//
		head = ListBuilder.buildList(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 });
		start = inst.detectCycle(head);
		assertNull(start);

		head = ListBuilder.buildCycleList(new int[] { 1, 2, 3, 4, 5, 6, 7, 8 });
		start = inst.detectCycle(head);
		assertNotNull(start);

		head = ListBuilder.buildCycleList(new int[] { 1, 2, 3, 4, 5, 6, 7, 8 }, 4);
		start = inst.detectCycle(head);
		assertEquals(start.val, 5);

		head = ListBuilder.buildCycleList(new int[] { 3, 2, 0, -4 }, 1);
		start = inst.detectCycle(head);
		assertEquals(start.val, 2);
	}

	

}
