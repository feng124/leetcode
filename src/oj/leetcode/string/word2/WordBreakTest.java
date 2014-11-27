package oj.leetcode.string.word2;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import org.junit.Before;
import org.junit.Test;

public class WordBreakTest {

	private Set<String> dict = new HashSet<String>();

	@Test
	public void test() {

		String[] str = new String[] { "cat", "cats", "and", "sand", "dog", "s" };
		dict.addAll(Arrays.asList(str));

		WordBreak wb = new WordBreak();
		int cnt = wb.breakByDict("catsanddog", dict);
		assertEquals(cnt, 3);
		
		cnt = wb.breakByDict("catsandddog", dict);
		assertEquals(cnt, 0);
		
		List<String> sentences = wb.wordBreak("catsanddog", dict);
		for(String sent : sentences) {
			System.out.println(sent);
		}
	}

}
