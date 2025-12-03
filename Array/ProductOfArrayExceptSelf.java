package Array;

import java.util.Arrays;

/*  238. Product of Array Except Self
Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
You must write an algorithm that runs in O(n) time and without using the division operation.

Example 1:
Input: nums = [1,2,3,4]
Output: [24,12,8,6]

Example 2:
Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]

Constraints:
2 <= nums.length <= 105
-30 <= nums[i] <= 30
The input is generated such that answer[i] is guaranteed to fit in a 32-bit integer.    */
public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int[] nums = { -1, 1, 0, -3, 3 };
        int[] ans = productExceptSelf(nums);
        System.out.println(Arrays.toString(ans));
    }

    private static int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        int product = 1;
        for (int num : nums) {
            product *= num;
        }
        if (product != 0) {
            for (int i = 0; i < ans.length; i++) {
                ans[i] = product / nums[i];
            }
            return ans;
        } else {
            for (int index = 0; index < ans.length; index++) {
                product = 1;
                // left
                for (int i = 0; i < index; i++) {
                    product *= nums[i];
                }
                // right
                for (int i = index + 1; i < ans.length; i++) {
                    product *= nums[i];
                }
                ans[index] = product;
            }
        }
        return ans;
    }
}
