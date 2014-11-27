package oj.leetcode.string.word2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.Vector;

/**
 * 
 * Given a string s and a dictionary of words dict, add spaces in s to construct
 * a sentence where each word is a valid dictionary word.
 * 
 * Return all such possible sentences.
 * 
 * For example, given s = "catsanddog", dict = ["cat", "cats", "and", "sand",
 * "dog"].
 * 
 * A solution is ["cats and dog", "cat sand dog"].
 *
 */
public class WordBreak {

	private List<Vector<Integer>> break_points_list = new ArrayList<Vector<Integer>>();

	public List<String> wordBreak(String s, Set<String> dict) {
		
		break_points_list.clear();

		int cnt = breakByDict(s, dict);
		if (cnt == 0) {
			return Collections.emptyList();
		}

		List<String> sentences = new ArrayList<String>();
		for (Vector<Integer> break_points : break_points_list) {
			if (break_points == null || break_points.isEmpty()) {
				continue;
			}

//			Collections.sort(break_points);
			StringBuffer buf = new StringBuffer(s);
			for (int i = break_points.size() - 1; i >= 0; i--) {
				int offset = break_points.get(i);
				if (offset < buf.length()) {
					buf.insert(offset, ' ');
				}
			}
			sentences.add(buf.toString());
		}

		return sentences;

	}

	public int breakByDict(String s, Set<String> dict) {
		return breakByDict(s, dict, true);
	}

	/**
	 * 
	 * @param sub
	 * @param dict
	 * @param direct
	 *            true for left; false for right;
	 * @return
	 */
	public int breakByDict(String s, Set<String> dict, boolean direct) {
		int cnt = 0;
		for (String w : dict) {
			if (w.equals(s)) {
				Vector<Integer> break_points = new Vector<Integer>();
				break_points.add(w.length());
				
				break_points_list.add(break_points);
				cnt++;
//				break;
				continue;
			} else if (direct && s.startsWith(w)) {
				String sub = s.substring(w.length());
				int tmp = breakByDict(sub, dict, !direct);
				if (tmp > 0) {
					for (int i = 0; i < tmp; i++) {
						Vector<Integer> break_points = break_points_list
								.get(break_points_list.size() - 1 - i);
						if (break_points != null) {
							for (int ip = break_points.size() - 1; ip >= 0; ip--) {
								int real_offset = break_points.get(ip)
										+ w.length();
								break_points.set(ip, real_offset);
							}
							break_points.add(0, w.length());
						}
					}
					cnt += tmp;
				}
			} else if (!direct && s.endsWith(w)) {
				String sub = s.substring(0, s.length() - w.length());
				int tmp = breakByDict(sub, dict, !direct);
				if (tmp > 0) {
					for (int i = 0; i < tmp; i++) {
						Vector<Integer> break_points = break_points_list
								.get(break_points_list.size() - 1 - i);
						if (break_points != null) {
							break_points.add(s.length());
						}
					}
					cnt += tmp;
				} 
			}
		}

		return cnt;
	}

}
