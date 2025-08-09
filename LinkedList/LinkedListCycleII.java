package LinkedList;

import java.util.Scanner;

/*  142. Linked List Cycle II
Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.
There is a cycle in a linked list if there is some node in the list that can be reached again by continuously
following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is
connected to (0-indexed). It is -1 if there is no cycle. Note that pos is not passed as a parameter.
Do not modify the linked list.

Example 1:
Input: head = [3,2,0,-4], pos = 1
Output: tail connects to node index 1
Explanation: There is a cycle in the linked list, where tail connects to the second node.

Example 2:
Input: head = [1,2], pos = 0
Output: tail connects to node index 0
Explanation: There is a cycle in the linked list, where tail connects to the first node.

Example 3:
Input: head = [1], pos = -1
Output: no cycle
Explanation: There is no cycle in the linked list.
 */
public class LinkedListCycleII {
    public static void main(String[] args) {
        System.out.print("Enter value: ");
        Scanner in = new Scanner(System.in);
        ListNode list1 = new ListNode(in.nextInt());
        ListNode cur1=list1;
        for(int i = 0 ; i<4;i++){
            cur1.next = new ListNode(in.nextInt());
            cur1=cur1.next;

        }
        cur1.next=list1.next.next;
        System.out.println("hasCycle : "+hasCycle(list1));
        System.out.println(detectCycle(list1).val);
        in.close();

    }
    public static boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){ return true; }
        }
        return false;
    }
    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }

        return null;

    }
}
