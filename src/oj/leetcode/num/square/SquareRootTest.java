package oj.leetcode.num.square;

import static org.junit.Assert.*;

import org.junit.Test;

public class SquareRootTest {
	
	private final SquareRoot sr = new SquareRoot();

	@Test
	public void test() {
		int val = 1 << 20;
		int root = sr.sqrt(val);
		assertEquals(root, 1024);
		
		val = 1 << 19;
		root = sr.sqrt(val);
		assertEquals(root, 724);
		
		val = (1 << 20) - 345;
		root = sr.sqrt(val);
		assertEquals(root, 1023);
		
		val = (1 << 19) - 8739;
		root = sr.sqrt(val);
		assertEquals(root, 718);
		
		root = sr.sqrt(2147483647);
		assertEquals(root, 46340);
		
		root = sr.sqrt(0);
		assertEquals(root, 0);
	}

}
