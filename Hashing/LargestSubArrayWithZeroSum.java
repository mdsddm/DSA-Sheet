package Hashing;

public class LargestSubArrayWithZeroSum {
    public static void main(String[] args) {
        int[] nums = {15, -2, 2, -8, 1, 7, 10, 23}; //ans : 5  {-2,2,-8,1,7}
        System.out.println(maxLength(nums));
    }

    private static int maxLength(int[] arr) {
        int len = 0;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum)) // if contains key
                len = Math.max(len, i - map.get(sum));
            else
                map.put(sum, i);
        }
        return len;
    }
}
