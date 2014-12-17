package oj.leetcode.list.reorder;

import java.util.ArrayDeque;
import java.util.Deque;

import oj.leetcode.list.ListNode;

/**
 *
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln, reorder it to:
 * L0→Ln→L1→Ln-1→L2→Ln-2→…
 * 
 * You must do this in-place without altering the nodes' values.
 * 
 * For example, Given {1,2,3,4}, reorder it to {1,4,2,3}.
 *
 */
public class ReorderList {

	public ListNode reorderList(ListNode head) {
		if (head == null || head.next == null || head.next.next == null) {
			return head;
		}

		ListNode cur = head;
		ListNode ref = head;
		ListNode prev = null;
		while (ref != null && ref.next != null) {
			prev = cur;
			cur = cur.next;
			ref = ref.next.next;
		}

		if (ref != null) {
			ref = cur.next;
			cur.next = null;
			cur = ref;
		}else if (prev != null){
			prev.next = null;
		}
		
		final Deque<ListNode> stack = new ArrayDeque<ListNode>();
		ref = cur;
		while(ref != null) {
			stack.push(ref);
			ref = ref.next;
		}
		
		cur = head;
		while(!stack.isEmpty()) {
			ref = stack.pop();
			if (ref != null) {
				ref.next = cur.next;
				cur.next = ref;
				cur = ref.next;
			}
		}

		return head;
	}

}
