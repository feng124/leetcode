package oj.leetcode.num.binary;

import static org.junit.Assert.*;

import org.junit.Test;

public class AddBinaryTest {
	
	private final AddBinary inst = new AddBinary();

	@Test
	public void test() {
		
		System.out.println(1 << 1);
		
		String a = "11";
		String b = "1";
		String c = inst.addBinary(a, b);
		assertEquals(c, "100");
		
		a = "100101";
		b = "11";
		c = inst.addBinary(a, b);
		assertEquals(c, "101000");
		
	}

}
