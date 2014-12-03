package oj.leetcode.num.pascal2;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class PascalTriangleTest {

	@Test
	public void test() {
		PascalTriangle pt = new PascalTriangle();
		List<Integer> ret = pt.getRow(3);
		assertEquals(ret.size(), 4);
		assertEquals(ret.get(0).intValue(), 1);
		assertEquals(ret.get(1).intValue(), 3);
		assertEquals(ret.get(2).intValue(), 3);
		assertEquals(ret.get(3).intValue(), 1);
		
		ret = pt.getRow(6);
		assertEquals(ret.size(), 7);
		assertEquals(ret.get(0).intValue(), 1);
		assertEquals(ret.get(1).intValue(), 6);
		assertEquals(ret.get(2).intValue(), 15);
		assertEquals(ret.get(3).intValue(), 20);
		assertEquals(ret.get(4).intValue(), 15);
		assertEquals(ret.get(5).intValue(), 6);
		assertEquals(ret.get(6).intValue(), 1);
		
		ret = pt.getRow(0);
		assertEquals(ret.size(), 1);
		assertEquals(ret.get(0).intValue(), 1);
	}

}
