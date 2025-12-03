package Tries;

// implementation of tries
public class TriesImplementation {
    private static Node root = new Node();

    public static void main(String[] args) {
        String[] words = {"hello", "hey", "hi", "hmmm"};
        // inserting word
        for (String word : words) {
            insert(word);
        }
        if (search("hmmm")) System.out.println("found");
        else System.out.println("not found");
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


