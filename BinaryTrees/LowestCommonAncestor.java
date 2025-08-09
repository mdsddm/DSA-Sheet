package BinaryTrees;

/*  236. Lowest Common Ancestor of a Binary Tree
Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as
the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

Example 1:
Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
Output: 3
Explanation: The LCA of nodes 5 and 1 is 3.

Example 2:
Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
Output: 5
Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.

Example 3:
Input: root = [1,2], p = 1, q = 2
Output: 1

Constraints:
The number of nodes in the tree is in the range [2, 105].
-109 <= Node.val <= 109
All Node.val are unique.
p != q
p and q will exist in the tree.
 */
public class LowestCommonAncestor {
    public static void main(String[] args) {

    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // return root if root is null or any one of two
        if (root == null || root == p || root == q) return root;
        // find in left side
        TreeNode leftTree = lowestCommonAncestor(root.left, p, q);
        // find in right side
        TreeNode rightTree = lowestCommonAncestor(root.right, p, q);
        // if left side is null return right assuming TreeNode found in right side
        if (leftTree == null) return rightTree;
        // if right side is null return left assuming TreeNode found in left side
        if (rightTree == null) return leftTree;
        // if both is not null it means this is the common ancestor
        return root;
    }
}