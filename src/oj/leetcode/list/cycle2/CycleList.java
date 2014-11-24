package oj.leetcode.list.cycle2;

/**
 * 
 * Given a linked list, return the node where the cycle begins. If there is no
 * cycle, return null.
 * 
 * Follow up: Can you solve it without using extra space?
 *
 */
public class CycleList {

	public ListNode detectCycle(ListNode head) {
		ListNode start_node = null;

		if (head != null) {
			ListNode cur = head;
			ListNode ref = head.next;
			int mn = 0;

			do {

				if (cur == null || ref == null || ref.next == null) {
					break;
				}

				if (cur == ref) {
					start_node = cur;
					break;
				}

				ref = ref.next.next;
				cur = cur.next;
				mn++;

			} while (cur != null);

			if (start_node != null) {
				int len = 0;
				do {
					cur = cur.next;
					ref = ref.next.next;
					len++;
				} while (cur != ref);

				if (mn == 0 && len == 1) {
					start_node = head;
				} else {
					for (int m = 0; m < mn; m++) {
						int n = mn - m;
						if (n < len) {
							start_node = checkCycle(head, m, len);
							if (start_node != null) {
								break;
							}
						}
					}
				}
			}

		}

		return start_node;
	}

	private ListNode checkCycle(ListNode head, int m, int l) {
		ListNode start_node = head;
		for (int i = 0; i < m; i++) {
			start_node = start_node.next;
		}
		ListNode ref = start_node;
		for (int i = 0; i < l; i++) {
			ref = ref.next;
		}
		if (ref == start_node) {
			return ref;
		} else {
			return null;
		}
	}
}
