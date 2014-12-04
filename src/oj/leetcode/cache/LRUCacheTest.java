package oj.leetcode.cache;

import static org.junit.Assert.*;

import org.junit.Test;

public class LRUCacheTest {
	
	private LRUCache cache = null;

	@Test
	public void test() {
		cache = new LRUCache(10);
		
		for(int i = 0; i < 10; i++) {
			cache.set(i, i*i);
		}
		
		int ret = cache.get(8);
		assertEquals(ret, 64);
		
		ret = cache.get(11);
		assertEquals(ret, -1);
		
		cache.set(11, 121);
		ret = cache.get(0);
		assertEquals(ret, -1);
		
		ret = cache.get(11);
		assertEquals(ret, 121);
		
		ret = cache.get(4);
		assertEquals(ret, 16);
		
		ret = cache.get(1);
		assertEquals(ret, 1);
		
		cache.set(4, 32);
		ret = cache.get(4);
		assertEquals(ret, 32);
		
		cache = new LRUCache(2);
		cache.set(2, 1);
		cache.set(2, 2);
		ret = cache.get(2);
		assertEquals(ret, 2);
		cache.set(1, 1);
		cache.set(4, 1);
		ret = cache.get(2);
		assertEquals(ret, -1);
	}

}
