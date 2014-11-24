package oj.leetcode.minstack;

import static org.junit.Assert.*;

import org.junit.Test;

public class MinStackTest {

	@Test
	public void test() {
		MinStack sol = new MinStack();
		
		sol.push(11);

		sol.push(1);
		sol.push(6);

		sol.push(2);
		sol.push(3);
		sol.push(4);
		sol.push(5);

		sol.push(7);
		sol.push(8);

		int min = sol.getMin();
		assertEquals(min, 1);
		int top = sol.top();
		assertEquals(top, 8);

		sol.pop();

		sol.push(9);

		top = sol.top();
		assertEquals(top, 9);

		sol.pop();
		top = sol.top();
		assertEquals(top, 7);

		min = sol.getMin();
		assertEquals(min, 1);

		sol.pop();

		sol.push(10);

		sol.pop();

		min = sol.getMin();
		assertEquals(min, 1);
		
		sol.push(-2);
		min = sol.getMin();
		assertEquals(min, -2);
		
		sol.pop();
		sol.pop();
		
		min = sol.getMin();
		assertEquals(min, 1);
		
	}
	
	@Test
	public void test2() {
		MinStack sol = new MinStack();
		
		for(int i = -10000; i < 50000; i++) {
			sol.push(i);
		}
		
		for(int i = 49999; i > -10001; i--) {
			int top = sol.top();
			assertEquals(top, i);
			int min = sol.getMin();
			assertEquals(min, -10000);
			sol.pop();
		}
	}

}
