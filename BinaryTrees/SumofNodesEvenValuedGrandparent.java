package BinaryTrees;

/*  1315. Sum of Nodes with Even-Valued Grandparent
Given the root of a binary tree, return the sum of values of nodes with an even-valued grandparent. If there are no nodes
with an even-valued grandparent, return 0.
A grandparent of a node is the parent of its parent if it exists.

Example 1:
Input: root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
Output: 18
Explanation: The red nodes are the nodes with even-value grandparent while the blue nodes are the even-value grandparents.

Example 2:
Input: root = [1]
Output: 0

Constraints:
The number of nodes in the tree is in the range [1, 104].
1 <= Node.val <= 100
 */
public class SumofNodesEvenValuedGrandparent {
    static int sum;

    public static void main(String[] args) {
        TreeNode root = TreeNode.getTree(new int[]{6, 7, 8, 2, 7, 1, 3, 9, 0, 1, 4, 0, 0, 0, 5});
        System.out.println(sumEvenGrandparent(root));
    }


    public static int sumEvenGrandparent(TreeNode root) {
        sum = 0;
        childOfEven(root);
        return sum;
    }

    public static void childOfEven(TreeNode root) {
        if (root == null || root.left == null && root.right == null) return;
        if (root.val % 2 == 0) {
            if (root.left != null) {
                sum += root.left.left != null ? root.left.left.val : 0;
                sum += root.left.right != null ? root.left.right.val : 0;
            }
            if (root.right != null) {
                sum += root.right.left != null ? root.right.left.val : 0;
                sum += root.right.right != null ? root.right.right.val : 0;
            }
        }
        childOfEven(root.left);
        childOfEven(root.right);
    }

}
