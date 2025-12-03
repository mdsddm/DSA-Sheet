package String;

import java.util.ArrayList;
import java.util.HashSet;

public class UniqueSubstring {
    public static void main(String[] args) {
        String str = "saddam";
        System.out.println(findLongestUniqueSubstrings(str));
    }

    public static ArrayList<String> findLongestUniqueSubstrings(String str) {
        ArrayList<String> result = new ArrayList<>();
        HashSet<Character> window = new HashSet<>();
        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < str.length(); right++) {
            char currentChar = str.charAt(right);

            while (window.contains(currentChar)) {
                window.remove(str.charAt(left));
                left++;
            }
            window.add(currentChar);

            int currentLength = right - left + 1;

            if (currentLength > maxLength) {
                maxLength = currentLength;
                result.clear();
                result.add(str.substring(left, right + 1));
            }

            else if (currentLength == maxLength) {
                result.add(str.substring(left, right + 1));
            }
        }
        return result;
    }
}