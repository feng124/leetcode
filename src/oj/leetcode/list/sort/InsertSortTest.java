package oj.leetcode.list.sort;

import static org.junit.Assert.*;
import oj.leetcode.list.ListNode;

import org.junit.Test;

public class InsertSortTest {

	private ListNode list;
	private ListNode sort;

	@Test
	public void test() {
		InsertSort is = new InsertSort();

		list = buildList(new int[] {});
		sort = is.insertionSortList(list);
		assertNull(sort);

		list = buildList(new int[] { 1, 1, 1 });
		sort = is.insertionSortList(list);
		assertEqual(sort, new int[] { 1, 1, 1 });
//
		list = buildList(new int[] { 3, 2, 1 });
		sort = is.insertionSortList(list);
		assertEqual(sort, new int[] { 1, 2, 3 });
//
		list = buildList(new int[] { 1, 2, 1 });
		sort = is.insertionSortList(list);
		assertEqual(sort, new int[] { 1, 1, 2 });

		list = buildList(new int[] { 1, 2, 3, 4 });
		sort = is.insertionSortList(list);
		assertEqual(sort, new int[] { 1, 2, 3, 4 });
		
		list = buildList(new int[] { 1, 4, 5, 3, 2 });
		sort = is.insertionSortList(list);
		assertEqual(sort, new int[] { 1, 2, 3, 4, 5 });
		
		list = buildList(new int[] { 3, 4, 5, 1, 2 });
		sort = is.insertionSortList(list);
		assertEqual(sort, new int[] { 1, 2, 3, 4, 5 });
		
		list = buildList(new int[] { 2, 3, 1, 0, 7, 4, 9 });
		sort = is.insertionSortList(list);
		assertEqual(sort, new int[] { 0, 1, 2, 3, 4, 7, 9 });
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

}
