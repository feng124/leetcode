package oj.leetcode.list.cycle;

/**
 * 
 * Given a linked list, determine if it has a cycle in it.
 * 
 * Follow up: Can you solve it without using extra space?
 *
 */
public class CycleList {

	public boolean hasCycle(ListNode head) {

		if (head == null || head.next == null) {
			return false;
		}

		boolean ret = false;
		ListNode cur = head;
		ListNode ref = head.next;

		do {
			if (cur == null || ref == null || ref.next == null) {
				break;
			}
			ref = ref.next.next;
			if (cur == ref) {
				ret = true;
				break;
			}
			cur = cur.next;
		} while (cur != null);

		return ret;

	}

}
