package BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;

//  Definition for a binary tree node.
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
        left = null;
        right = null;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }


    public static TreeNode getManualTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(3);
        //root.right.right.left = new TreeNode(6);
        return root;
    }

    public static TreeNode getTree(int[] array) {
        if (array == null || array.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(array[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int index = 1;
        while (!queue.isEmpty() && index < array.length) {
            TreeNode current = queue.poll();

            if (index < array.length) {
                Integer leftVal = array[index++];
                if (leftVal != null) {
                    TreeNode leftNode = new TreeNode(leftVal);
                    current.left = leftNode;
                    queue.add(leftNode);
                }
            }

            if (index < array.length) {
                Integer rightVal = array[index++];
                if (rightVal != null) {
                    TreeNode rightNode = new TreeNode(rightVal);
                    current.right = rightNode;
                    queue.add(rightNode);
                }
            }
        }
        return root;
    }

    public static void printTree(TreeNode root) {
        if (root == null) {
            return;
        }
        printTree(root, 0);
    }

    public static void printTree(TreeNode node, int level) {
        if (node == null) {
            return;
        }
        printTree(node.right, level + 1);
        for (int i = 0; i < level; i++) {
            System.out.print("    ");
        }
        System.out.println(node.val);
        printTree(node.left, level + 1);
    }
}

