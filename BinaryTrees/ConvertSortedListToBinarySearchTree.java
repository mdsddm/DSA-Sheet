package BinaryTrees;

import LinkedList.LL;
import LinkedList.ListNode;

import java.util.ArrayList;

/*  109. Convert Sorted List to Binary Search Tree
Given the head of a singly linked list where elements are sorted in ascending order, convert it to a height-balanced
binary search tree.

Example 1:
Input: head = [-10,-3,0,5,9]
Output: [0,-3,9,-10,null,5]
Explanation: One possible answer is [0,-3,9,-10,null,5], which represents the shown height balanced BST.

Example 2:
Input: head = []
Output: []

Constraints:
The number of nodes in head is in the range [0, 2 * 104].
-105 <= Node.val <= 105
 */
public class ConvertSortedListToBinarySearchTree {
    public static void main(String[] args) {
        ListNode node = LL.getList(new int[]{-10, -3, 0, 5, 9});
        TreeNode root = sortedListToBST(node);
        TreeNode.printTree(root);
    }

    public static TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        ArrayList<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        return balanceTree(list, 0, list.size() - 1);
    }

    public static TreeNode balanceTree(ArrayList<Integer> nums, int start, int end) {
        // base case
        if (start > end) return null;
        // finding mid
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(nums.get(mid));
        // checking for child
        root.left = balanceTree(nums, start, mid - 1);
        root.right = balanceTree(nums, mid + 1, end);
        return root;
    }
}
