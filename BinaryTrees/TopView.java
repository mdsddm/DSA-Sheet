package BinaryTrees;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class TopView {
    public static void main(String[] args) {
        TreeNode root = TreeNode.getManualTree();
        TreeNode.printTree(root);
        TopViewBinaryTree(root);
    }

    public static void TopViewBinaryTree(TreeNode root) {
        int min = 0, max = 0;
        Queue<TopInfo> q = new LinkedList<>();
        HashMap<Integer, TreeNode> hm = new HashMap<>();
        q.add(new TopInfo(0, root));
        q.add(null);
        while (!q.isEmpty()) {
            TopInfo cur = q.poll();
            if (cur == null) {
                if (q.isEmpty()) break;
                else q.add(null);
            } else {
                if (!hm.containsKey(cur.hd)) {
                    hm.put(cur.hd, cur.node);
                }
                if (cur.node.left != null) {
                    q.add(new TopInfo(cur.hd - 1, cur.node.left));
                    min = Math.min(min, cur.hd - 1);
                }
                if (cur.node.right != null) {
                    q.add(new TopInfo(cur.hd + 1, cur.node.right));
                    max = Math.max(max, cur.hd + 1);
                }
            }
        }
        for (int i = min; i <= max; i++) {
            TreeNode curNode = hm.get(i);
            System.out.print(curNode.val);
        }
    }


}

class TopInfo {
    public TreeNode node;
    public int hd;

    public TopInfo(int hd, TreeNode node) {
        this.hd = hd;
        this.node = node;
    }
}