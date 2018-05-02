package leetcode_java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/*
 * Given an array nums of n integers, 
 * are there elements a, b, c in nums such that a + b + c = 0? 
 * Find all unique triplets in the array which gives the sum of zero.
 * 
 * Note:
 * The solution set must not contain duplicate triplets.  // Is different order regarded as duplicate?
 * 
 * Example:
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
 */
public class Three3Sum_15 {
	//  Time Limit Exceeded
	public static List<List<Integer>> threeSumMethod2 (int[] nums) {
		ArrayList<List<Integer>> listoflist = new ArrayList<List<Integer>>();
		if(null == nums) throw new NullPointerException();
		if(nums.length < 3) return listoflist;
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
		
		for(int i = 0 ; i < nums.length; i++) {
			if(map.containsKey(nums[i])) {
				map.get(nums[i]).add(i);
			} else {
				ArrayList<Integer> list = new ArrayList<Integer>();
				list.add(i);
				map.put(nums[i], list);
			}
		}
		for(int i = 0; i < nums.length; i++) {
			for(int j = i + 1; j < nums.length - 1; j++) {
				if( map.containsKey( -(nums[i] + nums[j]) ) ) {
					ArrayList<Integer> indexlist = map.get( -(nums[i] + nums[j]) );
					for(int k = 0; k < indexlist.size(); k++) {
						if(indexlist.get(k) <= j) continue;
						ArrayList<Integer> list = new ArrayList<Integer>();
						list.add(nums[i]);
						list.add(nums[j]);
						list.add(nums[indexlist.get(k)]);
						listoflist.add(list);
						break;
					}
				}
			}
		}
		for(int i = 0; i < listoflist.size(); i++ ) {
			ArrayList<Integer> listleft = (ArrayList<Integer>) listoflist.get(i);
			Collections.sort(listleft);
			for(int j = i + 1; j< listoflist.size(); j++) {
				ArrayList<Integer> listright = (ArrayList<Integer>) listoflist.get(j);
				Collections.sort(listright);
				if( listleft.get(0) == listright.get(0) && listleft.get(1) == listright.get(1) 
						&& listleft.get(2) == listright.get(2) ) {
					listoflist.remove(j);
					j--;
				}
			}
		}
		return listoflist;
	}
	
    public List<List<Integer>> threeSum (int[] num) {
        ArrayList<List<Integer>> lists = new ArrayList<List<Integer>>();
        if(num.length < 3){
            return lists;
        }
        
        Arrays.sort(num);
        
        int left = 0, right = 0, temp = 0;
        for(int i = 0; i < num.length - 2; i++){
            if(num[i] > 0){
                break;
            }
            if(i > 0 && num[i-1] == num[i]){
                continue;
            }
            temp = - num[i];
            left = i + 1;
            right = num.length - 1;
            while(left < right){
                if(num[left] + num[right] == temp){
                    ArrayList<Integer> list = new ArrayList<Integer>();
                    list.add(num[i]);
                    list.add(num[left]);
                    list.add(num[right]);
                    lists.add(list);
                    left++;
                    right--;
                    while(num[left] == num[left-1] && left < right) left++;
                    while(num[right] == num[right + 1] && left < right) right--;
                    
                }else if (num[left] + num[right] > temp){
                    right--;
                } else {
                    left++;
                }
            }
        }
        return lists;
    }	
	
}
