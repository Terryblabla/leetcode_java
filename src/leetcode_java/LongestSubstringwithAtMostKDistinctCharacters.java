package leetcode_java;

/*
 * "aabbcc", k = 1
Max substring can be any one from {"aa" , "bb" , "cc"}.

"aabbcc", k = 2
Max substring can be any one from {"aabb" , "bbcc"}.

"aabbcc", k = 3
There are substrings with exactly 3 unique characters
{"aabbcc" , "abbcc" , "aabbc" , "abbc" }
Max is "aabbcc" with length 6.

"aaabbb", k = 3
There are only two unique characters, thus show error message. 
 */

import java.util.HashMap;

public class LongestSubstringwithAtMostKDistinctCharacters {
	// User number 2 as an example
	public int lengthOfLongestSubstringTwoDistinct(String s) {
		int max = 0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int start = 0;

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}

			if (map.size() > 2) {
				max = Math.max(max, i - start);

				while (map.size() > 2) {
					char t = s.charAt(start);
					int count = map.get(t);
					if (count > 1) {
						map.put(t, count - 1);
					} else {
						map.remove(t);
					}
					start++;
				}
			}
		}

		max = Math.max(max, s.length() - start);

		return max;
	}

	// Take K as limits and determine if map needs delete the previous one
	public int lengthOfLongestSubstringKDistinct(String s, int k) {
		if (k == 0 || s == null || s.length() == 0)
			return 0;

		if (s.length() < k)
			return s.length();

		HashMap<Character, Integer> map = new HashMap<Character, Integer>();

		int maxLen = k;
		int left = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}

			// map size cannot over k
			if (map.size() > k) {
				maxLen = Math.max(maxLen, i - left);

				// clean map until size equal to k
				while (map.size() > k) {

					char t = s.charAt(left);
					if (map.get(t) == 1) {
						map.remove(t);
					} else {
						map.put(t, map.get(t) - 1);
					}

					left++;
				}
			}

		}

		maxLen = Math.max(maxLen, s.length() - left);

		return maxLen;
	}
}
