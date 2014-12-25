package oj.leetcode.array.sudoku;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 * 
 * The Sudoku board could be partially filled, where empty cells are filled with
 * the character '.'.
 * 
 * Note: A valid Sudoku board (partially filled) is not necessarily solvable.
 * Only the filled cells need to be validated.
 *
 */
public class SudokuChart {

	private final Map<String, List<Integer>> pos_map = new HashMap<String, List<Integer>>();

	public boolean isValidSudoku(char[][] board) {

		boolean is_valid = true;
		for (int i = 0; i < board.length; ++i) {
			for (int j = 0; j < board[i].length; ++j) {
				if (board[i][j] != '.') {
					int val = board[i][j] - '0';
					String key = "r" + i;
					if (!pos_map.containsKey(key)) {
						pos_map.put(key, new ArrayList<Integer>());
					}
					List<Integer> pos_list = pos_map.get(key);
					if (pos_list.contains(val)) {
						is_valid = false;
						break;
					}
					pos_list.add(val);

					key = "c" + j;
					if (!pos_map.containsKey(key)) {
						pos_map.put(key, new ArrayList<Integer>());
					}
					pos_list = pos_map.get(key);
					if (pos_list.contains(val)) {
						is_valid = false;
						break;
					}
					pos_list.add(val);

					key = "q" + ((i / 3) * 3 + (j / 3));
					if (!pos_map.containsKey(key)) {
						pos_map.put(key, new ArrayList<Integer>());
					}
					pos_list = pos_map.get(key);
					if (pos_list.contains(val)) {
						is_valid = false;
						break;
					}
					pos_list.add(val);
				}
			}
		}

		pos_map.clear();
		return is_valid;

	}
	
}
