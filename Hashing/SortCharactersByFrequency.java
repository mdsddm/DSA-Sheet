package Hashing;

import java.util.Comparator;
import java.util.PriorityQueue;

/*  451. Sort Characters By Frequency
Given a string s, sort it in decreasing order based on the frequency of the characters. The frequency of a character is the number
of times it appears in the string.
Return the sorted string. If there are multiple answers, return any of them.

Example 1:
Input: s = "tree"
Output: "eert"
Explanation: 'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.

Example 2:
Input: s = "cccaaa"
Output: "aaaccc"
Explanation: Both 'c' and 'a' appear three times, so both "cccaaa" and "aaaccc" are valid answers.
Note that "cacaca" is incorrect, as the same characters must be together.

Example 3:
Input: s = "Aabb"
Output: "bbAa"
Explanation: "bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.

Constraints:
1 <= s.length <= 5 * 105
s consists of uppercase and lowercase English letters and digits.
 */
public class SortCharactersByFrequency {
    public static void main(String[] args) {
        String s ="Aabb";
        System.out.println(frequencySort(s));
    }

    public static String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char key = s.charAt(i);
            int val = map.containsKey(key) ? map.get(key) : 0;
            map.put(key, val + 1);
        }

        PriorityQueue<Freq> pq = new PriorityQueue<>(Comparator.comparingInt((Freq o) -> o.num).reversed());
        // storing in priority queue
        for (char key : map.keySet()) {
            pq.add(new Freq(key, map.get(key)));
        }
        StringBuilder sb = new StringBuilder(s.length());
        while (!pq.isEmpty()) {
            Freq freq = pq.poll();
            char c = freq.c;
            int n = freq.num;
            sb.append(String.valueOf(c).repeat(n));
        }
        return sb.toString();
    }
}

class Freq {
    char c;
    int num;

    public Freq(char c, int num) {
        this.c = c;
        this.num = num;
    }
}
