package LinkedList;

/*  61. Rotate List
Given the head of a linked list, rotate the list to the right by k places.

Example 1:
Input: head = [1,2,3,4,5], k = 2
Output: [4,5,1,2,3]

Example 2:
Input: head = [0,1,2], k = 4
Output: [2,0,1]

Constraints:
The number of nodes in the list is in the range [0, 500].
-100 <= Node.val <= 100
0 <= k <= 2 * 109
 */
public class RotateList {
    public static void main(String[] args) {
        ListNode list = LL.getList(new int[]{1, 2, 3, 4, 5});
        LL.printList(rotateRight(list, 2));
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null)
            return head;
        int size = 0;
        ListNode cur = head;
        // getting size of linked list
        while (cur != null) {
            cur = cur.next;
            size++;
        }
        // needed rotation
        int rotation = k % size;
        ListNode pre = null;
        while (rotation > 0) {
            cur = head;
            // determining last node
            while (cur.next != null) {
                pre = cur;
                cur = cur.next;
            }
            pre.next = null;
            cur.next = head;
            head = cur;
            rotation--;
            pre = null;
        }
        return head;
    }
}
