package oj.leetcode.array;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

public class FindMinTest {
	
	private int[] createRotateArray(int size) {
		int[] array = null;
		if (size >= 0) {
			array = new int[size];
			if (size != 0) {
				Random rand = new Random();
				int st = rand.nextInt(size);
				for (int i = st; i < size; i++) {
					array[i] = (i - st);
				}
				for (int i = 0; i < st; i++) {
					array[i] = i + size - st;
				}
			}
		}
		return array;
	}

	@Test
	public void test() {
		
		FindMin inst = new FindMin();
		
		int[] array = createRotateArray(-1);
		assertNull(array);
		
		array = createRotateArray(0);
		assertEquals(array.length, 0);
		
		array = createRotateArray(8);
		int pivot = inst.findMin(array);
		assertEquals(pivot, 0);

		pivot = inst.findMin(new int[] { 0, 1 });
		assertEquals(pivot, 0);

		pivot = inst.findMin(new int[] { 1, 0 });
		assertEquals(pivot, 0);

		pivot = inst.findMin(new int[] { 0, 1, 2 });
		assertEquals(pivot, 0);

		pivot = inst.findMin(new int[] { 1, 2, 0 });
		assertEquals(pivot, 0);

		pivot = inst.findMin(new int[] { 2, 0, 1 });
		assertEquals(pivot, 0);

		pivot = inst.findMin(new int[] { 0, 1, 2, 4, 5, 6, 7 });
		assertEquals(pivot, 0);

		pivot = inst.findMin(new int[] { 1, 2, 4, 5, 6, 7, 0 });
		assertEquals(pivot, 0);

		pivot = inst.findMin(new int[] { 2, 4, 5, 6, 7, 0, 1 });
		assertEquals(pivot, 0);

		pivot = inst.findMin(new int[] { 4, 5, 6, 7, 0, 1, 2 });
		assertEquals(pivot, 0);

		pivot = inst.findMin(new int[] { 5, 6, 7, 0, 1, 2, 4 });
		assertEquals(pivot, 0);

		pivot = inst.findMin(new int[] { 6, 7, 0, 1, 2, 4, 5 });
		assertEquals(pivot, 0);

		pivot = inst.findMin(new int[] { 7, 0, 1, 2, 4, 5, 6 });
		assertEquals(pivot, 0);
	}

}
