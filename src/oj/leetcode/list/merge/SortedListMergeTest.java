package oj.leetcode.list.merge;

import static org.junit.Assert.*;
import oj.leetcode.list.ListBuilder;
import oj.leetcode.list.ListNode;

import org.junit.Test;

public class SortedListMergeTest {

	private final SortedListMerge inst = new SortedListMerge();

	@Test
	public void test() {
		ListNode l1 = ListBuilder.buildList(new int[] { 5 });
		ListNode l2 = ListBuilder.buildList(new int[] { 6 });
		ListNode ln = inst.mergeTwoLists(l1, l2);
		int[] array = ListBuilder.toArray(ln);
		assertArrayEquals(array, new int[] { 5, 6 });

		ln = inst.mergeTwoLists(l2, l1);
		array = ListBuilder.toArray(ln);
		assertArrayEquals(array, new int[] { 5, 6 });

		l2 = ListBuilder.buildList(new int[] {});
		ln = inst.mergeTwoLists(l1, l2);
		array = ListBuilder.toArray(ln);
		assertArrayEquals(array, new int[] { 5 });

		ln = inst.mergeTwoLists(l2, l1);
		array = ListBuilder.toArray(ln);
		assertArrayEquals(array, new int[] { 5 });

		l2 = ListBuilder.buildList(new int[] { 6, 6, 7 });
		ln = inst.mergeTwoLists(l1, l2);
		array = ListBuilder.toArray(ln);
		assertArrayEquals(array, new int[] { 5, 6, 6, 7 });

		ln = inst.mergeTwoLists(l2, l1);
		array = ListBuilder.toArray(ln);
		assertArrayEquals(array, new int[] { 5, 6, 6, 7 });

		l1 = ListBuilder.buildList(new int[] { 0, 1, 2, 3, 4 });
		l2 = ListBuilder.buildList(new int[] { 5, 6, 7, 8, 9, 10 });
		ln = inst.mergeTwoLists(l1, l2);
		array = ListBuilder.toArray(ln);
		assertArrayEquals(array, new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });

		ln = inst.mergeTwoLists(l2, l1);
		array = ListBuilder.toArray(ln);
		assertArrayEquals(array, new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });

		l1 = ListBuilder.buildList(new int[] { 1, 3, 5, 7 });
		l2 = ListBuilder.buildList(new int[] { 0, 2, 4, 6, 8, 10 });
		ln = inst.mergeTwoLists(l1, l2);
		array = ListBuilder.toArray(ln);
		assertArrayEquals(array, new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 10 });

		ln = inst.mergeTwoLists(l2, l1);
		array = ListBuilder.toArray(ln);
		assertArrayEquals(array, new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 10 });

		int[] la = new int[5000];
		int[] lb = new int[5000];
		for (int i = 0; i < la.length; i++) {
			la[i] = 2 * i;
			lb[i] = la[i] + 1;
		}
		l1 = ListBuilder.buildList(la);
		l2 = ListBuilder.buildList(lb);
		ln = inst.mergeTwoLists(l1, l2);
		int val = 0;
		while(ln != null) {
			assertEquals(ln.val, val);
			ln = ln.next;
			val += 1;
		}
		
		ln = inst.mergeTwoLists(l2, l1);
		val = 0;
		while(ln != null) {
			assertEquals(ln.val, val);
			ln = ln.next;
			val += 1;
		}
	}

}
