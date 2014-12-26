package oj.leetcode.list.merge2;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

import oj.leetcode.list.ListNode;

/**
 * 
 * Merge k sorted linked lists and return it as one sorted list. Analyze and
 * describe its complexity.
 *
 */
public class KSortedListMerge {

	private final Deque<ListNode> queue = new ArrayDeque<ListNode>();

	public ListNode mergeKLists(List<ListNode> lists) {
		
		if (lists == null || lists.isEmpty()) {
			return null;
		}
		
		for(ListNode cur : lists) {
			if (cur != null) {
				queue.add(cur);
			}
		}
		if (queue.isEmpty()) {
			return null;
		}
		
		while (queue.size() > 1) {
			ListNode l1 = queue.pollFirst();
			ListNode l2 = queue.pollFirst();
			ListNode mm = mergeTwoLists(l1, l2);
			if (mm != null) {
				queue.addLast(mm);
			}
		}
		ListNode mm = queue.pollFirst();
		queue.clear();
		return mm;
	}

	private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode head = null;

		if (l1 == null && l2 != null) {
			head = l2;
		}
		if (l1 != null && l2 == null) {
			head = l1;
		}

		if (l1 != null && l2 != null) {

			head = new ListNode(-1);
			head.next = l1;
			ListNode h2 = new ListNode(-1);
			h2.next = l2;
			ListNode prev = head;
			while (h2.next != null) {
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
		while (cur != null) {
			if (cur.val > ref.val) {
				break;
			}
			prev = cur;
			cur = cur.next;
		}

		return prev;
	}

}
