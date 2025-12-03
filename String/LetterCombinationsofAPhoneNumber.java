package String;

import java.util.ArrayList;
import java.util.List;

/*  17. Letter Combinations of a Phone Number
Given a string containing digits from 2-9 inclusive, return all possible letter combinations 
that the number could represent. Return the answer in any order.A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 
does not map to any letters.

Example 1:
Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

Example 2:
Input: digits = "2"
Output: ["a","b","c"]

Constraints:
1 <= digits.length <= 4
digits[i] is a digit in the range ['2', '9'].   */
public class LetterCombinationsofAPhoneNumber {
    public static void main(String[] args) {
        System.out.println(letterCombinations("234"));
    }

    static String[] com = { "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
    static List<String> ans = new ArrayList<>();

    private static List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return ans;
        }
        StringBuilder sb = new StringBuilder();
        helper(0, sb, digits);
        return ans;
    }

    static void helper(int i, StringBuilder cur, String digits) {
        if (i >= digits.length()) {
            ans.add(cur.toString());
            return;
        }
        int n = digits.charAt(i) - '2';
        String str = com[n];
        for (int j = 0; j < str.length(); j++) {
            cur.append(str.charAt(j));
            helper(i + 1, cur, digits);
            cur.deleteCharAt(cur.length() - 1);
        }
    }

}
