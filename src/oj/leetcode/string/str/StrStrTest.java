package oj.leetcode.string.str;

import static org.junit.Assert.*;

import org.junit.Test;

public class StrStrTest {
	
	private final StrStr inst = new StrStr();

	@Test
	public void test() {
		String haystack = "abcdacdaahfacabcdabcdeaa";
		String needle = "abcde";
		int idx = inst.strStr(haystack, needle);
		assertEquals(idx, 17);
		
		idx = inst.strStr(needle, haystack);
		assertEquals(idx, -1);
		
		haystack = "substring searching algorithm";
		needle = "search";
		idx = inst.strStr(haystack, needle);
		assertEquals(idx, 10);
		
		haystack = "mississippi";
		needle = "a";
		idx = inst.strStr(haystack, needle);
		assertEquals(idx, -1);
	}

}
