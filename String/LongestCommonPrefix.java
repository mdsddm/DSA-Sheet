package String;

/*  14. Longest Common Prefix
Write a function to find the longest common prefix string amongst an array of strings.
If there is no common prefix, return an empty string "".

Example 1:
Input: strs = ["flower","flow","flight"]
Output: "fl"

Example 2:
Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix amongst the input strings.

Constraints:
1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lowercase English letters if it is non-empty.
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"flower"};
        System.out.println(longestCommonPrefix(strs));


    }

    public static String longestCommonPrefix(String[] strs) {
        // brute force approach
//        if (strs.length == 0 || strs[0].isEmpty()) return "";
//        if (strs.length == 1) return strs[0];
//        String in = strs[0];
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < in.length(); i++) {
//            for (int j = 1; j < strs.length; j++) {
//                if (i + 1 > strs[j].length() || in.charAt(i) != strs[j].charAt(i)) return sb.toString();
//            }
//            sb.append(in.charAt(i));
//        }
//        return sb.toString();
        // optimize approach
        String prefix = strs[0];
        for (int index = 1; index < strs.length; index++) {
            while (strs[index].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;


    }
}
