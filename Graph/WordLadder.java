package Graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/* 127. Word Ladder
A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words 
beginWord -> s1 -> s2 -> ... -> sk such that:
Every adjacent pair of words differs by a single letter.
Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
sk == endWord
Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation 
sequence from beginWord to endWord, or 0 if no such sequence exists.

Example 1:
Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
Output: 5
Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.

Example 2:
Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
Output: 0
Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.
 
Constraints:
1 <= beginWord.length <= 10
endWord.length == beginWord.length
1 <= wordList.length <= 5000
wordList[i].length == beginWord.length
beginWord, endWord, and wordList[i] consist of lowercase English letters.
beginWord != endWord
All the words in wordList are unique.
 */
public class WordLadder {
    public static void main(String[] args) {
        List<String> wordList = List.of("hot", "dot", "dog", "lot", "log", "cog");
        System.out.println(ladderLength("hit", "cog", wordList));
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>();
        HashSet<String> map = new HashSet<>(wordList);
        q.add(new Pair(beginWord, 1));
        map.remove(beginWord);
        while (!q.isEmpty()) {
            Pair cur = q.poll();
            String curWord = cur.word;
            int step = cur.step;
            if (curWord.equals(endWord)) {
                return step;
            }
            for (int i = 0; i < curWord.length(); i++) {
                char[] charArray = curWord.toCharArray();
                for (char j = 'a'; j <= 'z'; j++) {
                    charArray[i] = j;
                    String temp = new String(charArray);
                    if (map.contains(temp)) {
                        q.add(new Pair(temp, step + 1));
                        map.remove(temp);
                    }
                }
            }

        }
        return 0;
    }

    static class Pair {
        public String word;
        public int step;

        public Pair(String word, int step) {
            this.word = word;
            this.step = step;
        }
    }
}
