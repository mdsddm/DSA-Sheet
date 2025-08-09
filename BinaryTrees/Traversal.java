package BinaryTrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Traversal {
    public static void main(String[] args) {

    }

    /*  94. Binary Tree Inorder Traversal
    Given the root of a binary tree, return the inorder traversal of its nodes' values.

    Example 1:
    Input: root = [1,null,2,3]
    Output: [1,3,2]

    Example 2:
    Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]
    Output: [4,2,6,5,7,1,3,9,8]

    Example 3:
    Input: root = []
    Output: []

    Example 4:
    Input: root = [1]
    Output: [1]

    Constraints:
    The number of nodes in the tree is in the range [0, 100].
    -100 <= Node.val <= 100
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inTraversal(root, list);
        return list;
    }

    public static void inTraversal(TreeNode root, List<Integer> list) {
        if (root == null) return;
        inTraversal(root.left, list);
        list.add(root.val);
        inTraversal(root.right, list);
    }

    /*  144. Binary Tree Preorder Traversal
    Given the root of a binary tree, return the preorder traversal of its nodes' values.

    Example 1
    Input: root = [1,null,2,3]
    Output: [1,2,3]

    Example 2:
    Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]
    Output: [1,2,4,5,6,7,3,8,9]

    Example 3:
    Input: root = []
    Output: []

    Example 4:
    Input: root = [1]
    Output: [1]

    Constraints:
    The number of nodes in the tree is in the range [0, 100].
    -100 <= Node.val <= 100
         */
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preTraversal(root, list);
        return list;
    }

    public static void preTraversal(TreeNode root, List<Integer> list) {
        if (root == null) return;
        list.add(root.val);
        preTraversal(root.left, list);
        preTraversal(root.right, list);
    }
    /*  145. Binary Tree Postorder Traversal
    Given the root of a binary tree, return the postorder traversal of its nodes' values.

    Example 1:
    Input: root = [1,null,2,3]
    Output: [3,2,1]

    Example 2:
    Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]
    Output: [4,6,7,5,2,9,8,3,1]

    Example 3:
    Input: root = []
    Output: []

    Example 4:
    Input: root = [1]
    Output: [1]

    Constraints:
    The number of the nodes in the tree is in the range [0, 100].
    -100 <= Node.val <= 100
     */

    public static void postTraversal(TreeNode root, List<Integer> list) {
        if (root == null) return;
        postTraversal(root.left, list);
        postTraversal(root.right, list);
        list.add(root.val);
    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postTraversal(root, list);
        return list;
    }
    /*  102. Binary Tree Level Order Traversal
    Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).

    Example 1:
    Input: root = [3,9,20,null,null,15,7]
    Output: [[3],[9,20],[15,7]]

    Example 2:
    Input: root = [1]
    Output: [[1]]

    Example 3:
    Input: root = []
    Output: []

    Constraints:
    The number of nodes in the tree is in the range [0, 2000].
    -1000 <= Node.val <= 1000
     */

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        TreeNode temp = new TreeNode(-1);
        q.add(temp);
        while (!q.isEmpty()) {
            TreeNode cur = q.remove();
            if (cur == temp) {
                if (q.isEmpty()) {
                    ans.add(list);
                    break;
                } else {
                    q.add(temp);
                    ans.add(list);
                    list = new ArrayList<>();
                }
            } else if (cur != null) {
                list.add(cur.val);
                if (cur.left != null) q.add(cur.left);
                if (cur.right != null) q.add(cur.right);
            }

        }
        return ans;
    }
}
