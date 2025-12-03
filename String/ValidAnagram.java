package String;
/*
Given two strings s and t, return true if t is an anagram of s, and false otherwise.

Example 1:
Input: s = "anagram", t = "nagaram"
Output: true

Example 2:
Input: s = "rat", t = "car"
Output: false
 */
public class ValidAnagram {
    public static void main(String[] args) {
        String s="anagram";
        String t="nagara";
        System.out.println(isAnagram(s,t));
    }
    public static boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())
            return false;
        // storing lowercase alphabet
        int[] alAr=new int[26];
        for(int i=0;i<s.length();i++){
            alAr[s.charAt(i)-'a']++;
            alAr[t.charAt(i)-'a']--;
        }
        for(int i:alAr)
            if(i!=0)
                return false;
        return true;
    }

}
