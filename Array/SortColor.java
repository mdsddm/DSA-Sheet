package Array;/*
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

public class SortColor {
    public static void main(String[] args) {
        int[] nums = {2,0,1};
        sortColors(nums);
        for (int color : nums)
            System.out.print(color+" ");
    }
    public static void sortColors(int[] nums) {
        int red=0,white=0;
        for(int color:nums ){
            if (color==0)
                red++;
            if (color==1)
                white++;
        }
        for(int i=0;i<nums.length;i++){
            if(red!=0)
                {   nums[i]=0; red--;   }
            else if (white!=0)
                {   nums[i]=1; white--; }
            else
                 nums[i]=2;
        }
    }
}
