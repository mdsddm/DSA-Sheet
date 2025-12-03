package LinkedList;

import java.util.Comparator;
import java.util.PriorityQueue;

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
merging them into one sorted list:
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
public class MergeKSortedList {
    public static void main(String[] args) {
        ListNode l1 = LL.getList(new int[]{});
        ListNode l2 = LL.getList(new int[]{});
        ListNode l3 = LL.getList(new int[]{});
        ListNode[] listNodes = {l1, l2, l3};
        LL.printList(mergeKLists(listNodes));
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        // creating priority queue
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        // adding head of all list
        for (ListNode list : lists)
            if (list != null) pq.offer(list);
        // creating head and dummy
        ListNode head = null;
        ListNode dummy = null;
        // loop will run until queue is empty
        while (!pq.isEmpty()) {
            // polling node
            ListNode cur = pq.poll();
            // for first node
            if (head == null) {
                head = cur;
                dummy = cur;
            } else {
                dummy.next = cur; // otherwise pointing next
                dummy = dummy.next;
            }
            // after adding cur check it's next not null for adding
            if (cur.next != null) pq.offer(cur.next);
        }
        return head;
    }
}

