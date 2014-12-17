package oj.leetcode.list.dup;

import oj.leetcode.list.ListNode;

/**
 * 
 * Given a sorted linked list, delete all duplicates such that each element
 * appear only once.
 * 
 * For example, 
 * 
 * Given 1->1->2, return 1->2. 
 * 
 * Given 1->1->2->3->3, return 1->2->3.
 *
 */
public class RemoveDuplicates {

	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode ref = head;
		while (ref.next != null) {
			ListNode cur = ref.next;
			while (cur != null) {
				if (cur.val != ref.val) {
					break;
				}
				cur = cur.next;
			}
			
			ref.next = cur;
			ref = ref.next;
			if (cur == null) {
				break;
			}
		}
		return head;
	}
}
