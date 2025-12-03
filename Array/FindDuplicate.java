package Array;
/*
Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
There is only one repeated number in nums, return this repeated number.
You must solve the problem without modifying the array nums and using only constant extra space.

Example 1:
Input: nums = [1,3,4,2,2]
Output: 2

Example 2:
Input: nums = [3,1,3,4,2]
Output: 3

Example 3:
Input: nums = [3,3,3,3,3]
Output: 3
 */

public class FindDuplicate {
    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 2, 2};
        System.out.println(findDuplicate(nums));

    }

    public static int findDuplicate(int[] nums) {
        // finding the maximum element
        int maxNum = Integer.MIN_VALUE;
        for (int num : nums)
            maxNum = Integer.max(maxNum, num);

        // creating array of maxsize
        int[] newNums = new int[maxNum + 1];

        // mapping value
        for (int num : nums)
            newNums[num]++;
        // checking
        for (int i = 0; i <= maxNum; i++)
            if (newNums[i] > 1)
                return i;
        return -1;
    }
}
