package BinaryTrees;

/*  543. Diameter of Binary Tree
Given the root of a binary tree, return the length of the diameter of the tree.
The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
This path may or may not pass through the root.
The length of a path between two nodes is represented by the number of edges between them.

Example 1:
Input: root = [1,2,3,4,5]
Output: 3
Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].

Example 2:
Input: root = [1,2]
Output: 1

Constraints:
The number of nodes in the tree is in the range [1, 104].
-100 <= Node.val <= 100
 */
public class DiameterOfTree {
    public static void main(String[] args) {
        TreeNode root = TreeNode.getManualTree();
        TreeNode.printTree(root);
        System.out.println("Diameter : " + diameterOfBinaryTree(root));
    }

    public static int diameterOfBinaryTree(TreeNode root) {
        return getDiameter(root).dia;
    }

    public static Info getDiameter(TreeNode root) {
        if (root == null) return new Info(0, 0);
        Info leftInfo = getDiameter(root.left);
        Info rightInfo = getDiameter(root.right);
        int newDia = Math.max(Math.max(leftInfo.dia, rightInfo.dia), leftInfo.height + rightInfo.height);
        int newHeight = Math.max(leftInfo.height, rightInfo.height) + 1;
        return new Info(newDia, newHeight);
    }

    public static class Info {
        public int dia;
        public int height;

        public Info(int dia, int height) {
            this.dia = dia;
            this.height = height;
        }
    }


}
