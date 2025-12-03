package Heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

/*  1631. Path With Minimum Effort
You are a hiker preparing for an upcoming hike. You are given heights, a 2D array of size rows x columns, where heights[row][col]
represents the height of cell (row, col). You are situated in the top-left cell, (0, 0), and you hope to travel to the
bottom-right cell, (rows-1, columns-1) (i.e., 0-indexed). You can move up, down, left, or right, and you wish to find a route
that requires the minimum effort.
A route's effort is the maximum absolute difference in heights between two consecutive cells of the route.
Return the minimum effort required to travel from the top-left cell to the bottom-right cell.

Example 1:
Input: heights = [[1,2,2],[3,8,2],[5,3,5]]
Output: 2
Explanation: The route of [1,3,5,3,5] has a maximum absolute difference of 2 in consecutive cells.
This is better than the route of [1,2,2,2,5], where the maximum absolute difference is 3.

Example 2:
Input: heights = [[1,2,3],[3,8,4],[5,3,5]]
Output: 1
Explanation: The route of [1,2,3,4,5] has a maximum absolute difference of 1 in consecutive cells, which is better
than route [1,3,5,3,5].

Example 3:
Input: heights = [[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]
Output: 0
Explanation: This route does not require any effort.
 */
public class PathWithMinimumEffort {
    public static void main(String[] args) {
        /*
        Input: heights = [[1,2,2],[3,8,2],[5,3,5]]
        Output: 2
         */
        int[][] height = {{1, 2, 2}, {3, 8, 2}, {5, 3, 5}};
        System.out.println(minimumEffortPath(height));
    }

    public static int minimumEffortPath(int[][] heights) {
        int row = heights.length, col = heights[0].length;
        // storing visiting index
        boolean[][] ifSee = new boolean[row][col];

        // top, right, down, left
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        // creating priority queue
        PriorityQueue<Data> pq = new PriorityQueue<>(Comparator.comparing(o -> o.dif)); // comparing w.r. diff

        // storing first index
        pq.add(new Data(0, 0, 0));

        while (!pq.isEmpty()) {
            Data curData = pq.poll();
            int sr = curData.row;
            int sc = curData.col;
            int curDif = curData.dif;
            ifSee[sr][sc] = true;
            if (sr == row - 1 && sc == col - 1) return curDif;
            for (int i = 0; i < 4; i++) {
                int nr = sr + dr[i];
                int nc = sc + dc[i];
                if (nr >= 0 && nc >= 0 && nr < row && nc < col && !ifSee[nr][nc]) {
                    int newDif = Math.abs(heights[sr][sc] - heights[nr][nc]);
                    pq.add(new Data(nr, nc, Math.max(curDif, newDif)));
                }
            }
        }
        return 0;


    }
}

class Data {
    int row;
    int col;
    int dif;

    public Data(int row, int col, int dif) {
        this.row = row;
        this.col = col;
        this.dif = dif;
    }
}
