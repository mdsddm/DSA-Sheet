package BinaryTrees;
/*  783. Minimum Distance Between BST Nodes
Given the root of a Binary Search Tree (BST), return the minimum difference between the values of any two
different nodes in the tree.

Example 1:
Input: root = [4,2,6,1,3]
Output: 1

Example 2:
Input: root = [1,0,48,null,null,12,49]
Output: 1

Constraints:
The number of nodes in the tree is in the range [2, 100].
0 <= Node.val <= 105
 */
public class MinimumDistanceBetweenBSTNodes {
    static Integer res = Integer.MAX_VALUE, pre = null;

    public static void main(String[] args) {

    }

    public static int minDiffInBST(TreeNode root) {
        if (root.left != null) minDiffInBST(root.left);
        if (pre != null) res = Math.min(res, root.val - pre);
        pre = root.val;
        if (root.right != null) minDiffInBST(root.right);
        return res;
    }
}

