package oj.leetcode.list.sort;

import oj.leetcode.list.ListNode;

/**
 * 
 * Sort a linked list in O(n log n) time using constant space complexity.
 *
 */
public class SortList {
	public ListNode sortList(ListNode head) {

		if (head == null || head.next == null) {
			return head;
		}

		ListNode middle = findMiddle(head, null);

		return mergeSort(head, middle, null);

	}

	private ListNode findMiddle(ListNode begin, ListNode end) {
		ListNode middle = begin;
		ListNode ref = begin;

		while (ref != end) {

			middle = middle.next;
			if (ref.next == null || ref.next == end) {
				break;
			}
			ref = ref.next.next;

		}

		return middle;
	}

	public ListNode mergeSort(ListNode begin, ListNode middle, ListNode end) {

		if (begin.next != middle) {
			begin = sortList(begin, middle);
		}
		
		if (begin != null) {
			ListNode tail = begin;
			while(tail.next != middle) {
				tail = tail.next;
			}
			
			if (middle.next != end) {
				middle = sortList(middle, end);
			}
			tail.next = middle;
			
			ListNode head = begin;
			ListNode cur = head;
			ListNode prev = null;
			for (ListNode ref = middle; ref != end; ref = tail.next) {
				for (; cur != ref; cur = cur.next) {
					if (cur.val > ref.val) {
						break;
					}
					prev = cur;
				}
				if (cur == middle) {
					break;
				}
				if (cur == ref) {
					break;
				}

				tail.next = ref.next;
				ref.next = cur;
				if (prev != null) {
					prev.next = ref;
				} else {
					head = ref;
				}
				prev = ref;
			}
			begin = head;
		}
		
//		if (begin != null) {
//			ListNode head = begin;
//			ListNode tail = head;
//			while (tail.next != middle) {
//				if (tail.next == null) {
//					break;
//				}
//				tail = tail.next;
//			}
//			tail.next = middle;
//
//			ListNode cur = head;
//			ListNode prev = null;
//			for (ListNode ref = middle; ref != end; ref = tail.next) {
//				for (; cur != ref; cur = cur.next) {
//					if (cur.val > ref.val) {
//						break;
//					}
//					prev = cur;
//				}
//				if (cur == middle) {
//					break;
//				}
//				if (cur == ref) {
//					break;
//				}
//
//				tail.next = ref.next;
//				ref.next = cur;
//				if (prev != null) {
//					prev.next = ref;
//				} else {
//					head = ref;
//				}
//				prev = ref;
//			}
//			begin = head;
//		}

		return begin;

	}

	public ListNode sortList(ListNode begin, ListNode end) {
		if (begin == end || begin.next == end) {
			return begin;
		}

		ListNode middle = findMiddle(begin, end);

		return mergeSort(begin, middle, end);

	}
}
