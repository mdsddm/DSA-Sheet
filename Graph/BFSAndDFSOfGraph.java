package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*  Given a connected undirected graph containing V vertices, represented by a 2-d adjacency list adj[][], where each adj[i]
represents the list of vertices connected to vertex i. Perform a Breadth First Search (BFS) traversal starting from vertex 0, visiting
vertices from left to right according to the given adjacency list, and return a list containing the BFS traversal of the graph.
Note: Do traverse in the same order as they are in the given adjacency list.

Examples:
Input: adj[][] = [[2, 3, 1], [0], [0, 4], [0], [2]]
Output: [0, 2, 3, 1, 4]
Explanation: Starting from 0, the BFS traversal will follow these steps:
Visit 0 → Output: 0
Visit 2 (first neighbor of 0) → Output: 0, 2
Visit 3 (next neighbor of 0) → Output: 0, 2, 3
Visit 1 (next neighbor of 0) → Output: 0, 2, 3,
Visit 4 (neighbor of 2) → Final Output: 0, 2, 3, 1, 4

Input: adj[][] = [[1, 2], [0, 2], [0, 1, 3, 4], [2], [2]]
Output: [0, 1, 2, 3, 4]
Explanation: Starting from 0, the BFS traversal proceeds as follows:
Visit 0 → Output: 0
Visit 1 (the first neighbor of 0) → Output: 0, 1
Visit 2 (the next neighbor of 0) → Output: 0, 1, 2
Visit 3 (the first neighbor of 2 that hasn't been visited yet) → Output: 0, 1, 2, 3
Visit 4 (the next neighbor of 2) → Final Output: 0, 1, 2, 3, 4
 */
public class BFSAndDFSOfGraph {

    private static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] isVis = new boolean[adj.size()];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        while (!q.isEmpty()) {
            int v = q.poll();
            if (!isVis[v]) {
                ans.add(v);
                isVis[v] = true; // mark as visited
                q.addAll(adj.get(v));
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList<>(List.of(2, 3, 1)));
        adj.add(new ArrayList<>(List.of(0)));
        adj.add(new ArrayList<>(List.of(0, 4)));
        adj.add(new ArrayList<>(List.of(0)));
        adj.add(new ArrayList<>(List.of(2)));
        System.out.println("Adjacent List : ");
        for (ArrayList<Integer> sub : adj)
            System.out.print(sub + "  ");

        System.out.println("/n Bfs :");
        System.out.println(bfs(adj));

        System.out.println("DFS : ");
        System.out.println(dfs(adj));


    }

    static ArrayList<Integer> ans = new ArrayList<>();

    private static ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        boolean[] isVis = new boolean[adj.size()];
        getDFS(adj,0,isVis);
        return ans;
    }

    private static void getDFS(ArrayList<ArrayList<Integer>> adj, int v, boolean[] isVis) {
        if (!isVis[v]) {
            isVis[v] = true;
            ans.add(v);
            for (int vertex : adj.get(v))
                getDFS(adj, vertex, isVis);
        }
    }

}
/*
Given a connected undirected graph containing V vertices represented by a 2-d adjacency list adj[][], where each adj[i] represents
the list of vertices connected to vertex i. Perform a Depth First Search (DFS) traversal starting from vertex 0, visiting vertices
from left to right as per the given adjacency list, and return a list containing the DFS traversal of the graph.

Note: Do traverse in the same order as they are in the given adjacency list.

Examples:
Input: adj[][] = [[2, 3, 1], [0], [0, 4], [0], [2]]
Output: [0, 2, 4, 3, 1]
Explanation: Starting from 0, the DFS traversal proceeds as follows:
Visit 0 → Output: 0
Visit 2 (the first neighbor of 0) → Output: 0, 2
Visit 4 (the first neighbor of 2) → Output: 0, 2, 4
Backtrack to 2, then backtrack to 0, and visit 3 → Output: 0, 2, 4, 3
Finally, backtrack to 0 and visit 1 → Final Output: 0, 2, 4, 3, 1

Input: adj[][] = [[1, 2], [0, 2], [0, 1, 3, 4], [2], [2]]
Output: [0, 1, 2, 3, 4]
Explanation: Starting from 0, the DFS traversal proceeds as follows:
Visit 0 → Output: 0
Visit 1 (the first neighbor of 0) → Output: 0, 1
Visit 2 (the first neighbor of 1) → Output: 0, 1, 2
Visit 3 (the first neighbor of 2) → Output: 0, 1, 2, 3
Backtrack to 2 and visit 4 → Final Output: 0, 1, 2, 3, 4
 */