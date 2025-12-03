package LinkedList;

/* 83. Remove Duplicates from Sorted List
Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list 
sorted as well.

Example 1:
Input: head = [1,1,2]
Output: [1,2]

Example 2:
Input: head = [1,1,2,3,3]
Output: [1,2,3] */
public class RemoveDuplicatesFromSortedList {
    public static void main(String[] args) {
        ListNode head = LL.getList(new int[] { 0, 1, 1, 1, 1, 2, 3, 3, 4, 5, 5, 6, 7, 8, 8, 8, 8, 9 });
        LL.printList(deleteDuplicates(head));
    }

    private static ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }
}
