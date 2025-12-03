package BinaryTrees;

/*  108. Convert Sorted Array to Binary Search Tree
Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced
binary search tree.

Example 1:
Input: nums = [-10,-3,0,5,9]
Output: [0,-3,9,-10,null,5]
Explanation: [0,-10,5,null,-3,null,9] is also accepted:

Example 2:
Input: nums = [1,3]
Output: [3,1]
Explanation: [1,null,3] and [3,1] are both height-balanced BSTs.

Constraints:
1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums is sorted in a strictly increasing order
 */
public class ConvertSortedArrayToBinarySearchTree {
    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};
        TreeNode root = sortedArrayToBST(nums);
        TreeNode.printTree(root);
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        return balanceTree(nums, 0, nums.length - 1);
    }

    public static TreeNode balanceTree(int[] nums, int start, int end) {
        // base case
        if (start > end) return null;
        // finding mid
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        // checking for child
        root.left = balanceTree(nums, start, mid - 1);
        root.right = balanceTree(nums, mid + 1, end);
        return root;
    }
}
