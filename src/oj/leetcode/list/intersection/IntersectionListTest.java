package oj.leetcode.list.intersection;

import static org.junit.Assert.*;
import oj.leetcode.list.ListNode;

import org.junit.Test;

public class IntersectionListTest {
	private IntersectionList il = new IntersectionList();

	@Test
	public void test() {
		ListNode headB = null;

		ListNode headA = buildList(new int[] { 1, 2, 3, 4, 5 });
		headB = buildList(headA, new int[] { 6, 7 }, 2);
		
		ListNode intersec = il.getIntersectionNode(headA, headB);
		assertEquals(intersec.val, 3);
		
		headB = buildList(headA, new int[] { 6, 7, 8, 9 }, 2);
		intersec = il.getIntersectionNode(headA, headB);
		assertEquals(intersec.val, 3);
		
		headB = buildList(headA, new int[] { 6, 7, 8 }, 2);
		intersec = il.getIntersectionNode(headA, headB);
		assertEquals(intersec.val, 3);
		
		headB = buildList(headA, new int[] { 6 }, 2);
		intersec = il.getIntersectionNode(headA, headB);
		assertEquals(intersec.val, 3);

		headB = buildList(headA, new int[] { 6, 7 }, 0);
		intersec = il.getIntersectionNode(headA, headB);
		assertEquals(intersec.val, 1);

		headB = buildList(headA, new int[] { 6, 7 }, 4);
		intersec = il.getIntersectionNode(headA, headB);
		assertEquals(intersec.val, 5);
		
		headB = buildList(headA, new int[] { 6, 7, 8, 9, 10, 11, 12 }, 4);
		intersec = il.getIntersectionNode(headA, headB);
		assertEquals(intersec.val, 5);
		
		headB = buildList(headA, new int[] { 6, 7, 8, 9, 10, 11, 12, 13 }, 4);
		intersec = il.getIntersectionNode(headA, headB);
		assertEquals(intersec.val, 5);
		
		headB = buildList(new int[] {6, 7, 8, 9});
		intersec = il.getIntersectionNode(headA, headB);
		assertNull(intersec);

	}

	private ListNode buildList(int[] array) {
		if (array == null || array.length == 0) {
			return null;
		}

		ListNode head = new ListNode(array[0]);
		if (array.length > 1) {
			ListNode cur = head;
			for (int i = 1; i < array.length; i++) {
				cur.next = new ListNode(array[i]);
				cur = cur.next;
			}
		}
		return head;
	}

	private ListNode buildList(ListNode list, int[] array, int p) {
		ListNode head = buildList(array);
		if (p < 0) {
			return head;
		}

		ListNode tail = head;
		if (head != null) {
			while (tail.next != null) {
				tail = tail.next;
			}
		}
		ListNode intersec = list;
		for (int i = 0; i < p; i++) {
			if (intersec != null) {
				intersec = intersec.next;
			}
		}
		if (intersec != null) {
			tail.next = intersec;
		}
		return head;
	}

}
