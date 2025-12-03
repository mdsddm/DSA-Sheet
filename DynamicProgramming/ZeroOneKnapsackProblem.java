package DynamicProgramming;

/*  0 - 1 Knapsack Problem
Given n items, each with a specific weight and value, and a knapsack with a capacity of W, the task is to put the items in the knapsack such that the sum of weights of the items <= W and the sum of values associated with them is maximized. 
Note: You can either place an item entirely in the bag or leave it out entirely. Also, each item is available in single quantity.

Examples :

Input: W = 4, val[] = [1, 2, 3], wt[] = [4, 5, 1] 
Output: 3
Explanation: Choose the last item, which weighs 1 unit and has a value of 3.

Input: W = 3, val[] = [1, 2, 3], wt[] = [4, 5, 6] 
Output: 0
Explanation: Every item has a weight exceeding the knapsack's capacity (3).

Input: W = 5, val[] = [10, 40, 30, 50], wt[] = [5, 4, 2, 3] 
Output: 80
Explanation: Choose the third item (value 30, weight 2) and the last item (value 50, weight 3) for a total value of 80.

Constraints:
2 ≤ val.size() = wt.size() ≤ 103
1 ≤ W ≤ 103
1 ≤ val[i] ≤ 103
1 ≤ wt[i] ≤ 103 */
public class ZeroOneKnapsackProblem {
    public static void main(String[] args) {
        // Input: W = 5, val[] = [10, 40, 30, 50], wt[] = [5, 4, 2, 3]
        int[] wt1 = { 5, 4, 2, 3 };
        int[] val1 = { 10, 40, 30, 50 };
        System.out.println("Using Recursion : " + knapsackRecursion(5, val1, wt1));
        int[] wt2 = { 5, 4, 2, 3 };
        int[] val2 = { 10, 40, 30, 50 };
        System.out.println("Using Memoization : " + knapsackMemoization(5, val2, wt2));
        int[] wt3 = { 5, 4, 2, 3 };
        int[] val3 = { 10, 40, 30, 50 };
        System.out.println("Using Tabulation : " + knapsackTabulation(5, val3, wt3));

    }

    // Using Recursion
    private static int knapsackRecursion(int W, int val[], int wt[]) {
        return knapRecur(val, wt, W, wt.length);
    }

    private static int knapRecur(int[] val, int[] wt, int w, int n) {
        if (w == 0 || n == 0) { // base case
            return 0;
        }
        if (wt[n - 1] <= w) {
            // include
            int ans1 = val[n - 1] + knapRecur(val, wt, w - wt[n - 1], n - 1);
            // exclude
            int ans2 = knapRecur(val, wt, w, n - 1);
            return Math.max(ans1, ans2);
        } else {// exclude
            return knapRecur(val, wt, w, n - 1);
        }

    }

    // Using Memoization
    private static int knapsackMemoization(int W, int val[], int wt[]) {
        int n = wt.length;
        int[][] dp = new int[n + 1][W + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        return knapMemo(val, wt, dp, W, n);
    }

    private static int knapMemo(int[] val, int[] wt, int[][] dp, int w, int n) {
        if (w == 0 || n == 0) { // base case
            return 0;
        }
        if (dp[n][w] != -1) {
            return dp[n][w];
        }
        if (wt[n - 1] <= w) {
            // include
            int ans1 = val[n - 1] + knapMemo(val, wt, dp, w - wt[n - 1], n - 1);
            // exclude
            int ans2 = knapMemo(val, wt, dp, w, n - 1);
            dp[n][w] = Math.max(ans1, ans2);
            return dp[n][w];
        } else {// exclude
            dp[n][w] = knapMemo(val, wt, dp, w, n - 1);
            return dp[n][w];
        }
    }

    private static void print(int[][] dp) {
        for (int[] is : dp) {
            for (int is2 : is) {
                System.out.printf("%5d", is2);
            }
            System.out.println();
        }
        System.out.println();
    }

    private static int knapsackTabulation(int W, int val[], int wt[]) {
        int n = val.length;
        int[][] dp = new int[n + 1][W + 1];
        // there is no need for initializing first row and first column
        // for (int i = 0; i < n; i++) {
        // dp[i][0] = 0;
        // dp[0][i] = 0;
        // }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j <= W; j++) {
                int w = wt[i - 1];
                int v = val[i - 1];
                if (w <= j) { // if space available
                    int inc = v + dp[i - 1][j - w];
                    int exc = dp[i - 1][j];
                    dp[i][j] = Math.max(inc, exc);

                } else { // space not available exclude
                    dp[i][j] = dp[i - 1][j];
                }

            }
        }
        print(dp);
        return dp[n][W];
    }
}
