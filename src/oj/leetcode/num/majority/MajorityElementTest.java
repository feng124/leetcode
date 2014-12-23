package oj.leetcode.num.majority;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class MajorityElementTest {
	
	private final MajorityElement inst = new MajorityElement();

	@Test
	public void test() {
		int[] num = new int[] {1, 2, 1};
		int majority = inst.majorityElement(num);
		assertEquals(majority, 1);
		
		num = new int[] {1, 1, 1, 1, 2, 2, 2, 2, 2};
		majority = inst.majorityElement(num);
		assertEquals(majority, 2);
		
		List list = Arrays.asList(num);
		Collections.shuffle(list);
		for(int i = 0; i < num.length; i++) {
			num[i] = (int) list.get(i);
		}
		majority = inst.majorityElement(num);
		assertEquals(majority, 2);
		
	}

}
