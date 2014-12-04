package oj.leetcode.cache;

/**
 * 
 * Design and implement a data structure for Least Recently Used (LRU) cache. It
 * should support the following operations: get and set.
 * 
 * get(key) - Get the value (will always be positive) of the key if the key
 * exists in the cache, otherwise return -1.
 * 
 * set(key, value) - Set or insert the value if the key is not already present.
 * When the cache reached its capacity, it should invalidate the least recently
 * used item before inserting a new item.
 *
 */
public class LRUCache {

	private final int[] keys;
	private final int[] data;
	private int top;

	public LRUCache(int capacity) {
		if (capacity <= 0) {
			throw new IllegalArgumentException("capacity is less than 0");
		}
		this.keys = new int[capacity];
		this.data = new int[capacity];
		this.top = 0;
	}

	public int get(int key) {
		int ret = -1;
		if (!isEmpty()) {
			int p = findKey(key);
			if (p != -1) {
				ret = refresh(p);
			}
		}
		return ret;
	}

	public void set(int key, int value) {
		int p = findKey(key);
		int ip = -1;
		if (p != -1) {
			refresh(p);
			ip = top - 1;
		}else if (isFull()) {
			refresh(0);
			ip = top - 1;
		}else {
			ip = top;
			top++;
		}
		if (ip != -1) {
			keys[ip] = key;
			data[ip] = value;
		}
	}

	private int refresh(int p) {
		if (p < 0) {
			return -1;
		}
		int ret = data[p];
		int key = keys[p];
		System.arraycopy(keys, p + 1, keys, p, top - p - 1);
		System.arraycopy(data, p + 1, data, p, top - p - 1);
		keys[top - 1] = key;
		data[top - 1] = ret;
		return ret;
	}

	private int findKey(int key) {
		int offset = -1;
		for (int i = 0; i < top; i++) {
			if (keys[i] == key) {
				offset = i;
				break;
			}
		}
		if (offset == top) {
			offset = -1;
		}
		return offset;
	}

	private boolean isEmpty() {
		return (this.top == 0);
	}

	private boolean isFull() {
		return (this.top == data.length);
	}

}
