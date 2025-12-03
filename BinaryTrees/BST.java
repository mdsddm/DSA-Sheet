package BinaryTrees;

public class BST {
    public static TreeNode getBST(int[] nums) {
        TreeNode root = null;
        for (int num : nums) {
            root = insert(root, num);
        }
        return root;
    }

    public static TreeNode insert(TreeNode root, int num) {
        if (root == null) {
            root = new TreeNode(num);
            return root;
        }
        if (num < root.val) {
            root.left = insert(root.left, num);
        } else {
            root.right = insert(root.right, num);
        }
        return root;
    }

    public static boolean search(TreeNode root, TreeNode node) {
        if (root == null) return false;
        if (root.val == node.val) return true;
        return node.val < root.val ? search(root.left, node) : search(root.right, node);
    }

    public static void inorder(TreeNode root) {
        System.out.print("Inorder Traversal : [ ");
        inorderTraversal(root);
        System.out.println("]");
    }

    public static void inorderTraversal(TreeNode root) {
        if (root == null) return;
        inorderTraversal(root.left);
        System.out.print(root.val + " ");
        inorderTraversal(root.right);

    }

    public static TreeNode deleteNode(TreeNode root, int num) {
        if (root == null) return null;
        else if (root.val > num) root.left = deleteNode(root.left, num);
        else if (root.val < num) root.right = deleteNode(root.right, num);
        else {
            if (root.left == null && root.right == null) return null;
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;
            TreeNode suc = findInorderSuccessor(root.right);
            root.val = suc.val;
            root.right = deleteNode(root.right, suc.val);
        }
        return root;
    }

    public static TreeNode findInorderSuccessor(TreeNode root) {
        while (root.left != null) root = root.left;
        return root;
    }
}


