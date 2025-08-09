package String;
/*
Write a function to find the longest common prefix string amongst an array of strings.
If there is no common prefix, return an empty string "".

Example 1:
Input: strs = ["flower","flow","flight"]
Output: "fl"

Example 2:
Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
 */
public class ValidCommonPrefix {
    public static void main(String[] args) {
        String[] strs ={"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }
    public static String longestCommonPrefix(String[] strs) {
        StringBuilder sb=new StringBuilder("");
        for(String str:strs){
            System.out.print(str+" ");
        }

        return sb.toString();

    }
}

