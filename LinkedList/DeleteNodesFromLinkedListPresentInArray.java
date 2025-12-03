package LinkedList;

import java.util.Arrays;

/*  3217. Delete Nodes From Linked List Present in Array
You are given an array of integers nums and the head of a linked list. Return the head of the modified linked list after removing all nodes from the linked list that have a value that exists in nums.

Example 1:
Input: nums = [1,2,3], head = [1,2,3,4,5]
Output: [4,5]
Explanation:
Remove the nodes with values 1, 2, and 3.

Example 2:
Input: nums = [1], head = [1,2,1,2,1,2]
Output: [2,2,2]
Explanation:
Remove the nodes with value 1.

Example 3:
Input: nums = [5], head = [1,2,3,4]
Output: [1,2,3,4]
Explanation:
No node has value 5.

Constraints:
1 <= nums.length <= 105
1 <= nums[i] <= 105
All elements in nums are unique.
The number of nodes in the given list is in the range [1, 105].
1 <= Node.val <= 105
The input is generated such that there is at least one node in the linked list that has a value not present in nums.
 */
public class DeleteNodesFromLinkedListPresentInArray {
    public static void main(String[] args) {
        int[] nums = { 9, 2, 5 };
        ListNode head = LL.getList(new int[] { 2, 10, 9, 11, 15 });
        System.out.println("nums: " + Arrays.toString(nums));
        System.out.println("before");
        LL.printList(head);
        System.out.println("after");
        LL.printList(modifiedList(nums, head));

    }

    private static ListNode modifiedList(int[] nums, ListNode head) {
        int max = -1;
        for (int num : nums) {
            max = num > max ? num : max;
        }
        boolean[] freq = new boolean[max + 1];

        for (int num : nums)
            freq[num] = true;

        ListNode temp = new ListNode(-1);
        ListNode current = temp;

        while (head != null) {
            if (head.val >= max + 1 || freq[head.val] == false) {
                current.next = head;
                current = current.next;
            }
            head = head.next;
        }

        current.next = null;
        return temp.next;
    }
}
