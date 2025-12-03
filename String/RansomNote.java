package String;

/*383.  Ransom Note
Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.
Each letter in magazine can only be used once in ransomNote.

Example 1:
Input: ransomNote = "a", magazine = "b"
Output: false

Example 2:
Input: ransomNote = "aa", magazine = "ab"
Output: false

Example 3:
Input: ransomNote = "aa", magazine = "aab"
Output: true
 
Constraints:
1 <= ransomNote.length, magazine.length <= 105
ransomNote and magazine consist of lowercase English letters.   */
public class RansomNote {
    public static void main(String[] args) {
        String ransomNotes = "aabb";
        String magazine = "aaaaab";
        System.out.println(canConstruct(ransomNotes, magazine));

    }

    private static boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        int[] chArr = new int[26];
        for (char c : magazine.toCharArray()) {
            chArr[(c - 'a')]++;
        }
        for (char c : ransomNote.toCharArray()) {
            if (chArr[(c - 'a')] <= 0) {
                return false;
            }
            chArr[(c - 'a')]--;
        }
        return true;
    }
}
