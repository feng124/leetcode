package oj.leetcode.list.copy;

public class RandomListNode {

	int label;

	RandomListNode next;
	RandomListNode random;

	RandomListNode(int label) {
		this.label = label;
		this.next = this.random = null;
	}

	public String toString() {
		StringBuffer buf = new StringBuffer();
		buf.append("[");
		buf.append(label);
		buf.append(", ");
		buf.append(this.hashCode());
		buf.append(", ");
		if (random != null) {
			buf.append(random.hashCode());
		}
		buf.append("]");
		return buf.toString();
	}
}
