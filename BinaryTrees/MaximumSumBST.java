package BinaryTrees;

/*  1373. Maximum Sum BST in Binary Tree

Given a binary tree root, return the maximum sum of all keys of any subtree which is also a Binary Search Tree (BST).
Assume a BST is defined as follows:
The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.

Example 1:
Input: root = [1,4,3,2,4,2,5,null,null,null,null,null,null,4,6]
Output: 20
Explanation: Maximum sum in a valid Binary search tree is obtained in root node with key equal to 3.

Example 2:
Input: root = [4,3,null,1,2]
Output: 2
Explanation: Maximum sum in a valid Binary search tree is obtained in a single root node with key equal to 2.

Example 3:
Input: root = [-4,-2,-5]
Output: 0
Explanation: All values are negatives. Return an empty BST.

Constraints:
The number of nodes in the tree is in the range [1, 4 * 104].
-4 * 104 <= Node.val <= 4 * 104
 */
public class MaximumSumBST {

    static int maxSum = 0;

    public static void main(String[] args) {
        TreeNode root = TreeNode.getTree(new int[]{4, 3, 0, 1, 2});
        System.out.println(maxSumBST(root));
    }

    public static int maxSumBST(TreeNode root) {
        getBST(root);
        return maxSum;
    }

    public static Info getBST(TreeNode root) {
        if (root == null)
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        Info leftInfo = getBST(root.left);
        Info rightInfo = getBST(root.right);
        int sum = leftInfo.sum + rightInfo.sum + root.val;
        int min = Math.min(root.val, Math.min(leftInfo.min, rightInfo.min));
        int max = Math.max(root.val, Math.max(leftInfo.max, rightInfo.max));
        if (leftInfo.max >= root.val || rightInfo.min <= root.val)
            return new Info(false, sum, min, max);
        if (leftInfo.isValid && rightInfo.isValid) {
            maxSum = Math.max(maxSum, sum);
            return new Info(true, sum, min, max);
        }
        return new Info(false, sum, min, max);


    }
}

class Info {
    boolean isValid;
    int sum;
    int min;
    int max;

    public Info(boolean isValid, int sum, int min, int max) {
        this.isValid = isValid;
        this.sum = sum;
        this.min = min;
        this.max = max;
    }
}
