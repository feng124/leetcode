package oj.leetcode.num.sheet;

import static org.junit.Assert.*;

import org.junit.Test;

public class ExcelSheetColumnTest {
	
	private final ExcelSheetColumn inst = new ExcelSheetColumn();

	@Test
	public void test() {
		
		int col = 1;
		String res = inst.convertToTitle(col);
		assertEquals(res, "A");
		
		col = 26;
		res = inst.convertToTitle(col);
		assertEquals(res, "Z");
		
		col = 52;
		res = inst.convertToTitle(col);
		assertEquals(res, "AZ");
		
		col = 27;
		res = inst.convertToTitle(col);
		assertEquals(res, "AA");
		
		col = 1379;
		res = inst.convertToTitle(col);
		assertEquals(res, "BAA");
		
		col = 1404;
		res = inst.convertToTitle(col);
		assertEquals(res, "BAZ");
		
		col = 2029;
		res = inst.convertToTitle(col);
		assertEquals(res, "BZA");
		
		col = 729;
		res = inst.convertToTitle(col);
		assertEquals(res, "ABA");
		
		col = 702;
		res = inst.convertToTitle(col);
		assertEquals(res, "ZZ");
		
		col = 703;
		res = inst.convertToTitle(col);
		assertEquals(res, "AAA");
		
	}
	
	

}
