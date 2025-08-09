package String;
/*  3442. Maximum Difference Between Even and Odd Frequency
You are given a string s consisting of lowercase English letters.
Your task is to find the maximum difference diff = freq(a1) - freq(a2)
between the frequency of characters a1 and a2 in the string such that:
a1 has an odd frequency in the string.
a2 has an even frequency in the string.
Return this maximum difference.

Example 1:
Input: s = "aaaaabbc"
Output: 3
Explanation:
The character 'a' has an odd frequency of 5, and 'b' has an even frequency of 2.
The maximum difference is 5 - 2 = 3.

Example 2:
Input: s = "abcabcab"
Output: 1
Explanation:
The character 'a' has an odd frequency of 3, and 'c' has an even frequency of 2.
The maximum difference is 3 - 2 = 1.
 */
public class MaximumDifferenceBetweenOddAndEvenFrequency {
    public static void main(String[] args) {
        System.out.println(maxDifference("abcabcab"));
    }
    public static int maxDifference(String s) {
        int [] freqStore = new int[26];
        for(int i=0;i<s.length();i++){
            freqStore[s.charAt(i)-'a']++;
        }
        int maxOdd=Integer.MIN_VALUE;
        int minEven=Integer.MAX_VALUE;
        for (int i : freqStore){
            if (i!=0 & i%2==0)
                minEven=Integer.min(minEven,i);
            else
                maxOdd=Integer.max(maxOdd,i);
        }
        return (maxOdd-minEven);
    }
}
