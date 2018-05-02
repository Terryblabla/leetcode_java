package leetcode_java;

import java.util.Iterator;
import java.util.LinkedList;

/*
 * We define the Perfect Number is a positive integer that is equal to the sum of all its positive divisors except itself.
 * Now, given an integer n, write a function that returns true when it is a perfect number and false when it is not.
 * Example:
Input: 28
Output: True
Explanation: 28 = 1 + 2 + 4 + 7 + 14
Note: The input number n will not exceed 100,000,000. (1e8)
 */
public class Perfect_Number_507 {
	public boolean checkPerfectNumber(int num) {
		if(num < 4) return false;
		LinkedList<Integer> list = new LinkedList<Integer>();
		for(int i = 2; i <= Math.sqrt(num); i++) {
			if(num % i == 0) {
				list.add(i);
				list.add(num / i);
			}
		}
		Iterator<Integer> iter = list.iterator();
		int sum = 0;
		while(iter.hasNext()) {
			sum += iter.next();
		}
		return (sum + 1 == num);
	}
}
