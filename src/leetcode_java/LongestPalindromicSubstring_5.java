package leetcode_java;

/*
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example:

Input: "babad"

Output: "bab"

Note: "aba" is also a valid answer.
 

Example:

Input: "cbbd"

Output: "bb"
 */

public class LongestPalindromicSubstring_5 {
	private int maxLen = 0;
	private int lo = 0;
	public String longestPalindrome(String s) {
		int len = s.length();
		if (len < 2)
			return s;
		
	    for (int i = 0; i < len-1; i++) {
	    		longestPalindrome_subfunc(s, i, i);  //assume odd length, try to extend Palindrome as possible
	    		longestPalindrome_subfunc(s, i, i+1); //assume even length.
	    }
	    return s.substring(lo, lo + maxLen);
	}

	private void longestPalindrome_subfunc( String s, int left, int right) {
		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
		}
		if (maxLen < right - left - 1) {
			lo = left + 1;
			maxLen = right - left - 1;
		}
	}
}
