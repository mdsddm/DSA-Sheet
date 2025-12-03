package LinkedList;
/*  1290. Convert Binary Number in a Linked List to Integer
Given head which is a reference node to a singly-linked list. The value of each node in the linked list
is either 0 or 1. The linked list holds the binary representation of a number.
Return the decimal value of the number in the linked list.
The most significant bit is at the head of the linked list.

Example 1:
Input: head = [1,0,1]
Output: 5
Explanation: (101) in base 2 = (5) in base 10

Example 2:
Input: head = [0]
Output: 0

Constraints:
The Linked List is not empty.
Number of nodes will not exceed 30.
Each node's value is either 0 or 1.
 */
public class ConvertBinaryNumberInALinkedLIstToInteger {
    public static void main(String[] args) {
        ListNode head = LL.getList(new int[] { 0 });
        System.out.println(getDecimalValue(head));

    }

    public static int getDecimalValue(ListNode head) {
        // ListNode cur = head;
        // Stack<ListNode> st = new Stack<>();
        // while (cur != null) {
        // st.push(cur);
        // cur = cur.next;
        // }
        // int ans = 0, power = 0;
        // while (!st.isEmpty()) {
        // ListNode curNode = st.pop();
        // ans += curNode.val * (int) Math.pow(2, power);
        // power++;
        // }
        // return ans;
        int result = head.val;
        while (head.next != null) {
            result = result * 2 + head.next.val;
            head = head.next;
        }
        return result;
    }
}
