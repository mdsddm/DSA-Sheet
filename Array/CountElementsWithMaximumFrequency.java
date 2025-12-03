package Array;

import java.util.HashMap;

/*3005. Count Elements With Maximum Frequency
You are given an array nums consisting of positive integers.
Return the total frequencies of elements in nums such that those elements all have the maximum frequency.
The frequency of an element is the number of occurrences of that element in the array.

Example 1:
Input: nums = [1,2,2,3,1,4]
Output: 4
Explanation: The elements 1 and 2 have a frequency of 2 which is the maximum frequency in the array.
So the number of elements in the array with maximum frequency is 4.

Example 2:
Input: nums = [1,2,3,4,5]
Output: 5
Explanation: All elements of the array have a frequency of 1 which is the maximum.
So the number of elements in the array with maximum frequency is 5.

Constraints:
1 <= nums.length <= 100
1 <= nums[i] <= 100 */
public class CountElementsWithMaximumFrequency {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5 };
        System.out.println(maxFrequencyElements(nums));
    }

    private static int maxFrequencyElements(int[] nums) {
        int maxLength = Integer.MIN_VALUE;
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) > maxLength) {
                maxLength = map.get(num);
            }
        }
        for (int key : map.keySet()) {
            if (map.get(key) == maxLength) {
                ans += maxLength;
            }
        }
        return ans;

    }
}
