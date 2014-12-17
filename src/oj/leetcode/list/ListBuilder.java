package oj.leetcode.list;

public class ListBuilder {

	public static ListNode buildList(int[] array) {
		ListNode head = null;
		if (array != null && array.length > 0) {
			head = new ListNode(array[0]);
			ListNode cur = head;
			for (int i = 1; i < array.length; i++) {
				cur.next = new ListNode(array[i]);
				cur = cur.next;
			}
		}
		return head;
	}

	public static ListNode buildCycleList(int[] array, int start) {
		ListNode head = buildList(array);
		if (head != null) {
			ListNode last = head;
			while (last.next != null) {
				last = last.next;
			}
			ListNode ref = head;
			if (start != 0) {
				for (int i = 0; i < start; i++) {
					ref = ref.next;
				}
			}
			last.next = ref;
		}
		return head;
	}

	public static ListNode buildCycleList(int[] array) {
		return buildCycleList(array, 0);
	}
	
	public static int[] toArray(ListNode list) {
		int size = 0;
		ListNode cur = list;
		while (cur != null) {
			size++;
			cur = cur.next;
		}
		int[] array = new int[size];
		cur = list;
		for (int i = 0; i < size; i++) {
			array[i] = cur.val;
			cur = cur.next;
		}
		return array;
	}
}
