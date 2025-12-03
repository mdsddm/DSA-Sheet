package Array;

/*
 You are given a 0-indexed 2D integer matrix grid of size n * n with values in the range [1, n2]. Each integer appears exactly once except a which appears twice and b which is missing. The task is to find the repeating and missing numbers a and b.

Return a 0-indexed integer array answer of size 2 where ans[0] equals to a and ans[1] equals to b.



Example 1:

Input: grid = [[1,3],[2,2]]
Output: [2,4]
Explanation: Number 2 is repeated and number 4 is missing so the answer is [2,4].
Example 2:

Input: grid = [[9,1,7],[8,9,2],[3,4,6]]
Output: [9,5]
Explanation: Number 9 is repeated and number 5 is missing so the answer is [9,5]. */
public class FindMissingRepeatNum {
    public static void main(String[] args) {
        long start = System.nanoTime(); // or System.currentTimeMillis()

        // Your program logic here
        int[][] grid = {{9, 1, 7}, {8, 9, 2}, {3, 4, 6}};
        int[] ans = findMissingAndRepeatedValues(grid);
        for (int a : ans)
            System.out.print(a + " ");

        long end = System.nanoTime();
        long durationMs = (end - start) / 1_000_000;
        System.out.println("\nProgram executed in " + durationMs + " ms");

    }

    public static int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int size = n * n;
        int[] count = new int[size + 1];

        for (int[] ints : grid) {
            for (int j = 0; j < n; j++) {
                count[ints[j]]++;
            }
        }

        int a = -1, b = -1;

        for (int num = 1; num <= size; num++) {
            if (count[num] == 2) {
                a = num;
            } else if (count[num] == 0) {
                b = num;
            }
        }

        return new int[]{a, b};
    }
}
