package Array;
/*  75. Sort Colors
Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color
are adjacent, with the colors in the order red, white, and blue. We will use the integers 0, 1, and 2 to represent
the color red, white, and blue, respectively. You must solve this problem without using the library's sort function.

Example 1:
Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]

Example 2:
Input: nums = [2,0,1]
Output: [0,1,2]

 */

import java.util.Arrays;

public class SortColor {
    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
    /*
    private static void sortColors(int[] nums) {
        int red = 0, white = 0;
        for (int color : nums) {
            if (color == 0)
                red++;
            if (color == 1)
                white++;
        }
        for (int i = 0; i < nums.length; i++) {
            if (red != 0) {
                nums[i] = 0;
                red--;
            } else if (white != 0) {
                nums[i] = 1;
                white--;
            } else
                nums[i] = 2;
        }
    } */

    private static void sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;
        while (mid <= high) {
            if (nums[mid] == 0) {  // if nums[mid] == 0 , swap (L,M) L++ m++
                int temp = nums[mid];
                nums[mid] = nums[low];
                nums[low] = temp;
                low++;
                mid++;
            } else if (nums[mid] == 2) { // if nums[mid] == 2 , swap (m,h) h--
                int temp = nums[high];
                nums[high] = nums[mid];
                nums[mid] = temp;
                high--;
            } else mid++;  // if nums[mid] == 1 , mid++;
        }
    }
}
