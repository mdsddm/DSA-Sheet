package BinaryTrees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*  652. Find Duplicate Subtrees
Given the root of a binary tree, return all duplicate subtrees.
For each kind of duplicate subtrees, you only need to return the root node of any one of them.
Two trees are duplicate if they have the same structure with the same node values.

Example 1:
Input: root = [1,2,3,4,null,2,4,null,null,4]
Output: [[2,4],[4]]

Example 2:
Input: root = [2,1,1]
Output: [[1]]

Example 3:
Input: root = [2,2,2,3,null,3,null]
Output: [[2,3],[3]]

Constraints:
The number of the nodes in the tree will be in the range [1, 5000]
-200 <= Node.val <= 200
 */
public class FindDuplicateSubtree {


    public static void main(String[] args) {
        TreeNode root = TreeNode.getTree(new int[]{1, 2, 3, 4, 0, 2, 4, 0, 0, 4});
        for (TreeNode node : findDuplicateSubtrees(root))
            TreeNode.printTree(node);
    }

    public static List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> ans = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        getSubtree(root, ans, map);
        return ans;
    }

    public static String getSubtree(TreeNode root, List<TreeNode> ans, HashMap<String, Integer> map) {
        if (root == null) {
            return "@";
        }
        String leftPart = getSubtree(root.left, ans, map);
        String rightPart = getSubtree(root.right, ans, map);
        String curNode = root.val + "|" + leftPart + "|" + rightPart;
        if (map.containsKey(curNode)) {
            if (map.get(curNode) == 1) ans.add(root);
            map.put(curNode, map.get(curNode) + 1);
        } else map.put(curNode, 1);
        return curNode;

    }
}
