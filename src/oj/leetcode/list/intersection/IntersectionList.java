package oj.leetcode.list.intersection;

/**
 * 
 * Write a program to find the node at which the intersection of two singly
 * linked lists begins.
 * 
 * 
 * For example, the following two linked lists:
 * 
 * A:      a1 → a2
 *                ↘ 
 *                 c1 → c2 → c3
 *                ↗ 
 * B: b1 → b2 → b3
 * 
 * begin to intersect at node c1.
 * 
 * 
 * Notes:
 * 
 * 1. If the two linked lists have no intersection at all, return null. 2. The
 * linked lists must retain their original structure after the function returns.
 * 3. You may assume there are no cycles anywhere in the entire linked
 * structure. 4. Your code should preferably run in O(n) time and use only O(1)
 * memory.
 *
 */
public class IntersectionList {

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null) {
			return null;
		}
		
		ListNode ret = null;
		ListNode refA = headA;
		ListNode refB = headB;
		while(refA != null && refB != null) {
			refA = refA.next;
			refB = refB.next;
		}
		
		if (refA != null) {
			ret = findIntersectionNode(refA, headA, headB);
		}else if (refB != null) {
			ret = findIntersectionNode(refB, headB, headA);
		}else {
			ret = findIntersectionNode(headA, headB);
		}
		
		return ret;
	}

	private ListNode findIntersectionNode(ListNode headA, ListNode headB) {
		ListNode refA = headA;
		ListNode refB = headB;
		ListNode ret = null;
		while(refA != null && refB != null) {
			if (refA == refB) {
				ret = refA;
				break;
			}
			refA = refA.next;
			refB = refB.next;
		}
		return ret;
	}

	private ListNode findIntersectionNode(ListNode refA, ListNode headA,
			ListNode headB) {
		int delta = 0;
		while(refA != null) {
			delta++;
			refA = refA.next;
		}
		refA = headA;
		while(delta > 0) {
			refA = refA.next;
			delta--;
		}
		
		return findIntersectionNode(refA, headB);
	}

}
