package String;
/* 567 Permutation in String
Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
In other words, return true if one of s1's permutations is the substring of s2.

Example 1:
Input: s1 = "ab", s2 = "eidbaooo"
Output: true
Explanation: s2 contains one permutation of s1 ("ba").

Example 2:
Input: s1 = "ab", s2 = "eidboaoo"
Output: false
 */
public class StringPermutation {
    public static void main(String[] args) {
        String s1 = "adc";
        String s2 = "dcda";
        System.out.println(checkInclusion(s1, s2));

    }

    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        int n1 = s1.length();
        int n2 = s2.length();
        int[] firstArr = new int[26];
        int[] secondArr = new int[26];
        for (int i = 0; i < n1; i++) {
            firstArr[s1.charAt(i) - 'a']++;
            secondArr[s2.charAt(i) - 'a']++;
        }
        if (isEqual(firstArr, secondArr))
            return true;
        for (int i = n1; i < n2; i++) {
            secondArr[s2.charAt(i - n1) - 'a']--;
            secondArr[s2.charAt(i) - 'a']++;
            if (isEqual(firstArr, secondArr))
                return true;
        }
        return false;
    }

    public static boolean isEqual(int[] first, int[] second) {
        for (int i = 0; i < 26; i++)
            if (first[i] != second[i])
                return false;
        return true;
    }
    // this is first and brute force approach
//    public static boolean checkInclusion(String s1, String s2) {
//        if(s1.length()>s2.length())
//            return false;
//        int n1=s1.length();
//        int n2=s2.length();
//        for(int i=0;i<n2-n1+1;i++){
//            String sub = s2.substring(i,i+n1);
//            if(isAnagram(s1,sub))
//                return true;
//        }
//        return false;
//    }
//    public static boolean isAnagram(String s, String t) {
//        if(s.length()!=t.length())
//            return false;
//        // storing lowercase alphabet
//        int[] alAr=new int[26];
//        for(int i=0;i<s.length();i++){
//            alAr[s.charAt(i)-'a']++;
//            alAr[t.charAt(i)-'a']--;
//        }
//        for(int i:alAr)
//            if(i!=0)
//                return false;
//        return true;
//    }
}
