package oj.leetcode.stack;

import java.util.Arrays;

/**
 * 
 * Design a stack that supports push, pop, top, and retrieving the minimum
 * element in constant time.
 * 
 * push(x) -- Push element x onto stack. 
 * pop() -- Removes the element on top of the stack. 
 * top() -- Get the top element. 
 * getMin() -- Retrieve the minimum element in the stack.
 *
 */
public class MinStack {

	private final static int BLOCK_SIZE = 128;
	private int[] array = null;
	private int top = -1;
	private int min = -1;
	
	public MinStack() {
		array = new int[BLOCK_SIZE];
		Arrays.fill(array, Integer.MAX_VALUE);
		top = 0;
		min = -1;
	}
	
	public void push(int x) {
		if (top % BLOCK_SIZE == 0) {
			int[] _array = new int[array.length+BLOCK_SIZE];
			System.arraycopy(array, 0, _array, 0, array.length);
			array = null;
			array = _array;
		}
		if (min == -1) {
			min = 0;
		}else if (x < array[min]) {
			min = top;
		}
		array[top++] = x;
	}

	public void pop() {
		top -= 1;
		if (min == top) {
			min = top-1;
			for(int i = 0; i < top; i++) {
				if (array[min] > array[i]) {
					min = i;
				}
			}
		}
	}

	public int top() {
		if (top == 0) {
			throw new UnsupportedOperationException("unsupported operation: the stack is empty!");
		}
		return array[top-1];
	}

	public int getMin() {
		if (min == -1) {
			throw new UnsupportedOperationException("unsupported operation: min is -1!");
		}
		return array[min];
	}
}
