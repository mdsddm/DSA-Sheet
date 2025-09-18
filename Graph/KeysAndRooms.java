package Graph;

import java.util.ArrayList;
//import java.util.LinkedList;
import java.util.List;
//import java.util.Queue;

/*  841. Keys and Rooms
There are n rooms labeled from 0 to n - 1 and all the rooms are locked except for room 0. Your goal is to visit all the rooms.
However, you cannot enter a locked room without having its key.
When you visit a room, you may find a set of distinct keys in it. Each key has a number on it, denoting which room it unlocks,
and you can take all of them with you to unlock the other rooms.
Given an array rooms where rooms[i] is the set of keys that you can obtain if you visited room i, return true if you can visit all
the rooms, or false otherwise.

Example 1:
Input: rooms = [[1],[2],[3],[]]
Output: true
Explanation:
We visit room 0 and pick up key 1.
We then visit room 1 and pick up key 2.
We then visit room 2 and pick up key 3.
We then visit room 3.
Since we were able to visit every room, we return true.

Example 2:
Input: rooms = [[1,3],[3,0,1],[2],[0]]
Output: false
Explanation: We can not enter room number 2 since the only key that unlocks it is in that room.

Constraints:
n == rooms.length
2 <= n <= 1000
0 <= rooms[i].length <= 1000
1 <= sum(rooms[i].length) <= 3000
0 <= rooms[i][j] < n
All the values of rooms[i] are unique.
 */
public class KeysAndRooms {
    public static void main(String[] args) {
        List<List<Integer>> rooms = new ArrayList<>();
        // [[1,3],[3,0,1],[2],[0]]
        rooms.add(List.of(1, 3));
        rooms.add(List.of(3, 0, 1));
        rooms.add(List.of(2));
        rooms.add(List.of(0));
        System.out.println(canVisitAllRooms(rooms));
    }

    private static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        /*
         * this method use bfs low efficient
         * int n = rooms.size();
         * boolean[] isVis = new boolean[n];
         * Queue<Integer> q = new LinkedList<>();
         * q.add(0); //adding first element
         * while (!q.isEmpty()) {
         * int v = q.poll();
         * if (!isVis[v]) { // if vertex not visited
         * // mark as visited
         * isVis[v] = true;
         * n--;
         * List<Integer> keys = rooms.get(v);
         * q.addAll(keys); //adding all keys
         * }
         * }
         * // after adding all keys check for any node is not visited
         * return n==0;
         * 
         */
        // using dfs
        int n = rooms.size();
        boolean[] isVis = new boolean[n];
        dfs(0, isVis, rooms);
        return count == n;
    }

    static int count = 0;

    private static void dfs(int v, boolean[] isVis, List<List<Integer>> rooms) {
        if (!isVis[v]) {
            isVis[v] = true;
            count++;
            for (int key : rooms.get(v))
                if (!isVis[key])
                    dfs(key, isVis, rooms);
        }
    }
}
