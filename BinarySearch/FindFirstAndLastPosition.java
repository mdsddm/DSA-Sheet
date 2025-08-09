package BinarySearch;
/* Problem 34
Given an array of integers nums sorted in non-decreasing order, find the starting and ending position
of a given target value.
If target is not found in the array, return [-1, -1].
You must write an algorithm with O(log n) runtime complexity.

Example 1:
Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]

Example 2:
Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]

Example 3:
Input: nums = [], target = 0
Output: [-1,-1]

 */
public class FindFirstAndLastPosition {
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        for(int i : searchRange(nums,8))
            System.out.print(i);
    }
    public static int[] searchRange(int[] nums, int target) {
        int[] ans={-1,-1};
        ans[0]=searchPosition(nums,target,true);
        if(ans[0]!=-1)
            ans[1]=searchPosition(nums,target,false);
        return ans;
    }
    public static int searchPosition(int[] nums,int target,boolean isFirst){
        // initializing variables
        int ans=-1,low=0,high=nums.length-1,mid;
        // condition
        while(low<=high){
            mid=low+(high-low)/2;
            // target is bigger than in mid then go for right
            if (target>nums[mid]){  low=mid+1;  }
            // target is small then go for left
            else if (target<nums[mid]) {    high=mid-1; }
            // if  target found
            else {
                // potential answer
                ans=mid;
                // further checking
                if (isFirst)
                    high=mid-1;
                else
                    low=mid+1;  }   }
        return ans;
    }
}
