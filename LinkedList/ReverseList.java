package LinkedList;
/*  206. Reverse Linked List
Given the head of a singly linked list, reverse the list, and return the reversed list.

Example 1:
Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]

Example 2:
Input: head = [1,2]
Output: [2,1]

Example 3:
Input: head = []
Output: []
 */

public class ReverseList {
    public static void main(String[] args) {
    }
    public ListNode reverseList(ListNode head) {
        if(head==null)
            return null;
        ListNode prev = null;
        ListNode curr = head;
        ListNode next;
        while (curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head=prev;

        return head;
    }
}

