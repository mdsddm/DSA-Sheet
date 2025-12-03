package LinkedList;

/*  24. Swap Nodes in Pairs
Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without
modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)

Example 1:
Input: head = [1,2,3,4]
Output: [2,1,4,3]

Example 2:
Input: head = []
Output: []

Example 3:
Input: head = [1]
Output: [1]

Example 4:
Input: head = [1,2,3]
Output: [2,1,3]

Constraints:

The number of nodes in the list is in the range [0, 100].
0 <= Node.val <= 100
 */
public class SwapNodesInPair {
    public static void main(String[] args) {
        LL.printList(swapPairs(LL.getList(new int[]{1, 2, 3, 4, 5, 6})));
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        if (head.next.next == null) {
            ListNode cur = head.next;
            head.next = null;
            cur.next = head;
            return cur;
        }
        ListNode pre = head;
        ListNode cur = pre.next;
        head = head.next;
        ListNode nextNode = cur.next;
        while (true) {
            cur.next = pre;
            pre.next = nextNode;
            if (nextNode == null || nextNode.next == null)
                break;
            pre.next = nextNode.next;
            pre = nextNode;
            cur = pre.next;
            nextNode = cur.next;
        }
        return head;
    }
}
