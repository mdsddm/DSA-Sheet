package BST;

import BinaryTrees.TreeNode;

/*  938. Range Sum of BST
Given the root node of a binary search tree and two integers low and high, return the sum of values of
all nodes with a value in the inclusive range [low, high].

Example 1:
Input: root = [10,5,15,3,7,null,18], low = 7, high = 15
Output: 32
Explanation: Nodes 7, 10, and 15 are in the range [7, 15]. 7 + 10 + 15 = 32.

Example 2:
Input: root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
Output: 23
Explanation: Nodes 6, 7, and 10 are in the range [6, 10]. 6 + 7 + 10 = 23.
 */
public class RangeSumOfBST {
    public static void main(String[] args) {
        TreeNode root = BST.getBST(new int[]{10, 5, 15, 3, 7, 0, 18});
        TreeNode.printTree(root);
        System.out.println(rangeSumBST(root, 7, 15));

    }

    public static int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) // base case
            return 0;
        if (low > root.val)   // if root value is smaller than low then search for right
            return rangeSumBST(root.right, low, high);
        else if (high < root.val) // if root value is bigger than high then search for left
            return rangeSumBST(root.left, low, high);
        else    //  if root value lie between low and high then search for left and right both
            return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
    }
}

