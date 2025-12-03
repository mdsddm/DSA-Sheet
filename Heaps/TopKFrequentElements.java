package Heaps;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*  347. Top K Frequent Elements
Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

Example 1:
Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]

Example 2:
Input: nums = [1], k = 1
Output: [1]

Constraints:
1 <= nums.length <= 105
-104 <= nums[i] <= 104
k is in the range [1, the number of unique elements in the array].
It is guaranteed that the answer is unique.
 */
public class TopKFrequentElements {
    public static void main(String[] args) {
        /*
        Input: nums = [1,1,1,2,2,3], k = 2
        Output: [1,2]
         */
        int[] nums = {1, 1, 1, 2, 2, 3};
        int[] ans = topKFrequent(nums, 2);
        System.out.println(Arrays.toString(ans));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> fm = new HashMap<>();

        // Iterate over the array of numbers
        for (int num : nums) {
            if (fm.containsKey(num)) {
                // If number is already in map, increment its frequency
                fm.put(num, fm.get(num) + 1);
            } else {
                // If number is not in map, add it with frequency 1
                fm.put(num, 1);
            }
        }
        PriorityQueue<Element> pq = new PriorityQueue<>();
        // inserting into priority queue
        for (Map.Entry<Integer, Integer> entry : fm.entrySet())
            pq.add(new Element(entry.getKey(), entry.getValue()));

        int[] result = new int[k];
        for (int i = 0; i < k && !pq.isEmpty(); i++)
            result[i] = pq.poll().num;
        return result;

    }
}

class Element implements Comparable<Element> {
    int num;
    int freq;

    public Element(int num, int freq) {
        this.num = num;
        this.freq = freq;
    }

    @Override
    public int compareTo(Element o) {
        return o.freq - this.freq;
    }
}
