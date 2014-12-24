package oj.leetcode.list.merge;

import oj.leetcode.list.ListNode;

/**
 * 
 * Merge two sorted linked lists and return it as a new list. The new list
 * should be made by splicing together the nodes of the first two lists.
 *
 */
public class SortedListMerge {
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode head = null;
		
		if (l1 == null && l2 != null) {
			head = l2;
		}
		if (l1 != null && l2 == null) {
			head = l1;
		}
		
		if (l1 != null && l2 != null) {
			
			head = new ListNode(-1, l1);
			ListNode h2 = new ListNode(-1, l2);
			ListNode prev = head;
			while(h2.next != null) {
				ListNode ref = h2.next;
				prev = findNode(prev, ref);
				if (prev.next == null) {
					prev.next = ref;
					break;
				}
				ref = prev.next;
				ListNode _prev = findNode(h2, ref);
				prev.next = h2.next;
				h2.next = _prev.next;
				_prev.next = ref;
				prev = _prev;
			}
			head = head.next;
		}
		
		return head;
	}

	private ListNode findNode(ListNode list, ListNode ref) {
		ListNode prev = list;
		ListNode cur = prev.next;
		while(cur != null) {
			if (cur.val > ref.val) {
				break;
			}
			prev = cur;
			cur = cur.next;
		}
		
		return prev;
	}
	
}
