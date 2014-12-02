package oj.leetcode.num.reverse;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * 
 * Valid operators are +, -, *, /. Each operand may be an integer or another
 * expression.
 * 
 * Some examples:
 * 
 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9 
 * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 *
 */
public class ReversePolish {

	private Deque<Integer> stack = new ArrayDeque<Integer>();

	public int evalRPN(String[] tokens) {
		stack.clear();

		int val = 0;

		for (String tok : tokens) {
			if (isOperator(tok)) {
				int size = stack.size();
				if (size < 2) {
					throw new IllegalArgumentException("");
				}
				int right = stack.pop();
				int left = stack.pop();
				val = doOperation(left, right, tok);
				stack.push(val);
			} else {
				val = Integer.parseInt(tok);
				stack.push(val);
			}
		}

		return val;

	}

	private int doOperation(int left, int right, String tok) {
		if (tok.equals("+")) {
			return left + right;
		}
		if (tok.equals("-")) {
			return left - right;
		}
		if (tok.equals("*")) {
			return left * right;
		}
		if (tok.equals("/")) {
			return left / right;
		}
		return 0;
	}

	private boolean isOperator(String tok) {
		if (tok.equals("+") || tok.equals("-") || tok.equals("*")
				|| tok.equals("/")) {
			return true;
		}
		return false;
	}
}
