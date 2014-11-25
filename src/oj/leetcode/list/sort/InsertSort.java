package oj.leetcode.list.sort;

/**
 * 
 * Sort a linked list using insertion sort.
 *
 */
public class InsertSort {

	public ListNode insertionSortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode ref = head.next;
		ListNode tail = head;
		ListNode fst = new ListNode(Integer.MIN_VALUE);
		fst.next = head;
		while (ref != null) {
			ListNode prev = fst;
			ListNode cur = fst.next;
			do {
				if (cur.val > ref.val) {
					break;
				}
				prev = cur;
				cur = cur.next;
			} while (prev != tail);

			if (prev != tail) {
				prev.next = ref;
				tail.next = ref.next;
				ref.next = cur;
			}else {
				tail = tail.next;
			}
			
			ref = tail.next;

		}

		return fst.next;
	}
}
