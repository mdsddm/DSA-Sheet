package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*  56. Merge Intervals
Given an array of intervals where intervals[i] = [start, end], merge all overlapping intervals, and return an array
of the non-overlapping intervals that cover all the intervals in the input.

Example 1:
Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].

Example 2:
Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.

Constraints:
1 <= intervals.length <= 104
intervals[i].length == 2
0 <= start <= end <= 104
 */
public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        for (int[] interval : merge(intervals)) {
            for (int val : interval)
                System.out.print(val + " ");
            System.out.println();
        }
    }

    public static int[][] merge(int[][] intervals) {
        int len = intervals.length;
        if (len == 0 || len == 1) return intervals;
        Arrays.sort(intervals, Comparator.comparingDouble(o -> o[0]));
        List<int[]> ans = new ArrayList<>();
        int[] newInterval = intervals[0];
        ans.add(newInterval);
        for (int[] interval : intervals) {
            if (newInterval[1] >= interval[0]) {
                // [ 1 , 5 ]  +  [ 3 , 9 ]  -> [ 1 , 9 ] updating
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            } else {
                // [ 1 , 3 ]  +  [ 6 , 9 ]  -> newInterval : [ 6 , 9 ]
                newInterval = interval;
                ans.add(newInterval);
            }
        }
        return ans.toArray(new int[ans.size()][]);

    }
}
