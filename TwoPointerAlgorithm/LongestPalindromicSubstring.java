package TwoPointerAlgorithm;

/*  5. Longest Palindromic Substring
Given a string s, return the longest palindromic substring in s.

Example 1:
Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.

Example 2:
Input: s = "cbbd"
Output: "bb"
 
Constraints:
1 <= s.length <= 1000
s consist of only digits and English letters.   */
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String s = "dabac";
        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s) {

        if (s == null || s.length() < 2) {
            return s;
        }

        int start = 0;
        int maxLen = 1;

        for (int i = 0; i < s.length(); i++) {

            // for odd length
            int left = i;
            int right = i;

            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }

            int len = right - left - 1;
            if (len > maxLen) {
                maxLen = len;
                start = left + 1;
            }

            // for even length
            left = i;
            right = i + 1;

            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }

            len = right - left - 1;
            if (len > maxLen) {
                maxLen = len;
                start = left + 1;
            }
        }

        return s.substring(start, start + maxLen);
    }

}