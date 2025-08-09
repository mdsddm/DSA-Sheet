package BST;

import BinaryTrees.TreeNode;

/*  230. Kth Smallest Element in a BST
Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all
the values of the nodes in the tree.

Example 1:
Input: root = [3,1,4,null,2], k = 1
Output: 1

Example 2:
Input: root = [5,3,6,2,4,null,null,1], k = 3
Output: 3

Constraints:
The number of nodes in the tree is n.
1 <= k <= n <= 104
0 <= Node.val <= 104
 */
public class KthSmallestElement {
    static int ans = 0, count = 0;

    public static void main(String[] args) {
        TreeNode root = TreeNode.getTree(new int[]{5, 3, 7, 1, 4, 6, 8});
        BST.inorder(root);
        System.out.println(kthSmallest(root,7));
    }

    public static int kthSmallest(TreeNode root, int k) {
        findKthElement(root, k);
        return ans;
    }

    public static void findKthElement(TreeNode root, int k) {
        if (root == null) return;
        findKthElement(root.left, k);
        count++;
        if (count == k) ans = root.val;
        findKthElement(root.right, k);

    }
}
