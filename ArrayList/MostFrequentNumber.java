package ArrayList;

import java.util.HashMap;
import java.util.Map;

/*  2190. Most Frequent Number Following Key In an Array
You are given a 0-indexed integer array nums. You are also given an integer key, which is present in nums.
For every unique integer target in nums, count the number of times target immediately follows an occurrence
of key in nums. In other words, count the number of indices i such that:
0 <= i <= nums.length - 2,
nums[i] == key and,
nums[i + 1] == target.
Return the target with the maximum count. The test cases will be generated such that the target with maximum count is unique.

Example 1:
Input: nums = [1,100,200,1,100], key = 1
Output: 100
Explanation: For target = 100, there are 2 occurrences at indices 1 and 4 which follow an occurrence of key.
No other integers follow an occurrence of key, so we return 100.

Example 2
Input: nums = [2,2,2,2,3], key = 2
Output: 2
Explanation: For target = 2, there are 3 occurrences at indices 1, 2, and 3 which follow an occurrence of key.
For target = 3, there is only one occurrence at index 4 which follows an occurrence of key.
target = 2 has the maximum number of occurrences following an occurrence of key, so we return 2.
 */
public class MostFrequentNumber {
    public static void main(String[] args) {
        int[] nums ={1,100,200,1,100,1,43,1,43,1,43};
        System.out.println(mostFrequent(nums,1));
    }
    public static int mostFrequent(int[] nums, int key) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length-1;i++){
           if(nums[i]==key)
               map.put(nums[i+1],map.getOrDefault(nums[i+1],0)+1);
        }
        int freq = Integer.MIN_VALUE;
        int ans=0;

        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue()>freq){
                freq=entry.getValue();
                ans=entry.getKey();
            }

        }
        return ans;


    }
}
