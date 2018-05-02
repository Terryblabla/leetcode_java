package leetcode_java;

import java.util.ArrayList;

/*
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int numRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".


Another example
a         a         a
a       a a       a a       a
a     a   a     a   a     a   
a   a     a   a     a   a     
a a       a a       a a       
a         a         a
 */

public class ZigZagConversion_6 {
	public String convert(String s, int numRows) {
		if (numRows <= 1 || null == s || s.length() <= 2) {
			return s;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < numRows; i++) {
			if (i == 0 || i == numRows - 1) {
				int step = 2 * (numRows - 1);
				for (int j = i; j < s.length(); j += step) {
					sb.append(s.charAt(j));
				}
			} else {
				boolean flag = true;
				int step1 = 2 * (numRows - i - 1);
				int step2 = 2 * i;
				for (int j = i; j < s.length();) {
					sb.append(s.charAt(j));
					if (flag) {
						j = j + step1;
					} else {
						j = j + step2;
					}
					flag = !flag;
				}
			}
		}
		return sb.toString();
	}
}
