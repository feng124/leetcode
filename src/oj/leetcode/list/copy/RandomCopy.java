package oj.leetcode.list.copy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * A linked list is given such that each node contains an additional random
 * pointer which could point to any node in the list or null.
 * 
 * Return a deep copy of the list.
 *
 */
public class RandomCopy {

	private Map<RandomListNode, List<RandomListNode>> next_map = new HashMap<RandomListNode, List<RandomListNode>>();
	private Map<RandomListNode, RandomListNode> prev_map = new HashMap<RandomListNode, RandomListNode>();

	public RandomListNode copyRandomList(RandomListNode head) {

		RandomListNode cur = head;
		RandomListNode _head = new RandomListNode(0);
		RandomListNode _cur = _head;
		while (cur != null) {
			_cur.next = new RandomListNode(cur.label);

			prev_map.put(cur, _cur.next);
			if (cur.random != null) {
				if (prev_map.containsKey(cur.random)) {
					_cur.next.random = prev_map.get(cur.random);
				}else {
					if (!next_map.containsKey(cur.random)) {
						next_map.put(cur.random, new ArrayList<RandomListNode>());
					}
					List<RandomListNode> next_node_list = next_map.get(cur.random);
					next_node_list.add(_cur.next);
				}
			}
			
			if (next_map.containsKey(cur)) {
				List<RandomListNode> prev_node_list = next_map.get(cur);
				for(RandomListNode prev_node : prev_node_list) {
					prev_node.random = _cur.next;
				}
			}

			cur = cur.next;
			_cur = _cur.next;
		}

		next_map.clear();
		prev_map.clear();

		return _head.next;
	}
}
