package Queues;

import java.util.Deque;
import java.util.LinkedList;

/*  239. Sliding Window Maximum
You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of
the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right
by one position.
Return the max sliding window.

Example 1:
Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]
Explanation:
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7

Example 2:
Input: nums = [1], k = 1
Output: [1]
 */
public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int[] ans = maxSlidingWindow(nums, 3);
        for (int cur : ans)
            System.out.print(cur + " ");
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        Deque<Integer> dq = new LinkedList<>();
        for (int i = 0, in = 0; i < nums.length; i++) {
            // remove indices outside the current window
            if (!dq.isEmpty() && i - dq.peekFirst() + 1 > k)
                dq.pollFirst();

            // remove indices of smaller elements from the back
            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i])
                dq.pollLast();

            // add current index
            dq.offerLast(i);

            // add current max answer
            if (i + 1 >= k)
                ans[in++] = nums[dq.peekFirst()];
        }

        return ans;
    }
}
