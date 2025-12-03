package BinaryTrees;

/*  101. Symmetric Tree
Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

Example 1:
Input: root = [1,2,2,3,4,4,3]
Output: true

Example 2:
Input: root = [1,2,2,null,3,null,3]
Output: false

Constraints:
The number of nodes in the tree is in the range [1, 1000].
-100 <= Node.val <= 100
 */
public class SymmetricTree {
    public static void main(String[] args) {
        TreeNode rootF = TreeNode.getTree(new int[]{1, 2, 2, 3, 4, 4, 3});
        TreeNode root = TreeNode.getManualTree();
        TreeNode.printTree(rootF);
        System.out.println(isSymmetric(rootF));
        TreeNode.printTree(root);
        System.out.println(isSymmetric(root));

    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return true;
        return checkBoth(root.left, root.right);
    }

    public static boolean checkBoth(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        else if (root1 == null || root2 == null || root1.val != root2.val)
            return false;
        else return checkBoth(root1.left, root2.right) && checkBoth(root1.right, root2.left);
    }
}
