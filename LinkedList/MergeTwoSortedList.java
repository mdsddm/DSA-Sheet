package LinkedList;

/*  21. Merge Two Sorted Lists
You are given the heads of two sorted linked lists list1 and list2.
Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
Return the head of the merged linked list.

Example 1:
Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]

Example 2:
Input: list1 = [], list2 = []
Output: []

Example 3:
Input: list1 = [], list2 = [0]
Output: [0]
 */
public class MergeTwoSortedList {
    public static void main(String[] args) {
        ListNode list1 = LL.getList(new int[]{1, 2, 4});
        ListNode list2 = LL.getList(new int[]{1, 3, 4});
        System.out.println("Merging two sorted linked lists without affecting the original nodes:");
        LL.printList(list1);
        LL.printList(list2);
        LL.printList(mergeTwoListsNotEffectingOriginalNode(list1, list2));
        System.out.println("Merging two sorted linked lists and modifying the original nodes:");
        LL.printList(mergeTwoLists(list1, list2));

    }

    // This function merges two sorted linked lists without affecting the original nodes.
    public static ListNode mergeTwoListsNotEffectingOriginalNode(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) return null;
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        ListNode ans;
        if (list1.val < list2.val) {
            ans = new ListNode(list1.val);
            list1 = list1.next;
        } else {
            ans = new ListNode(list2.val);
            list2 = list2.next;
        }
        ListNode cur = ans;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                cur.next = new ListNode(list1.val);
                list1 = list1.next;
            } else {
                cur.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            cur = cur.next;
        }
        while (list1 != null) {
            cur.next = new ListNode(list1.val);
            list1 = list1.next;
            cur = cur.next;
        }
        while (list2 != null) {
            cur.next = new ListNode(list2.val);
            list2 = list2.next;
            cur = cur.next;
        }
        return ans;
    }

    // This function merges two sorted linked lists and modifies the original nodes.
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) return null;
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        ListNode ans = new ListNode(-1);
        ListNode cur = ans;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        if (list1 != null) cur.next = list1;

        else cur.next = list2;

        return ans.next;
    }
}
