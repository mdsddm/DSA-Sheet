package Stacks;

import java.util.Stack;

/*  84. Largest Rectangle in Histogram

Given an array of integers heights representing the histogram's bar height where the width of each bar is 1,
return the area of the largest rectangle in the histogram.

Example 1:
Input: heights = [2,1,5,6,2,3]
Output: 10
Explanation: The above is a histogram where width of each bar is 1.
The largest rectangle is shown in the red area, which has an area = 10 units.

Example 2:
Input: heights = [2,4]
Output: 4

Constraints:
1 <= heights.length <= 105
0 <= heights[i] <= 104
 */
public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[]{2, 4}));
    }

    public static int largestRectangleArea(int[] heights) {
        int len = heights.length;
        if (len == 1) return heights[0];
        if (len == 2) return heights[0] == heights[1] ? 2 * heights[1] : Math.max(heights[1], heights[0]);
        int maxHeight = 0;
        Stack<Integer> s = new Stack<>();
        // next smallest right
        int[] nsr = new int[len];
        for (int i = len - 1; i >= 0; i--) {
            while (!s.isEmpty() && heights[s.peek()] >= heights[i]) s.pop();
            nsr[i] = s.isEmpty() ? len : s.peek();
            s.push(i);
        }
        // next smallest left
        s = new Stack<>();
        int[] nsl = new int[len];
        for (int i = 0; i < len; i++) {
            while (!s.isEmpty() && heights[s.peek()] >= heights[i]) s.pop();
            nsl[i] = s.isEmpty() ? -1 : s.peek();
            s.push(i);
        }
        // now calculating rectangle size
        for (int i = 0; i < len; i++) {
            int height = heights[i];
            int width = nsr[i] - nsl[i] - 1;
            int curHeight = height * width;
            maxHeight = Integer.max(maxHeight, curHeight);
        }

        return maxHeight;
    }
}
