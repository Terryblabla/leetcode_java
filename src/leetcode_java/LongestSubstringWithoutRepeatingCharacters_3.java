package leetcode_java;

/*
 * Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */

import java.util.Arrays;
import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters_3 {
	public int lengthOfLongestSubstring3(String s) {
		int[] arr = new int[256];
		Arrays.fill(arr, -1);
		int begin = 0;
		int maxLength = 0;
		for (int i = 0; i < s.length(); i++) {
			if (arr[s.charAt(i)] >= begin) {
				begin = arr[s.charAt(i)] + 1;
			}
			arr[s.charAt(i)] = i;
			maxLength = (int) Math.max(maxLength, i - begin + 1);
		}
		return maxLength;
	}

	public int lengthOfLongestSubstring2(String s) {
		boolean[] strBool = new boolean[256];
		Arrays.fill(strBool, false);
		int maxLength = 0;
		int begin = 0;
		for (int i = 0; i < s.length(); i++) {
			while (strBool[s.charAt(i)]) {
				strBool[s.charAt(begin)] = false;
				begin++;
			}
			strBool[s.charAt(i)] = true;
			maxLength = (int) Math.max(maxLength, i - begin + 1);
		}
		return maxLength;
	}

	public int lengthOfLongestSubstring(String s) {
		HashMap<Character, Integer> hash = new HashMap<Character, Integer>();

		int begin = 0;
		int maxLength = 0;
		for (int i = 0; i < s.length(); i++) {
			if (hash.containsKey(s.charAt(i))) {
				if (hash.get(s.charAt(i)) >= begin) {
					begin = hash.get(s.charAt(i)) + 1;
				}
				hash.replace(s.charAt(i), i);

			} else {
				hash.put(s.charAt(i), i);
			}
			maxLength = (int) Math.max(maxLength, i - begin + 1);
		}
		return maxLength;
	}
}
