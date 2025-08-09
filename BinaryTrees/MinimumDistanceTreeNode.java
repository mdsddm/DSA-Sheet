package BinaryTrees;

public class MinimumDistanceTreeNode {
    public static void main(String[] args) {
        TreeNode root = TreeNode.getTree(new int[]{1, 2, 3, 4, 5, 6, 7});
        TreeNode.printTree(root);
        System.out.println("Distance : " + getMinDistance(root, 4, 6));

    }

    public static int getMinDistance(TreeNode root, int n1, int n2) {
        TreeNode lca = lowestCommonAncestor(root, n1, n2);
//        int firstDistance = getNodeDistance(lca, n1);
//        int secondDistance = getNodeDistance(lca, n2);
//        return firstDistance + secondDistance;
        return getNodeDistance(lca, n1, n2);
    }

    public static int getNodeDistance(TreeNode root, int p) {
        if (root == null) return -1;
        if (root.val == p) return 0;
        int leftDistance = getNodeDistance(root.left, p);
        int rightDistance = getNodeDistance(root.right, p);
        if (leftDistance == -1 && rightDistance == -1) return -1;
        return leftDistance == -1 ? rightDistance + 1 : leftDistance + 1;
    }

    // An Alternative && optimize as well
    public static int getNodeDistance(TreeNode root, int p, int q) {
        if (root == null) return -1;
        if (root.val == p || root.val == q) return 0;
        int ld = getNodeDistance(root.left, p, q);
        int rd = getNodeDistance(root.right, p, q);
        if (ld == -1 && rd == -1) return -1;
        else if (ld != -1 && rd != -1) return ld + rd + 2;
        else if (ld == -1) return rd + 1;
        else return ld + 1;
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, int p, int q) {
        // return root if root is null or any one of two
        if (root == null || root.val == p || root.val == q) return root;
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
