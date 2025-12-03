package DynamicProgramming;

public class UnboundedKnapsack {

    public static void main(String[] args) {
        // Input: W = 5, val[] = [10, 40, 30, 50], wt[] = [5, 4, 2, 3]
        int[] wt1 = { 5, 4, 2, 3 };
        int[] val1 = { 10, 40, 30, 50 };
        System.out.println("UnboundedKnapsack : " + unboundedKnapsack(6, val1, wt1));

    }

    private static int unboundedKnapsack(int W, int val[], int wt[]) {
        int n = val.length;
        int[][] dp = new int[n + 1][W + 1];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j <= W; j++) {
                int w = wt[i - 1];
                int v = val[i - 1];
                if (w <= j) { // if space available
                    int inc = v + dp[i][j - w];
                    int exc = dp[i - 1][j];
                    dp[i][j] = Math.max(inc, exc);

                } else { // space not available exclude
                    dp[i][j] = dp[i - 1][j];
                }

            }
        }
        return dp[n][W];
    }

}
