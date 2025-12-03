package BinaryTrees;

/*  110. Balanced Binary Tree
Given a binary tree, determine if it is height-balanced.

Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: true

Example 2:
Input: root = [1,2,2,3,3,null,null,4,4]
Output: false

Example 3:
Input: root = []
Output: true

Constraints:
The number of nodes in the tree is in the range [0, 5000].
-104 <= Node.val <= 104
 */
public class BalanceBinaryTree {
    static boolean condition = true;

    public static void main(String[] args) {
        TreeNode root = TreeNode.getManualTree();
        TreeNode.printTree(root);
        System.out.println(isBalanced(root));
    }

    public static boolean isBalanced(TreeNode root) {
        heightCal(root);
        return condition;
    }

    public static int heightCal(TreeNode root) {
        if (!condition) return 0;
        if (root == null) return 0;
        int lh = heightCal(root.left);
        int rh = heightCal(root.right);
        if (lh > rh + 1 || rh > lh + 1) condition = false;
        return Math.max(lh, rh) + 1;
    }
}
