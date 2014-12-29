package oj.leetcode.string.parenthese;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 
 * Given a string containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid.
 * 
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid
 * but "(]" and "([)]" are not.
 *
 */
public class ParentheseValidator {
	
	private final Deque<Character> stack = new ArrayDeque<Character>();

	public boolean isValid(String s) {
		boolean ret = true;
		for(int i = 0; i < s.length(); ++i) {
			char ch = s.charAt(i);
			
			if (ch == '(' || ch == '[' || ch == '{') {
				stack.push(ch);
				continue;
			}
			
			if (stack.isEmpty()) {
				ret = false;
				break;
			}
			
			char top = stack.pop();
			if (ch == ')' && top != '(') {
				ret = false;
				break;
			}else if (ch == ']' && top != '[') {
				ret = false;
				break;
			}else if (ch == '}' && top != '{') {
				ret = false;
				break;
			}
			
		}
		if (!stack.isEmpty()) {
			ret = false;
			stack.clear();
		}
		return ret;
	}

}
