package LinkedList;

/*  143. Reorder List

You are given the head of a singly linked-list. The list can be represented as:
L0 → L1 → … → Ln - 1 → Ln
Reorder the list to be on the following form:
L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
You may not modify the values in the list's nodes. Only nodes themselves may be changed.

Example 1:
Input: head = [1,2,3,4]
Output: [1,4,2,3]

Example 2:
Input: head = [1,2,3,4,5]
Output: [1,5,2,4,3]

Constraints:
The number of nodes in the list is in the range [1, 5 * 104].
1 <= Node.val <= 1000
 */
public class ZigZagList {
    public static void main(String[] args) {
        ListNode list = LL.getList(new int[]{1, 2, 3, 4, 5, 6});
        reorderList(list);
        LL.printList(list);
    }

    public static void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return;
        // getting mid
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // reversing right half list
        ListNode prev = null;
        ListNode cur = slow.next;
        slow.next = null;
        ListNode next;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        // merging alter
        ListNode left = head;
        ListNode right = prev;
        ListNode nextL, nextR;
        while (left != null && right != null) {
            nextL = left.next;
            left.next = right;
            nextR = right.next;
            right.next = nextL;

            left = nextL;
            right = nextR;
        }

    }


}
