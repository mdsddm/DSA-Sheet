package LinkedList;

// 1474- Delete N Node After M Node
public class DeleteNNodeAfterMNode {
    public static void main(String[] args) {
        ListNode list = LL.getList(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        LL.printList(deleteNNodeAfterMNode(list, 2, 3));
    }

    public static ListNode deleteNNodeAfterMNode(ListNode head, int m, int n) {
        if (head == null) return null;
        ListNode pre = head;
        ListNode cur = head;
        while (cur != null) {

            // adding m nodes
            for (int i = 0; i < m && cur != null; i++) {
                pre = cur;
                cur = cur.next;

            }
            // deleting n nodes
            for (int j = 0; j < n && cur != null; j++) {
                cur = cur.next;
            }
            // connect from last added node to after last deleted node
            pre.next = cur;
        }
        return head;
    }
}

