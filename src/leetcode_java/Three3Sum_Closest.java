package leetcode_java;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * Given an array nums of n integers and an integer target, 
 * find three integers in nums such that the sum is closest to target. 
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.

Example:

Given array nums = [-1, 2, 1, -4], and target = 1.

The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class Three3Sum_Closest {
	public int threeSumClosest(int[] nums, int target) {
		if (null == nums)
			throw new NullPointerException();
		if (nums.length < 3)
			return 0;
		int sum = 0, diff = Integer.MAX_VALUE;
		Arrays.sort(nums);
		// used to store the three numbers
		// ArrayList<Integer> numlist = new ArrayList<Integer>();
		// used to store the index of three numbers
		// ArrayList<Integer> indexlist = new ArrayList<Integer>();

		int left = 0, mid = 0, right = 0;
		for (; left < nums.length - 2; left++) {
			if (left > 0 && nums[left] == nums[left - 1])
				continue;
			mid = left + 1;
			right = nums.length - 1;
			int temp = target - nums[left];
			boolean isEqualFound = false;
			while (mid < right) {
				int tempsum = nums[left] + nums[mid] + nums[right];
				int tempdiff = target - tempsum;
				if (Math.abs(tempdiff) < Math.abs(diff)) {
					sum = tempsum;
					diff = tempdiff;
				}
				// if tempdiff = 0, which mean the best solution has been found, break;
				if (tempdiff == 0) {
					isEqualFound = true;
					break;
				}

				if (tempdiff > 0) {
					while(mid < right && nums[mid] == nums[mid+1]) mid++;
					mid++;
				} else {
					while(mid < right && nums[right] == nums[right-1]) right--;
					right--;
				}

			}
			if (isEqualFound)
				break;
		}
		return sum;
	}
	
	public int threeSumClosestMethod2(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        int min = nums[0] + nums[1] + nums[2];
        int max = nums[n - 3] + nums[n - 2] + nums[n - 1];
        if (min >= target) return min;
        if (max <= target) return max;
        for (int i = 0; i < n - 2; i++){
            int curMin = nums[i] + nums[i + 1] + nums[i + 2];
            int curMax = nums[i] + nums[n - 2] + nums[n - 1];
            if (curMin > target) {
                max= Math.min(max, curMin);
                break;
            }
            if (curMax < target){
                min = Math.max(min, curMax);
                continue;
            }
            int j = i + 1, k = n - 1;
            while (j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target) return target;
                if (sum > target) {
                    max = Math.min(max, sum);
                    while (--k > j && nums[k] == nums[k+1]);
                } else{
                    min = Math.max(min, sum);
                    while (++j < k && nums[j] == nums[j-1]);
                }
            }
        }
        return max - target > target - min ? min : max;
    }
}
