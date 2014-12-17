package oj.leetcode.list.reorder;

import static org.junit.Assert.*;
import oj.leetcode.list.ListNode;

import org.junit.Before;
import org.junit.Test;

public class ReorderListTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		ReorderList rl = new ReorderList();

		ListNode head = buildList(new int[] { 1, 2, 3, 4 });
		ListNode answer = buildList(new int[] {1, 4, 2, 3});
		ListNode guess = rl.reorderList(head);
		assertEqual(guess, answer);
		
		head = buildList(new int[] {1, 2, 3, 4, 5});
		answer = buildList(new int[] {1, 5, 2, 4, 3});
		guess = rl.reorderList(head);
		assertEqual(guess, answer);
	}

	private void assertEqual(ListNode guess, ListNode answer) {
		ListNode cur = guess;
		int guess_len = 0;
		while(cur != null) {
			guess_len++;
			cur = cur.next;
		}
		
		cur = answer;
		int answer_len = 0;
		while(cur != null) {
			answer_len++;
			cur = cur.next;
		}
		
		assertEquals(guess_len, answer_len);
		
		cur = guess;
		ListNode ref = answer;
		while(cur != null) {
			assertEquals(cur.val, ref.val);
			cur = cur.next;
			ref = ref.next;
		}
	}

	private ListNode buildList(int[] cur) {
		if (cur == null || cur.length == 0) {
			return null;
		}

		ListNode head = new ListNode(cur[0]);
		if (cur.length > 1) {
			ListNode node = head;
			for (int i = 1; i < cur.length; i++) {
				node.next = new ListNode(cur[i]);
				node = node.next;
			}
		}
		return head;
	}

}
