package Array;

/*
Given an array num of size n, return the majority element.
The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
Example 1:
Input: num = [3,2,3]
Output: 3
Example 2:
Input: num = [2,2,1,1,1,2,2]
Output: 2 */
public class MajortyElement {
    public static void main(String[] args) {
        int[] nums = {6, 5, 5};
        System.out.println(majorityElement(nums));
    }

    public static int majorityElement(int[] nums) {
        int n = nums.length;
        int currNum, preNum = nums[0], pCount = 0, cCount;
        for (int num : nums) {
            currNum = num;
            cCount = 0;
            for (int i : nums) {
                if (currNum == i) cCount++;
            }
            if (cCount > n / 2) return currNum;
            if (cCount > pCount) {
                pCount = cCount;
                preNum = currNum;
            }
        }
        return preNum;
    }

}
