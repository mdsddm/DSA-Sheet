package BinaryTrees;

/*  513. Find Bottom Left Tree Value
Given the root of a binary tree, return the leftmost value in the last row of the tree.

Example 1:
Input: root = [2,1,3]
Output: 1

Example 2:
Input: root = [1,2,3,4,null,5,6,null,null,7]
Output: 7

Constraints:
The number of nodes in the tree is in the range [1, 104].
-231 <= Node.val <= 231 - 1
 */
public class FindBottomLeftTreeValue {
    static int ans, maxLevel = -1;

    public static void main(String[] args) {
        TreeNode root = TreeNode.getTree(new int[]{1, 2, 3, 4, 5, 6, 7});
        TreeNode.printTree(root);
        System.out.println(findBottomLeftValue(root));
    }

    public static int findBottomLeftValue(TreeNode root) {
        dfs(root, 0);
        return ans;
    }

    private static void dfs(TreeNode node, int level) {
        if (node == null) return;
        // If this is the first node encountered at this level, update answer
        if (level > maxLevel) {
            maxLevel = level;
            ans = node.val;
        }
        // Traverse left first to ensure leftmost
        dfs(node.left, level + 1);
        dfs(node.right, level + 1);
    }
}

