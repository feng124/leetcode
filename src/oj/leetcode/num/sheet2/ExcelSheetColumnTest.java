package oj.leetcode.num.sheet2;

import static org.junit.Assert.*;

import org.junit.Test;

public class ExcelSheetColumnTest {
	
	private final ExcelSheetColumn inst = new ExcelSheetColumn();

	@Test
	public void test() {
		int val = inst.titleToNumber("A");
		assertEquals(val, 1);
		
		val = inst.titleToNumber("Z");
		assertEquals(val, 26);
		
		val = inst.titleToNumber("AA");
		assertEquals(val, 27);
		
		val = inst.titleToNumber("AZ");
		assertEquals(val, 52);
		
	}

}
