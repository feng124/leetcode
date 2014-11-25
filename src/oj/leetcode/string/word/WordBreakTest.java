package oj.leetcode.string.word;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class WordBreakTest {

	private Set<String> dict;

	@Before
	public void setUp() throws Exception {
		dict = new HashSet<String>();

		dict.add("leet");
		dict.add("code");
		dict.add("lee");
//		dict.add("tcode");
		dict.add("word");
		dict.add("t");
		dict.add("ss");

		dict.add("a");
		dict.add("aa");
		dict.add("aaa");
		dict.add("aaaa");
		dict.add("aaaaa");
		dict.add("aaaaaa");
		dict.add("aaaaaaa");
		dict.add("aaaaaaaa");
		dict.add("aaaaaaaaa");
		dict.add("aaaaaaaaaa");
	}

	@Test
	public void test() {
		WordBreak wb = new WordBreak();

		String str = "leetcode";
		boolean breakable = wb.wordBreak(str, dict);
		assertTrue(breakable);

		str = "wordwordwordword";
		breakable = wb.wordBreak(str, dict);
		assertTrue(breakable);
		
		str = "wordwordword";
		breakable = wb.wordBreak(str, dict);
		assertTrue(breakable);

		str = "leecoword";
		breakable = wb.wordBreak(str, dict);
		assertFalse(breakable);
		
		str = "leettcode";
		breakable = wb.wordBreak(str, dict);
		assertTrue(breakable);

		str = "s";
		breakable = wb.wordBreak(str, dict);
		assertFalse(breakable);

		str = "ssss";
		breakable = wb.wordBreak(str, dict);
		assertTrue(breakable);

		str = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
		breakable = wb.wordBreak(str, dict);
		assertFalse(breakable);
	}

}
