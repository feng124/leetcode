package oj.leetcode.list.dup2;

import oj.leetcode.list.ListNode;

/**
 * 
 * Given a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.
 * 
 * For example,
 * 
 * Given 1->2->3->3->4->4->5, return 1->2->5.
 * 
 * Given 1->1->1->2->3, return 2->3.
 *
 */
public class RemoveDuplicates {

	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		
		ListNode prev = new ListNode(Integer.MIN_VALUE);
		prev.next = head;
		ListNode _head = prev;
		ListNode ref = head;
		while(ref.next != null) {
			ListNode cur = ref.next;
			while(cur != null) {
				if (cur.val != ref.val) {
					break;
				}
				cur = cur.next;
			}
			if (cur == ref.next) {
				prev = prev.next;
				ref = prev.next;
				continue;
			}
			
			prev.next = cur;
			ref = cur;
			if (cur == null) {
				break;
			}
		}
		return _head.next;
	}

}
