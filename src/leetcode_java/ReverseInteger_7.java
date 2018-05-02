package leetcode_java;

/*
 * Given a 32-bit signed integer, reverse digits of an integer.

Example 1:

Input: 123
Output:  321
Example 2:

Input: -123
Output: -321
Example 3:

Input: 120
Output: 21
Note:
Assume we are dealing with an environment which could only hold integers 
within the 32-bit signed integer range. For the purpose of this problem,
assume that your function returns 0 when the reversed integer overflows.
 */

public class ReverseInteger_7 {
	// This func isn't perfectly working
	// 1. sum may overflow -- need t change sum to Double or check with (Integer.MAX_VALUE) / 10 or (Integer.MIN_VALUE / 10) 
	// 2. two iteration may be merged into one. 
	public int reverse(int x) {
        if(x < 10 && x > (-10)){
            return x;
        }
        int times = 0;
        int[] arr = new int[16];
        int ptr = 0;
        while(x != 0){
            times++;
            arr[ptr] = x % 10;
            ptr++;
            x = x/10;
        }
        int sum = 0;
        for(int i = 0; i< ptr; i++){
            times--;            
            sum += arr[i] * Math.pow(10,times);
            if(sum >= Integer.MAX_VALUE || sum <= Integer.MIN_VALUE){
                return 0;
            }
        }

        return sum;
    }
	
	public static void main(String[] args) {
		
		int holder = (-5) % 10;
		System.out.println(holder);
		
	}
}
