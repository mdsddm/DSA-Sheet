package BinarySearch;
/*1095. Find in Mountain Array
(This problem is an interactive problem.)
You may recall that an array arr is a mountain array if and only if:
arr.length >= 3
There exists some i with 0 < i < arr.length - 1 such that:
arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
Given a mountain array mountainArr, return the minimum index such that mountainArr.get(index) == target.
If such an index does not exist, return -1.
You cannot access the mountain array directly. You may only access the array using a MountainArray interface:
MountainArray.get(k) returns the element of the array at index k (0-indexed).
MountainArray.length() returns the length of the array.
Submissions making more than 100 calls to MountainArray.get will be judged Wrong Answer. Also, any solutions that
attempt to circumvent the judge will result in disqualification.

Example 1:
Input: mountainArr = [1,2,3,4,5,3,1], target = 3
Output: 2
Explanation: 3 exists in the array, at index=2 and index=5. Return the minimum index, which is 2.
Example 2:

Input: mountainArr = [0,1,2,4,2,1], target = 3
Output: -1
Explanation: 3 does not exist in the array, so we return -1.
 */
public class FindElementInMountainArray {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,3,1};
        System.out.println(findInMountainArray(3,arr));
    }
    public static int findInMountainArray(int target, int[] mountainArr) {
        // first we find peak index then index will divide into two part first is in the increasing order
        // second is in the decreasing order first we apply binary search in first then second
        // finding peak index
        int peakIndex=peakIndexInMountainArray(mountainArr);
        int ans=binarySearch(mountainArr,target,0,peakIndex,true);
        if(ans==-1)
            ans=binarySearch(mountainArr,target,peakIndex+1,mountainArr.length-1,false);
        return ans;

    }
    public static int peakIndexInMountainArray(int[] arr) {
        int low=0,high=arr.length-1;
        int mid;
        while (low<high){
            mid=low+(high-low)/2;
            if(arr[mid]>arr[mid+1])
                high=mid;
            else
                low=mid+1;  }
        return high;
    }
    public static int binarySearch(int[] nums,int target,int low,int high,boolean isIncreasing){
        int mid;
        while (low<=high){
            mid=low+(high-low)/2;
            if(nums[mid]==target)
                return mid;
            else if (target < nums[mid]) {
                if (isIncreasing)
                    high=mid-1;
                else
                    low=mid+1;  }
            else {
                if (isIncreasing)
                    low=mid+1;
                else
                    high=mid-1; }   }
        return -1;
    }
}
