package oj.leetcode.string.word;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * 
 * Given a string s and a dictionary of words dict, determine if s can be
 * segmented into a space-separated sequence of one or more dictionary words.
 * 
 * For example, given s = "leetcode", dict = ["leet", "code"].
 * 
 * Return true because "leetcode" can be segmented as "leet code".
 *
 */
public class WordBreak {

	public boolean wordBreak(String s, Set<String> dict) {

		boolean ret = false;

		List<String> start_words = new ArrayList<String>();
		List<String> end_words = new ArrayList<String>();
		if (!s.isEmpty()) {

			for (String word : dict) {
				if (s.startsWith(word)) {
					start_words.add(word);
				}
				if (s.endsWith(word)) {
					end_words.add(word);
				}
			}

			ret = false;
			if (!start_words.isEmpty() && !end_words.isEmpty()) {
				for (String sw : start_words) {
					if (sw.length() == s.length()) {
						ret = true;
						break;
					}

					for (String ew : end_words) {
						int length = sw.length() + ew.length();
						if (length == s.length()) {
							ret = true;
							break;
						}

						int start = sw.length();
						int end = s.length() - ew.length();
						if (start < end) {
							String res = s.substring(start, end);
							boolean tmp = wordBreak(res, dict);
							if (tmp) {
								ret = true;
								break;
							}
						}
					}
					if (ret) {
						break;
					}
				}
			}

			start_words.clear();
			end_words.clear();
		}

		return ret;
	}
}
