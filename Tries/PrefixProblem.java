package Tries;

/*
Given an array of words, find all shortest unique prefixes to represent each word in the given array.
Assume that no word is prefix of another.

Example 1:
Input:
N = 4
arr[] = {"zebra", "dog", "duck", "dove"}
Output: z dog du dov
Explanation:
z => zebra
dog => dog
duck => du
dove => dov
Example 2:

Input:
N = 3
arr[] =  {"geeksgeeks", "geeksquiz", "geeksforgeeks"};
Output: geeksg geeksq geeksf
Explanation:
geeksgeeks => geeksg
geeksquiz => geeksq
geeksforgeeks => geeksf
Your task:
You don't have to read input or print anything. Your task is to complete the function findPrefixes() which takes the array
of strings and it's size N as input and returns a list of shortest unique prefix for each word
Expected Time Complexity: O(N*length of each word)
Expected Auxiliary Space: O(N*length of each word)

Constraints:
1 ≤ N, Length of each word ≤ 1000
 */
public class PrefixProblem {
    private static final Node root = new Node();
    static int count = -1;

    public static void main(String[] args) {
        /*
         * N = 4
         * arr[] = {"zebra", "dog", "duck", "dove"}
         */
        String[] arr = { "zebra", "dog", "duck", "dove" };
        for (String ans : findPrefixes(arr, 4))
            System.out.print(ans);
    }

    public static String[] findPrefixes(String[] arr, int N) {
        String[] ans = new String[N];
        for (String word : arr) {
            insert(word);
        }
        root.freq = -1;
        for (int i = 0; i < N; i++) {

        }
        findPrefix(root, ans, "");
        return ans;

    }

    private static void insert(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (cur.child[idx] == null) {
                cur.child[idx] = new Node();
            } else {
                cur.child[idx].freq++;
            }
            cur = cur.child[idx];
        }
        cur.eow = true;
    }

    private static void findPrefix(Node root, String[] ans, String s) {
        if (root == null)
            return;
        if (root.freq == 1) {
            ans[++count] = s;
            return;
        }
        for (int i = 0; i < 26; i++) {
            if (root.child[i] != null)
                findPrefix(root.child[i], ans, s + (char) (i + 'a'));
        }

    }

    private static class Node {
        Node[] child = new Node[26];
        private boolean eow;
        int freq;

        Node() {
            for (int i = 0; i < 26; i++) {
                child[i] = null;
            }
            freq = 1;
        }
    }

}
