package oj.leetcode.num.countsay;

import static org.junit.Assert.*;

import org.junit.Test;

public class CountSayTest {
	
	private final CountSay inst = new CountSay();

	@Test
	public void test() {
		String str = inst.countAndSay(4);
		assertEquals(str, "1211");
		
		str = inst.countAndSay(5);
		assertEquals(str, "111221");
		
		str = inst.countAndSay(1);
		assertEquals(str, "1");
	}

}
