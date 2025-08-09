package Array;/*
Given an integer array nums, find the subarray with the largest sum, and return its sum.

Example 1:
Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.

Example 2:
Input: nums = [1]
Output: 1
Explanation: The subarray [1] has the largest sum 1.

Example 3:
Input: nums = [5,4,-1,7,8]
Output: 23
Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
 */

public class MaxSubArray {
    public static void main(String[] args) {
        int[] nums ={-1};
        System.out.println(maxSubArray(nums));

    }
    public static int maxSubArray(int[] nums) {
        boolean allNeg=true;
        int maxNeg=Integer.MIN_VALUE;
        for(int num : nums){
            if(num>maxNeg)
                maxNeg=num;
            if(num>0){
                allNeg=false;
                break;}
        }
        if(allNeg)
            return maxNeg;

        int maxSum=0;
        int curSum=0;
        for(int num : nums){
            curSum+=num;
            if(maxSum<curSum){
                maxSum=curSum;
            } else {
                curSum=Integer.max(curSum,0);
            }
        }
        return maxSum;
    }
}
