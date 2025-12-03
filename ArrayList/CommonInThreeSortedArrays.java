package ArrayList;

import java.util.ArrayList;
import java.util.List;

/*  Common in 3 Sorted Arrays
Given three sorted arrays in non-decreasing order, print all common elements in non-decreasing order across these arrays. If there are no such elements return an empty array. In this case, the output will be -1.
Note: can you handle the duplicates without using any additional Data Structure?

Examples :
Input: arr1 = [1, 5, 10, 20, 40, 80] , arr2 = [6, 7, 20, 80, 100] , arr3 = [3, 4, 15, 20, 30, 70, 80, 120]
Output: [20, 80]
Explanation: 20 and 80 are the only common elements in arr1, arr2 and arr3.

Input: arr1 = [1, 2, 3, 4, 5] , arr2 = [6, 7] , arr3 = [8,9,10]
Output: [-1]
Explanation: There are no common elements in arr1, arr2 and arr3.

Input: arr1 = [1, 1, 1, 2, 2, 2], arr2 = [1, 1, 2, 2, 2], arr3 = [1, 1, 1, 1, 2, 2, 2, 2]
Output: [1, 2]
Explanation: We do not need to consider duplicates

Constraints:
1 <= arr1.size(), arr2.size(), arr3.size() <= 105
-105 <= arr1i , arr2i , 1arr3i <= 105 */
public class CommonInThreeSortedArrays {
    public static void main(String[] args) {

    }

    private static List<Integer> commonElements(List<Integer> arr1, List<Integer> arr2, List<Integer> arr3) {
        List<Integer> ans = new ArrayList<>();
        int f = 0, s = 0, t = 0;
        while (f < arr1.size() && s < arr2.size() && t < arr3.size()) {
            int one = arr1.get(f);
            int two = arr2.get(s);
            int three = arr3.get(t);

            if (one == two && two == three) {
                ans.add(one);
                f++;
                s++;
                t++;
            } else if (one < two) {
                f++;
            } else if (two < three) {
                s++;
            } else {
                t++;
            }
        }
        return ans;
    }
}
