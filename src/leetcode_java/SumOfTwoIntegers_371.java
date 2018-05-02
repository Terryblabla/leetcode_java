package leetcode_java;

/*
Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.

Example:
Given a = 1 and b = 2, return 3.

Credits:
Special thanks to @fujiaozhu for adding this problem and creating all test cases.
 */
public class SumOfTwoIntegers_371 {
	public int getSum(int a, int b) {
		return b == 0 ? a : getSum(a ^ b, (a & b) << 1);
	}

	public int getSumIter(int a, int b) {
		if (a == 0)
			return b;
		if (b == 0)
			return a;

		while (b != 0) {
			int carry = a & b;
			a = a ^ b;
			b = carry << 1;
		}

		return a;
	}

	public int getSubtractIter(int a, int b) {
		// assume 9 - 3
		// 1001 - 0011
		// iter1: a = 1010, b = 0100
		// iter2: a = 1110, b = 1000
		// iter3: a = 0110, b = 
		while (b != 0) {
			int borrow = (~a) & b;
			a = a ^ b;
			b = borrow << 1;
		}

		return a;
	}

	public int getSubtract(int a, int b) {
		return (b == 0) ? a : getSubtract(a ^ b, (~a & b) << 1);
	}

}
