package oj.leetcode.list.remove;

import oj.leetcode.list.ListNode;

/**
 * 
 * Given a linked list, remove the nth node from the end of list and return its
 * head.
 * 
 * For example,
 * 
 * Given linked list: 1->2->3->4->5, and n = 2.
 * 
 * After removing the second node from the end, the linked list becomes
 * 1->2->3->5.
 * 
 * Note: Given n will always be valid. Try to do this in one pass.
 *
 */
public class RemoveFromEnd {

	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode last = head;
		for (int i = 0; i < n; ++i) {
			last = last.next;
			if (last == null) {
				break;
			}
		}
		
		if (last != null) {
			ListNode cur = head;
			ListNode prev = new ListNode(-1);
			prev.next = head;
			while (last != null) {
				prev = cur;
				cur = cur.next;
				last = last.next;
			}
			prev.next = cur.next;
		}else {
			head = head.next;
		}
		return head;
	}

}
