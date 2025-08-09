package ProfJahir;


import java.util.Arrays;

public class PermutationRecursive {
    private static void getNextPer(int[] nums, int start) {
        if (start == nums.length) {
            // printing permutation
            System.out.println(Arrays.toString(nums));
        } else {
            for (int i = start; i < nums.length; i++) {
                swap(nums, start, i);
                getNextPer(nums, start + 1);
                swap(nums, start, i); // backtrack
            }
        }
    }

    // method to swap
    private static void swap(int[] nums, int i, int j) {
        int dummy = nums[i];
        nums[i] = nums[j];
        nums[j] = dummy;
    }

    public static void main(String[] args) {
        int[] input = {1, 2, 3};
        getPer(input);

    }
    // this method will print time
    public static void getPer(int[] input) {
        long start = System.nanoTime(); // or System.currentTimeMillis()


        getNextPer(input, 0);


        long end = System.nanoTime();
        long durationMs = (end - start) / 1_000_000;
        System.out.println("\nProgram executed in " + durationMs + " ms");

    }
}
