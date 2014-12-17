package oj.leetcode.list.cycle;

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
		ListNode head = ListBuilder.buildCycleList(new int[] {1});
		
		boolean isCycleList = inst.hasCycle(head);
		assertTrue(isCycleList);
		
		head = ListBuilder.buildList(new int[] {1});
		isCycleList = inst.hasCycle(head);
		assertFalse(isCycleList);
		
		head = ListBuilder.buildCycleList(new int[] {1, 2});
		isCycleList = inst.hasCycle(head);
		assertTrue(isCycleList);
		
		head = ListBuilder.buildCycleList(new int[] {1, 2, 3});
		isCycleList = inst.hasCycle(head);
		assertTrue(isCycleList);
		
		head = ListBuilder.buildCycleList(new int[] {1, 2, 3, 4, 5, 6, 7, 8});
		isCycleList = inst.hasCycle(head);
		assertTrue(isCycleList);
		
		head = ListBuilder.buildCycleList(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9});
		isCycleList = inst.hasCycle(head);
		assertTrue(isCycleList);
		
		head = ListBuilder.buildList(new int[] {1, 2, 3});
		isCycleList = inst.hasCycle(head);
		assertFalse(isCycleList);
		
		head = ListBuilder.buildList(new int[] {1, 2, 3, 4, 5, 6, 7, 8});
		isCycleList = inst.hasCycle(head);
		assertFalse(isCycleList);
		
		head = ListBuilder.buildList(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9});
		isCycleList = inst.hasCycle(head);
		assertFalse(isCycleList);
		
		head = ListBuilder.buildCycleList(new int[] {1, 2, 3, 4, 5, 6, 7, 8}, 2);
		isCycleList = inst.hasCycle(head);
		assertTrue(isCycleList);
		
		head = ListBuilder.buildCycleList(new int[] {1, 2, 3, 4, 5, 6, 7, 8}, 3);
		isCycleList = inst.hasCycle(head);
		assertTrue(isCycleList);
		
		head = ListBuilder.buildCycleList(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9}, 2);
		isCycleList = inst.hasCycle(head);
		assertTrue(isCycleList);
		
		head = ListBuilder.buildCycleList(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9}, 3);
		isCycleList = inst.hasCycle(head);
		assertTrue(isCycleList);
		
	}
	

}
