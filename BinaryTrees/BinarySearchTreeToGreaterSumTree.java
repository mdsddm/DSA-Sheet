package BinaryTrees;

/*  1038. Binary Search Tree to Greater Sum Tree
Given the root of a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is
changed to the original key plus the sum of all keys greater than the original key in BST.
As a reminder, a binary search tree is a tree that satisfies these constraints:
The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.

Example 1:
Input: root = [4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
Output: [30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]

Example 2:
Input: root = [0,null,1]

Output: [1,null,1]

Constraints:
The number of nodes in the tree is in the range [1, 100].
0 <= Node.val <= 100
All the values in the tree are unique.
 */
public class BinarySearchTreeToGreaterSumTree {
    static int sum = 0;

    public static void main(String[] args) {
        TreeNode root = TreeNode.getTree(new int[]{1, 2, 3, 4, 5, 6, 7});
        System.out.println("before : ");
        TreeNode.printTree(root);
        System.out.println("after: ");
        bstToGst(root);
        TreeNode.printTree(root);

    }

    public static TreeNode bstToGst(TreeNode root) {
        if (root == null) return null;
        bstToGst(root.right);
        root.val += sum;
        sum = root.val;
        bstToGst(root.left);
        return root;
    }
}
