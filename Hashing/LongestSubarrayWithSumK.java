package Hashing;

public class LongestSubarrayWithSumK {


    public static void main(String[] args) {
        int[] arr = {10, 2, -2, -20, 10};
        int k = -10;
        System.out.println(longestSubarray(arr, k));
    }

    private static int longestSubarray(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0, ans = 0;
        map.put(0, 1);                        // base for subarrays starting at 0 [2]

        for (int j = 0; j < arr.length; j++) {
            sum += arr[j];                    // prefix sum up to j [3]
            if (map.containsKey(sum - k))     // prior prefix completes sum k [3]
                ans += map.get(sum - k);      // add all such occurrences [3]
            int val = map.containsKey(sum) ? map.get(sum) : 0;
            map.put(sum, val+1);  // increment frequency [3][2]
        }


        return ans;
    }
}
