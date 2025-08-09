package Array;/*
You are given an m x n integer matrix with the following two properties:
Each row is sorted in non-decreasing order.
The first integer of each row is greater than the last integer of the previous row.
Given an integer target, return true if target is in matrix or false otherwise.
You must write a solution in O(log(m * n)) time complexity.

Example 1:
Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true

Example 2:
Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
Output: false
 */


public class SearchIn2DArray {
    public static void main(String[] args) {
        int[][] matrix = {{1}, {3}};
        System.out.println(searchMatrix(matrix, 2));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int mHigh = matrix.length - 1;
        int nHigh = matrix[0].length - 1;
        int mid, low = 0;
        // checking whether target lie in any sub array
        while (low <= mHigh) {

            mid = (low + mHigh) / 2;
            // checking target lie in sub matrix
            if (matrix[mid][0] <= target && target <= matrix[mid][nHigh])
                return binarySearch(matrix[mid], target);
            else if (target <= matrix[mid][0])
                mHigh = mid - 1;
            else
                low = mid + 1;
        }
        return false;
    }

    public static boolean binarySearch(int[] nums, int target) {
        int high = nums.length - 1;
        int mid, low = 0;
        while (low <= high) {
            mid = (low + high) / 2;
            if (nums[mid] == target)
                return true;
            else if (target < nums[mid])
                high = mid - 1;
            else
                low = mid + 1;
        }
        return false;

    }
}
