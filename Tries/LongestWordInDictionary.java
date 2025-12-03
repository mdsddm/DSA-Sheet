package Tries;

/*  720. Longest Word in Dictionary
Given an array of strings words representing an English Dictionary, return the longest word in words that can be built one
character at a time by other words in words.
If there is more than one possible answer, return the longest word with the smallest lexicographical order. If there is no answer,
return the empty string.
Note that the word should be built from left to right with each additional character being added to the end of a previous word.

Example 1:
Input: words = ["w","wo","wor","worl","world"]
Output: "world"
Explanation: The word "world" can be built one character at a time by "w", "wo", "wor", and "worl".

Example 2:
Input: words = ["a","banana","app","appl","ap","apply","apple"]
Output: "apple"
Explanation: Both "apply" and "apple" can be built from other words in the dictionary. However, "apple" is lexicographically smaller than "apply".

Constraints:
1 <= words.length <= 1000
1 <= words[i].length <= 30
words[i] consists of lowercase English letters.
 */
public class LongestWordInDictionary {
    private static final Node root = new Node();
    private static String ans = "";

    public static void main(String[] args) {
        String[] words = {"a", "banana", "app", "appl", "ap", "apply", "apple" };
        System.out.println(longestWord(words));
    }

    public static String longestWord(String[] words) {
        for (String word : words)
            insert(word);
        longest(root, new StringBuilder());
        return ans;
    }

    private static void longest(Node root, StringBuilder sb) {
        if (root == null) return;

        for (int i = 0; i < 26; i++) {
            if (root.child[i] != null && root.child[i].eow) {
                sb.append((char) (i + 'a'));
                if (sb.length() > ans.length()) ans = sb.toString();
                longest(root.child[i], sb);
                // backtracking
                sb.deleteCharAt(sb.length() - 1);
            }
        }

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

    private static class Node {
        Node[] child = new Node[26];
        boolean eow;

        Node() {
            for (int i = 0; i < 26; i++) {
                child[i] = null;
            }
        }
    }

}
