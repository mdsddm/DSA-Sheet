package DynamicProgramming;

public class TargetSumZeroOneKanpsack {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 4, 5 };
        int target = 13;
        System.out.println(targetSum(nums, target));
    }

    private static boolean targetSum(int[] nums, int target) {
        int n = nums.length;
        boolean[][] dp = new boolean[n + 1][target + 1];
        // for all numbers when target sum is 0, it's always true
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= n; i++) {
            int v = nums[i - 1];
            for (int j = 1; j <= target; j++) { // include condition
                if (v <= j && dp[i - 1][j - v] == true) {
                    dp[i][j] = true;

                } // exclude condition
                else if (dp[i - 1][j]) {
                    dp[i][j] = true;
                }
            }
        }
        return dp[n][target];

    }
}
