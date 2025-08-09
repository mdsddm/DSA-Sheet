package Queues;

import java.util.LinkedList;
import java.util.Queue;

/*  387. First Unique Character in a String
Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.

Example 1:
Input: s = "leetcode"
Output: 0
Explanation:
The character 'l' at index 0 is the first character that does not occur at any other index.

Example 2:
Input: s = "loveleetcode"
Output: 2

Example 3:
Input: s = "aabb"
Output: -1

Constraints:
1 <= s.length <= 105
s consists of only lowercase English letters.
 */
public class FirstUniqueCharacter {
    public static void main(String[] args) {
        System.out.println(firstUniqChar("aabb"));
    }

    public static int firstUniqChar(String s) {
        int[] freq = new int[26];
        int count = 0;
        Queue<Character> q = new LinkedList<>();
        for (char ch : s.toCharArray()) {
            q.add(ch);
            freq[ch - 'a']++;
            while (!q.isEmpty() && freq[q.peek() - 'a'] > 1) {
                q.remove();
                count++;
            }
        }
        if (q.isEmpty()) return -1;
        return count;
    }
}
