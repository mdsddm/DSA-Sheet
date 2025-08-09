package LinkedList;

/*  92. Reverse Linked List II
Given the head of a singly linked list and two integers left and right where left <= right, reverse the
nodes of the list from position left to position right, and return the reversed list.

Example 1:
Input: head = [1,2,3,4,5], left = 2, right = 4
Output: [1,4,3,2,5]

Example 2:
Input: head = [5], left = 1, right = 1
Output: [5]

Constraints:
The number of nodes in the list is n.
1 <= n <= 500
-500 <= Node.val <= 500
1 <= left <= right <= n
 */
public class ReverseListII {
    public static void main(String[] args) {
        LL.printList(reverseBetween(LL.getList(new int[]{1, 2, 3}), 1, 2));
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;

        // Move `pre` to the node before position `left`
        for (int i = 1; i < left; i++) {
            pre = pre.next;
        }

        ListNode curr = pre.next;
        ListNode next;

        // Reverse `right - left` links
        for (int i = left; i < right; i++) {
            next = curr.next;
            curr.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }

        return dummy.next;

    }
}
