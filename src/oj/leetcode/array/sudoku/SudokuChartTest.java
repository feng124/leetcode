package oj.leetcode.array.sudoku;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class SudokuChartTest {

	private final SudokuChart inst = new SudokuChart();

	@Test
	public void test() {
		int[][] array = new int[][] { { 0, 0, 5 }, { 0, 1, 3 }, { 0, 4, 7 },
				{ 1, 0, 6 }, { 1, 3, 1 }, { 1, 4, 9 }, { 1, 5, 5 },
				{ 2, 1, 9 }, { 2, 2, 8 }, { 2, 7, 6 }, { 3, 0, 8 },
				{ 3, 4, 6 }, { 3, 8, 3 }, { 4, 0, 4 }, { 4, 3, 8 },
				{ 4, 5, 3 }, { 4, 8, 1 }, { 5, 0, 7 }, { 5, 4, 2 },
				{ 5, 8, 6 }, { 6, 1, 6 }, { 6, 6, 2 }, { 6, 7, 8 },
				{ 7, 3, 4 }, { 7, 4, 1 }, { 7, 5, 9 }, { 7, 8, 5 },
				{ 8, 4, 8 }, { 8, 7, 7 }, { 8, 8, 9 } };
		char[][] chart = buildChart(array);
		boolean is_valid = inst.isValidSudoku(chart);
		assertTrue(is_valid);
		
		array = new int[][] { { 0, 0, 5 }, { 0, 1, 3 }, { 0, 4, 7 },
				{ 1, 0, 6 }, { 1, 3, 1 }, { 1, 4, 9 }, { 1, 5, 5 },
				{ 2, 1, 9 }, { 2, 2, 8 }, { 2, 7, 6 }, { 3, 0, 8 },
				{ 3, 1, 6 }, { 3, 8, 3 }, { 4, 0, 4 }, { 4, 3, 8 },
				{ 4, 5, 3 }, { 4, 8, 1 }, { 5, 0, 7 }, { 5, 4, 2 },
				{ 5, 8, 6 }, { 6, 1, 6 }, { 6, 6, 2 }, { 6, 7, 8 },
				{ 7, 3, 4 }, { 7, 4, 1 }, { 7, 5, 9 }, { 7, 8, 5 },
				{ 8, 4, 8 }, { 8, 7, 7 }, { 8, 8, 9 } };
		chart = buildChart(array);
		is_valid = inst.isValidSudoku(chart);
		assertFalse(is_valid);
	}

	private char[][] print(char[][] chart) {
		StringBuffer buf = new StringBuffer();
		for(int i = 0; i < chart.length; i++) {
			for(int j = 0; j < chart[i].length; j++) {
				if (chart[i][j] == '.') {
					buf.append(' ');
				}else {
					buf.append(chart[i][j]);
				}
				buf.append(' ');
			}
			buf.append('\n');
		}
		System.out.println(buf.toString());
		return chart;
	}

	private char[][] buildChart(int[][] array) {
		char[][] chart = new char[9][];
		for(int i = 0; i < chart.length; i++) {
			chart[i] = new char[9];
			Arrays.fill(chart[i], '.');
		}
		for(int i = 0; i < array.length; i++) {
			int x = array[i][0];
			int y = array[i][1];
			chart[x][y] = (char) (array[i][2]+'0');
		}
		
		return print(chart);
	}

}
