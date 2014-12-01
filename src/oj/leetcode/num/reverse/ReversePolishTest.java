package oj.leetcode.num.reverse;

import static org.junit.Assert.*;

import org.junit.Test;

public class ReversePolishTest {

	private ReversePolish rpn = new ReversePolish();

	@Test
	public void test() {
		String[] toks = new String[] { "2", "1", "+", "3", "*" };
		int val = rpn.evalRPN(toks);
		assertEquals(val, 9);

		toks = new String[] { "4", "13", "5", "/", "+" };
		val = rpn.evalRPN(toks);
		assertEquals(val, 6);
		
		toks = new String[] {"18"};
		val = rpn.evalRPN(toks);
		assertEquals(val, 18);
		
		toks = new String[] {"8", "1", "2", "+", "2", "*", "-"};
		val = rpn.evalRPN(toks);
		assertEquals(val, 2);
	}

}
