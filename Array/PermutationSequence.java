package Array;

/*  60. Permutation Sequence
The set [1, 2, 3, ..., n] contains a total of n! unique permutations.
By listing and labeling all the permutations in order, we get the following sequence for n = 3:
"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Example 1:

Input: n = 3, k = 3
Output: "213"

Example 2:
Input: n = 4, k = 9
Output: "2314"

Example 3:
Input: n = 3, k = 1
Output: "123"

Constraints:
1 <= n <= 9
1 <= k <= n!
 */
public class PermutationSequence {
    public static void main(String[] args) {
        System.out.println(getPermutation(3, 3));
    }

    public static String getPermutation(int n, int k) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++)
            nums[i] = i + 1;
        for (int i = 1; i < k; i++)
            getNextPer(nums);
        StringBuilder sb = new StringBuilder();
        for (int num : nums)
            sb.append(num);
        return sb.toString();
    }


    public static void getNextPer(int[] a) {
        // largest i s.t. a[i] > a[i+1]
        int i = a.length - 2;
        while (i >= 0 && a[i] > a[i + 1]) {
            i--;
        }

        // checking for false condition
        if (i == -1) {
            return;
        }

        // largest j s.t. a[j] > a[i]
        int j = a.length - 1;
        while (a[j] < a[i]) j--;

        // after finding i & j exchange
        swap(a, i, j);

        // after exchanging reverse rest array -> i+1 to n-1
        reverseArray(a, i + 1);

    }

    public static void reverseArray(int[] a, int st) {
        int end = a.length - 1;
        while (end > st) {
            swap(a, st, end);
            st++;
            end--;
        }
    }

    // method to swap
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
