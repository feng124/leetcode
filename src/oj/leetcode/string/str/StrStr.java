package oj.leetcode.string.str;

import java.util.Arrays;

/**
 * 
 * Implement strStr().
 * 
 * Returns the index of the first occurrence of needle in haystack, or -1 if
 * needle is not part of haystack.
 * 
 * Update (2014-11-02): The signature of the function had been updated to return
 * the index instead of the pointer. If you still see your function signature
 * returns a char * or String, please click the reload button to reset your code
 * definition.
 *
 */
public class StrStr {

	private final int[] next = new int[128];
	
	public int strStr(String haystack, String needle) {
		
		if (haystack.length() < needle.length()) {
			return -1;
		}
		
		Arrays.fill(next, needle.length() + 1);
		for (int i = 0; i < needle.length(); i++) {
			int idx = needle.charAt(i);
			next[idx] = needle.length() - i;
		}
		int pos = 0;
		int bound = haystack.length() - needle.length() + 1;
		while(pos < bound) {
			int i = pos;  
	        int j = 0;
	        for(; j < needle.length(); j++, i++) {
	        	char src = haystack.charAt(i);
	        	char des = needle.charAt(j);
	        	if (src != des) {
	        		int np = pos+needle.length();
	        		if (np < haystack.length()) {
	        			pos += next[haystack.charAt(np)];
	        		}else {
	        			pos += 1;
	        		}
	        		break;
	        	}
	        }
	        if (j == needle.length()) {
	        	return pos;
	        }
		}
		return -1;
	}
}
