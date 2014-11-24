package oj.leetcode.list.sort;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SortListTest {

	private int[][] test_cases = null;
	private SortList sorter = null;

	@Before
	public void setUp() throws Exception {
		test_cases = new int[16][];

		test_cases[0] = null;
		test_cases[1] = null;
		
		test_cases[2] = new int[] { 8, 3, 9, 4, 5, 0, 6, 1, 2, 7 };
		test_cases[3] = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		
		test_cases[4] = new int[] { 8, 3, 9, 4, 5, 0, 6, 1, 2 };
		test_cases[5] = new int[] { 0, 1, 2, 3, 4, 5, 6, 8, 9 };

		test_cases[6] = new int[] { 4 };
		test_cases[7] = new int[] { 4 };

		test_cases[8] = new int[] { 2, 3 };
		test_cases[9] = new int[] { 2, 3 };

		test_cases[10] = new int[] { 3, 2 };
		test_cases[11] = new int[] { 2, 3 };
		
		test_cases[12] = new int[] {4, 3, 2, 1};
		test_cases[13] = new int[] {1, 2, 3, 4};
		
		test_cases[14] = new int[] {1, 2, 3, 4};
		test_cases[15] = new int[] {1, 2, 3, 4};
		
		sorter = new SortList();

	}
	
	public void testMergeSort() {
		int[] res = new int[] {1, 2};
		ListNode begin = buildList(res);
		ListNode middle = begin.next;
		begin = sorter.mergeSort(begin, middle, null);
		
		res = new int[] {4, 2, 1, 3};
		begin = buildList(res);
		middle = begin.next.next;
		begin = sorter.mergeSort(begin, middle, null);
		
		res = new int[] { 8, 3, 9, 4, 5, 0, 6, 1, 2 };
		begin = buildList(res);
		middle = begin.next.next.next.next.next;
		begin = sorter.mergeSort(begin, middle, null);
	}

	@Test
	public void testSortList() {
		for(int i = 0; i < test_cases.length; i += 2) {
			ListNode list = buildList(test_cases[i]);
			ListNode sort = sorter.sortList(list);
			
			assertEqual(sort, test_cases[i+1]);
		}
	}

	private void assertEqual(ListNode head, int[] res) {
		if (head != null || res != null) {

			assertNotNull(head);

			ListNode node = head;
			int cnt = 0;
			do {
				cnt += 1;
				node = node.next;
			} while (node != null);
			assertEquals(cnt, res.length);

			node = head;
			for (int i = 0; i < res.length; i++) {
				assertEquals(node.val, res[i]);
				node = node.next;
			}

		}
	}

	private ListNode buildList(int[] cur) {
		if (cur == null || cur.length == 0) {
			return null;
		}

		ListNode head = new ListNode(cur[0]);
		if (cur.length > 1) {
			ListNode node = head;
			for (int i = 1; i < cur.length; i++) {
				node.next = new ListNode(cur[i]);
				node = node.next;
			}
		}
		return head;
	}

}
