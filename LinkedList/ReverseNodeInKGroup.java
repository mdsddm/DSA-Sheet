package LinkedList;


/*  25. Reverse Nodes in k-Group
Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.
k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is
not a multiple of k then left-out nodes, in the end, should remain as it is.
You may not alter the values in the list's nodes, only nodes themselves may be changed.

Example 1:
Input: head = [1,2,3,4,5], k = 2
Output: [2,1,4,3,5]

Example 2:
Input: head = [1,2,3,4,5], k = 3
Output: [3,2,1,4,5]

Constraints:
The number of nodes in the list is n.
1 <= k <= n <= 5000
0 <= Node.val <= 1000
Follow-up: Can you solve the problem in O(1) extra memory space?
 */
public class ReverseNodeInKGroup {
    public static void main(String[] args) {
        ListNode head = LL.getList(new int[]{1, 2, 3, 4, 5, 6, 7});
        LL.printList(reverseKGroup(head, 3));
    }

    public static ListNode reverseKGroup(ListNode head, int k) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode p = head;
        int count = 1;
        while (p != null && count < k) {
            p = p.next;
            count++;
        }

        if (p != null) {
            ListNode pNext = p.next;
            p.next = null;
            ListNode[] reversedList = reverse(head);
            reversedList[1].next = reverseKGroup(pNext, k);
            return reversedList[0];
        }

        return head;
    }

    private static ListNode[] reverse(ListNode head) {
        ListNode p1 = null;
        ListNode p2 = head;

        while (p2 != null) {
            ListNode temp = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = temp;
        }
        return new ListNode[]{p1, head};

    }
}

