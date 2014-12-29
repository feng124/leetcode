package oj.leetcode.string.zigzag;

import static org.junit.Assert.*;

import org.junit.Test;

public class ZigZagConvertTest {

	private final ZigZagConvert inst = new ZigZagConvert();

	@Test
	public void test() {
		String zz = inst.convert("PAYPALISHIRING", 3);
		assertEquals(zz, "PAHNAPLSIIGYIR");
		
		zz = inst.convert("PAYPALISHIRING", 4);
		assertEquals(zz, "PINALSIGYAHRPI");
		
		zz = inst.convert("PAYPALISHIRING", 2);
		assertEquals(zz, "PYAIHRNAPLSIIG");
		
		zz = inst.convert("A", 1);
		assertEquals(zz, "A");
		
		zz = inst.convert("AB", 1);
		assertEquals(zz, "AB");
		
		zz = inst.convert("ABCDE", 4);
		assertEquals(zz, "ABCED");
	}

}
