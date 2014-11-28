package oj.leetcode.list.copy;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RandomCopyTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		
		RandomListNode head = new RandomListNode(1);
		RandomListNode cur = head;
		for(int i = 0; i < 8; i++) {
			cur.next = new RandomListNode(i);
			cur = cur.next;
		}
		head = head.next;
		cur = head.next;
		cur.random = cur.next;
		head.random = cur.random;
		cur = cur.next.next;
		cur.random = head.random;
		cur = cur.next;
		cur.random = cur;
		while(cur.next != null) {
			cur = cur.next;
		}
		cur.random = head;
		printList(head);
		
		RandomCopy rc = new RandomCopy();
		RandomListNode copied = rc.copyRandomList(head);
		printList(copied);
		
		head = new RandomListNode(4);
		head.random = head;
		printList(head);
		
		copied = rc.copyRandomList(head);
		printList(copied);
		
		head = new RandomListNode(4);
		head.next = new RandomListNode(2);
		head.next.random = head;
		printList(head);
		
		copied = rc.copyRandomList(head);
		printList(copied);
	}

	private void printList(RandomListNode head) {
		RandomListNode cur = head;
		while(cur != null) {
			System.out.println(cur);
			cur = cur.next;
		}
		System.out.println();
	}

}
