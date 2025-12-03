package LinkedList;

/*  23. Merge k Sorted Lists
You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
Merge all the linked-lists into one sorted linked-list and return it.

Example 1:
Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted linked list:
1->1->2->3->4->4->5->6

Example 2:
Input: lists = []
Output: []

Example 3:
Input: lists = [[]]
Output: []

Constraints:
k == lists.length
0 <= k <= 104
0 <= lists[i].length <= 500
-104 <= lists[i][j] <= 104
lists[i] is sorted in ascending order.
The sum of lists[i].length will not exceed 104.
 */
public class MergeKSortedLists {
    public static void main(String[] args) {
        /*
    Input: lists = [[1,4,5],[1,3,4],[2,6]]
    Output: [1,1,2,3,4,4,5,6]
         */
        ListNode one = LL.getList(new int[]{1, 4, 5});
        ListNode two = LL.getList(new int[]{1, 3, 4});
        ListNode three = LL.getList(new int[]{2, 6});
        ListNode[] lists = {one, two, three};
        ListNode ans = mergeKLists(lists);
        LL.printList(ans);

    }

    public static ListNode mergeKLists(ListNode[] lists) {
        return mergeList(lists, 0, lists.length - 1);
    }

    public static ListNode mergeList(ListNode[] list, int start, int end) {
        if (start > end) return null;
        if (start == end) return list[start];  // FIX: return the list itself when one list is left
        int mid = start + (end - start) / 2;
        ListNode ln = mergeList(list, start, mid);
        ListNode rn = mergeList(list, mid + 1, end);
        return merge(ln, rn);
    }

    public static ListNode merge(ListNode list1, ListNode list2) {
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
