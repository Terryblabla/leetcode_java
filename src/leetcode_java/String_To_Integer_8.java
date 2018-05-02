package leetcode_java;
/*
 * Implement atoi to convert a string to an integer.

Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.

 

Requirements for atoi:

The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.

The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

If no valid conversion could be performed, a zero value is returned. If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
 */

public class String_To_Integer_8 {

	public int myAtoi(String str) {
		if (null == str || str.length() < 1) return 0;
		double rtval = 0;
		int len = str.length();
		int sign = 1;
		int i = 0;
		// pass all spaces before the first character
		while (i < len && str.charAt(i) == ' ') i++;
		
		// check the first character and return 0 if restrictions are not met. 
		if(i < len && str.charAt(i) == '-') {
			sign = -1;
			i++;
		} else if ( i < len && str.charAt(i) == '+' ) {
			sign = 1;
			i++;
		} else if (i < len && str.charAt(i) >= '0' && str.charAt(i) <= '9' ) {
			sign = 1;
		} else {
			return 0;
		}
		
		for (; i < len; i++) {
			char c = str.charAt(i);

			if (c >= '0' && c <= '9') {
				rtval = (rtval * 10) + (c - '0');
			} else {
				break;
			}
		}
		rtval *= sign;

		if (rtval < Integer.MIN_VALUE) return Integer.MIN_VALUE;
		if (rtval > Integer.MAX_VALUE) return Integer.MAX_VALUE;
		return (int) rtval;
	}

	public static void main(String[] args) {
		char space = ' ';
		String str = " ";
		if (str.charAt(0) == ' ')
			System.out.println("str.charAt(0) == \' \'");
		if (str.charAt(0) == space)
			System.out.println("str.charAt(0) == space");
		System.out.println(Double.MAX_VALUE);
		
	}

}
