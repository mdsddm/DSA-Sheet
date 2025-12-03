package Graph;

import java.util.ArrayList;

/*  207. Course Schedule
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.

Example 1:
Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0. So it is possible.

Example 2:
Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 
Constraints:
1 <= numCourses <= 2000
0 <= prerequisites.length <= 5000
prerequisites[i].length == 2
0 <= ai, bi < numCourses
All the pairs prerequisites[i] are unique. */
public class CourseSchedule {
    public static void main(String[] args) {
        int[][] prerequisites = { { 1, 0 }, { 2, 1 }, { 3, 2 }, { 1, 3 } };
        System.out.println(canFinish(4, prerequisites));
    }

    private static boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        boolean[] isVis = new boolean[numCourses];
        boolean[] st = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<Integer>());
        }
        for (int[] edge : prerequisites) {
            int des = edge[0];
            int src = edge[1];
            adj.get(src).add(des);
        }
        for (int i = 0; i < adj.size(); i++) {
            if (!isVis[i]) {
                if (dfs(adj, i, isVis, st)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean dfs(ArrayList<ArrayList<Integer>> adj, int cur, boolean[] isVis, boolean[] st) {
        isVis[cur] = true;
        st[cur] = true;
        for (int con : adj.get(cur)) {
            if (st[con]) {
                return true;
            }
            if (!isVis[con] && dfs(adj, con, isVis, st)) {
                return true;
            }
        }
        st[cur] = false;
        return false;
    }

}