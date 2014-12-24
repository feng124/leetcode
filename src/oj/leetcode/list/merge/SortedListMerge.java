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
			ListNode h1 = new ListNode(-1, l1);
			ListNode h2 = new ListNode(-1, l2);
			
			ListNode ref = l1;
			ListNode prev = h1;
			ListNode lb = l2;
			ListNode lbp = h2;
		}
		
		return head;
	}
}
