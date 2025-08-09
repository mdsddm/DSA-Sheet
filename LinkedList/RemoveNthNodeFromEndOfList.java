package LinkedList;

/*  19. Remove Nth Node From End of List
Given the head of a linked list, remove the nth node from the end of the list and return its head.

Example 1:
Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]

Example 2:
Input: head = [1], n = 1
Output: []

Example 3:
Input: head = [1,2], n = 1
Output: [1]

Constraints:
The number of nodes in the list is sz.
1 <= sz <= 30
0 <= Node.val <= 100
1 <= n <= sz
 */
public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        LL.printList(removeNthFromEnd(LL.getList(new int[]{1, 2, 3, 4, 5, 6}), 6));
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n <= 0)
            return head;
        ListNode cur = head;
        int count = 0;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        if (n > count) return head;
        if (count == n) {
            head = head.next;
            return head;
        }
        cur = head;
        while (count > n + 1) {
            cur = cur.next;
            count--;
        }
        cur.next = cur.next.next;
        return head;
    }
}
