package oj.leetcode.string.version;

import static org.junit.Assert.*;

import org.junit.Test;

public class VersionCompareTest {
	
	private final VersionCompare inst = new VersionCompare();

	@Test
	public void test() {
		String version1 = "0.1";
		String version2 = "1.1";
		int ret = inst.compareVersion(version1, version2);
		assertEquals(ret, -1);
		
		ret = inst.compareVersion(version2, version2);
		assertEquals(ret, 0);
		
		ret = inst.compareVersion(version2, version1);
		assertEquals(ret, 1);
		
		version1 = "1.1.2";
		ret = inst.compareVersion(version1, version2);
		assertEquals(ret, 1);
		
		ret = inst.compareVersion(version2, version1);
		assertEquals(ret, -1);
		
		version1 = "1.0";
		version2 = "1";
		ret = inst.compareVersion(version1, version2);
		assertEquals(ret, 0);
	}

}
