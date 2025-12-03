package BinaryTrees;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*  199. Binary Tree Right Side View
Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes
you can see ordered from top to bottom.

Example 1:
Input: root = [1,2,3,null,5,null,4]
Output: [1,3,4]

Example 2:
Input: root = [1,2,3,4,null,null,null,5]
Output: [1,3,4,5]

Example 3:
Input: root = [1,null,3]
Output: [1,3]

Example 4:
Input: root = []
Output: []

Constraints:
The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100
 */
public class RightViewBinaryTree {
    public static void main(String[] args) {
        TreeNode root = TreeNode.getManualTree();
        TreeNode.printTree(root);
        System.out.println(rightSideView(root));
    }

    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode temp = new TreeNode(); // this handle ending of each level
        q.add(root);
        q.add(temp);
        while (!q.isEmpty()) {
            TreeNode curNode = q.poll();
            if (curNode != null && temp == q.peek())
                result.add(curNode.val);    //adding last element before the next level
            if (curNode == temp) {
                if (q.isEmpty()) break;
                q.add(temp);
            } else if (curNode != null) {
                if (curNode.left != null) q.add(curNode.left);
                if (curNode.right != null) q.add(curNode.right);
            }
        }
        return result;
    }
}
