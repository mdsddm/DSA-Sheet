package Array;
/*  3423. Maximum Difference Between Adjacent Elements in a Circular Array
Given a circular array nums, find the maximum absolute difference between adjacent elements.
Note: In a circular array, the first and last elements are adjacent.

Example 1:
Input: nums = [1,2,4]
Output: 3
Explanation:
Because nums is circular, nums[0] and nums[2] are adjacent. They have the maximum absolute difference of |4 - 1| = 3.

Example 2:
Input: nums = [-5,-10,-5]
Output: 5
Explanation:
The adjacent elements nums[0] and nums[1] have the maximum absolute difference of |-5 - (-10)| = 5.
 */
public class MaximumDifferenceBetweenAdjacentElementsInACircularArray {
    public static void main(String[] args) {
        int[] nums ={2,1,0};
        System.out.println(maxAdjacentDistance(nums));
        System.out.println(maxAdjacentDistanceII(nums));
    }
    public static int maxAdjacentDistance(int[] nums) {
        int n = nums.length;
        int maxDif=Math.abs(nums[0]-nums[n-1]);
        for (int i=0; i<n-1; i++) {
            maxDif=Math.max(maxDif,Math.abs(nums[i]-nums[i+1]));
        }
        return maxDif;
    }
    // same problem but in optimize
    public static int maxAdjacentDistanceII(int[] nums) {
        if (nums.length==2)
            return Integer.max(nums[0]-nums[1],nums[1]-nums[0]);
        int maxDif = Integer.MIN_VALUE;
        int n = nums.length-1;
        for(int i=1;i<n;i++){
            maxDif = Integer.max(maxDif,nums[i]-nums[i+1]);
            maxDif = Integer.max(maxDif,nums[i]-nums[i-1]);
            }
        maxDif=Integer.max(maxDif,nums[0]-nums[n]);
        maxDif=Integer.max(maxDif,nums[n]-nums[0]);
        maxDif=Integer.max(maxDif,nums[0]-nums[1]);
        maxDif=Integer.max(maxDif,nums[n]-nums[n-1]);
        return  maxDif;
    }

}
