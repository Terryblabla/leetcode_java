package leetcode_java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

Check a phone to see how number matches letters

Example:

Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:

Although the above answer is in lexicographical order, your answer could be in any order you want.


 */

/* Qustions:
 * 1. how long is this digit string
 * 2. will long or int handle its value? 
 */

public class ND_Letter_Combinations_Of_A_Phone_Number_17 {
	public List<String> letterCombinationsMethod2(String digits) {
		if (null == digits)
			throw new NullPointerException();
		HashMap<Integer, ArrayList<String>> map = new HashMap<Integer, ArrayList<String>>();
		String[] letterarray = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q",
				"r", "s", "t", "u", "v", "w", "x", "y", "z" };
		for (int i = 2; i <= 9; i++) {
			ArrayList<String> strlist = new ArrayList<String>();
			int tempindex = 0;
			if (i == 9) {
				strlist.add("w");
				strlist.add("x");
				strlist.add("y");
				strlist.add("z");
			} else if (i == 7) {
				strlist.add("p");
				strlist.add("q");
				strlist.add("r");
				strlist.add("s");
			} else if (i == 8) {
				strlist.add("t");
				strlist.add("u");
				strlist.add("v");
			} else {
				strlist.add(letterarray[(i - 2) * 3 + tempindex++]);
				strlist.add(letterarray[(i - 2) * 3 + tempindex++]);
				strlist.add(letterarray[(i - 2) * 3 + tempindex++]);
			}
			map.put(i, strlist);
		}
		ArrayList<String> returnlist = new ArrayList<String>();

		for (int i = 0; i < digits.length(); i++) {
			int num = Character.getNumericValue(digits.charAt(i));
			ArrayList<String> strlist = map.get(num);
			ArrayList<String> templist = new ArrayList<String>();
			if (null == strlist)
				throw new NullPointerException();
			for (int j = 0; j < strlist.size(); j++) {
				if (returnlist.isEmpty()) {
					templist.add(strlist.get(j));
				} else {
					for (int k = 0; k < returnlist.size(); k++) {
						templist.add(returnlist.get(k) + strlist.get(j));
					}
				}
			}
			returnlist = templist;

		}
		return returnlist;
	}

	public List<String> letterCombinations(String digits) {
		if (null == digits)
			throw new NullPointerException();
		String[] dictionary = { " ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz", };

		ArrayList<String> returnlist = new ArrayList<String>();
		if(digits.isEmpty()) return returnlist;
		returnlist.add("");

		// this may be overflow
		// int number = Integer.parseInt(digits);
		for (int i = 0; i < digits.length(); i++) {
			String str = dictionary[digits.charAt(i) - '0'];
			ArrayList<String> templist = new ArrayList<String>();
			for(int j = 0; j < returnlist.size(); j++) {
				for(int k = 0; k < str.length(); k++) {
					templist.add(returnlist.get(j) + str.charAt(k) );
				}
			}
			returnlist = templist;
		}

		return returnlist;
	}
}
