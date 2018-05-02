package leetcode_java;

/*
 * Given a positive integer n and you can do operations as follow:

If n is even, replace n with n/2.
If n is odd, you can replace n with either n + 1 or n - 1.
What is the minimum number of replacements needed for n to become 1?

Example 1:

Input:
8

Output:
3

Explanation:
8 -> 4 -> 2 -> 1
Example 2:

Input:
7

Output:
4

Explanation:
7 -> 8 -> 4 -> 2 -> 1
or
7 -> 6 -> 3 -> 2 -> 1

 */

public class Integer_Replacement_397 {

	/*
	 * When n is even, the operation is fixed. The procedure is unknown when it is
	 * odd. When n is odd it can be written into the form n = 2k+1 (k is a
	 * non-negative integer.). That is, n+1 = 2k+2 and n-1 = 2k. Then, (n+1)/2 = k+1
	 * and (n-1)/2 = k. So one of (n+1)/2 and (n-1)/2 is even, the other is odd. And
	 * the “best” case of this problem is to divide as much as possible. Because of
	 * that, always pick n+1 or n-1 based on if it can be divided by 4. The only
	 * special case of that is when n=3 you would like to pick n-1 rather than n+1.
	 */
	public int integerReplacement(int n) {
		if (n == Integer.MAX_VALUE)
			return 32; // n = 2^31-1;
		int count = 0;
		while (n > 1) {
			if (n % 2 == 0)
				n /= 2;
			else {
				if ((n + 1) % 4 == 0 && (n - 1 != 2)) // n != 3
					n++;
				else
					n--;
			}
			count++;
		}
		return count;
	}

	public int integerReplacementRecursive(int n) {
		if (n == Integer.MAX_VALUE)
			return 32;
		if (n <= 2)
			return n - 1;
		if (n == 3)
			return 2;
		if (n % 2 == 0)
			return integerReplacement(n / 2) + 1;
		else
			return (n & 2) == 0 ? integerReplacement(n - 1) + 1 : integerReplacement(n + 1) + 1;
	}

	/*
	 * we just need to remove as many 1’s as possible, doing +1 in case of a tie?
	 * Not quite. The infamous test with n=3 fails for that strategy because 11 ->
	 * 10 -> 1 is better than 11 -> 100 -> 10 -> 1. Fortunately, that’s the only
	 * exception (or at least I can’t think of any other, and there are none in the
	 * tests).
	 * 
	 * So the logic is:
	 * 
	 * If n is even, halve it. If n=3 or n-1 has less 1’s than n+1, decrement n.
	 * Otherwise, increment n.
	 */
	public int integerReplacementBitMethod(int n) {
		int c = 0;
		while (n != 1) {
			if ((n & 1) == 0) {
				n >>>= 1;
			} else if (n == 3 || Integer.bitCount(n + 1) > Integer.bitCount(n - 1)) {
				--n;
			} else {
				++n;
			}
			++c;
		}
		return c;
	}
}
