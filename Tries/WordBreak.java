package Tries;

import java.util.Arrays;
import java.util.List;

/*  139. Word Break
Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of
one or more dictionary words.
Note that the same word in the dictionary may be reused multiple times in the segmentation.

Example 1:
Input: s = "leetcode", wordDict = ["leet","code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".

Example 2:
Input: s = "applepenapple", wordDict = ["apple","pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
Note that you are allowed to reuse a dictionary word.

Example 3:
Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: false

Constraints:
1 <= s.length <= 300
1 <= wordDict.length <= 1000
1 <= wordDict[i].length <= 20
s and wordDict[i] consist of only lowercase English letters.
All the strings of wordDict are unique.
 */
public class WordBreak {
    private static final Node root = new Node();

    public static void main(String[] args) {
//        Input: s = "leetcode", wordDict = ["leet","code"]
        String s = "applepenapple";
        List<String> wordDict = Arrays.asList("apple","pen");
        System.out.println(wordBreak(s, wordDict));

    }

    private static void insert(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (cur.child[idx] == null) {
                cur.child[idx] = new Node();
            }
            cur = cur.child[idx];
        }
        cur.eow = true;
    }

    private static boolean search(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (cur.child[idx] == null) return false;
            cur = cur.child[idx];
        }
        return cur.eow;
    }

    private static boolean wordBreak(String s, List<String> wordDict) {
        // inserting word into tries
        for (String word : wordDict)
            insert(word);

        return breakWord(s);

    }

    private static boolean breakWord(String word) {
        if (word.isEmpty()) return true;
        for (int i = 1; i <= word.length(); i++) {
            if (search(word.substring(0, i)) && search(word.substring(i))) return true;
        }
        return false;
    }

    static class Node {
        Node[] child = new Node[26];
        boolean eow;

        Node() {
            for (int i = 0; i < 26; i++) {
                child[i] = null;
            }
        }
    }
}
