package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*  46. Permutations
Given an array nums of distinct integers, return all the possible permutations. You can return the
answer in any order.

Example 1:
Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

Example 2:
Input: nums = [0,1]
Output: [[0,1],[1,0]]

Example 3:
Input: nums = [1]
Output: [[1]]

Constraints:
1 <= nums.length <= 6
-10 <= nums[i] <= 10
All the integers of nums are unique.
 */
public class Permutations {
    public static void main(String[] args) {
        System.out.println(permute(new int[]{1, 2, 3}));
    }

    public static List<List<Integer>> permute(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        do {
            List<Integer> ans = new ArrayList<>();
            for (int num : nums)
                ans.add(num);
            list.add(ans);
        } while (getNextPer(nums));
        return list;
    }

    public static boolean getNextPer(int[] a) {
        // largest i s.t. a[i] > a[i+1]
        int i = a.length - 2;
        while (i >= 0 && a[i] > a[i + 1]) {
            i--;
        }

        // checking for false condition
        if (i == -1) {
            return false;
        }

        // largest j s.t. a[j] > a[i]
        int j = a.length - 1;
        while (a[j] < a[i]) j--;

        // after finding i & j exchange
        swap(a, i, j);

        // after exchanging reverse rest array -> i+1 to n-1
        reverseArray(a, i + 1);

        // return true
        return true;
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void reverseArray(int[] a, int st) {
        int end = a.length - 1;
        while (end > st) {
            swap(a, st, end);
            st++;
            end--;
        }
    }
}


