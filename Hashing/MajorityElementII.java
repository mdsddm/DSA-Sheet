package Hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*  229. Majority Element II
Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

Example 1:
Input: nums = [3,2,3]
Output: [3]

Example 2:
Input: nums = [1]
Output: [1]

Example 3:
Input: nums = [1,2]
Output: [1,2]

Constraints:
1 <= nums.length <= 5 * 104
-109 <= nums[i] <= 109

 */
public class MajorityElementII {
    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(majorityElement(nums));
    }

    public static List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        // putting number and their frequencies
        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);

        // resultant list
        ArrayList<Integer> resList = new ArrayList<>();

        // iteration through key set
        for (int key : map.keySet())
            if (map.get(key) > nums.length / 3) resList.add(key);
        // only to avoid missing return statement error
        return resList;
    }
}
