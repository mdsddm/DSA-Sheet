package Array;

import java.util.Arrays;

/*  283. Move Zeroes
Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
Note that you must do this in-place without making a copy of the array.

Example 1:
Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]

Example 2:
Input: nums = [0]
Output: [0]

Constraints:
1 <= nums.length <= 104
-231 <= nums[i] <= 231 - 1  */
public class MoveZeroes {
    static void main() {
        int[] nums = { 1, 1, 2, 0, 3, 0, 4, 0, 3, 0, 0, 98 };
        moveZeroesTwo(nums);
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void moveZeroes(int[] nums) {
        int insert = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0)
                nums[insert++] = nums[i];

        }
        while (insert < nums.length)
            nums[insert++] = 0;

    }

    private static void moveZeroesTwo(int[] nums) {
        int i = 0, j = 1;
        while (i < nums.length && j < nums.length) {
            while (nums[i] != 0)
                i++;
            j = i + 1;
            while (nums[j] == 0)
                j++;
            // swap
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j++;
        }
    }
}
