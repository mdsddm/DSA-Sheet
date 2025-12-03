package Hashing;

import java.util.HashMap;

/*  169. Majority Element
Given an array num of size n, return the majority element.
The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always
exists in the array.

Example 1:
Input: num = [3,2,3]
Output: 3

Example 2:
Input: num = [2,2,1,1,1,2,2]
Output: 2

Constraints:
n == num.length
1 <= n <= 5 * 104
-109 <= num[i] <= 109

 */
public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(nums));
    }

    public static int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        // putting number and their frequencies
        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);

        // iteration through key set
        for (int key : map.keySet())
            if (map.get(key) > nums.length / 2) return key;
        // only to avoid missing return statement error
        return 0;
    }
}
