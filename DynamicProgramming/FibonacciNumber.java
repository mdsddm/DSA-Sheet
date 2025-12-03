package DynamicProgramming;

/*  The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,
F(0) = 0, F(1) = 1
F(n) = F(n - 1) + F(n - 2), for n > 1.
Given n, calculate F(n).

Example 1:
Input: n = 2
Output: 1
Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.

Example 2:
Input: n = 3
Output: 2
Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.

Example 3:
Input: n = 4
Output: 3
Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.

Constraints:
0 <= n <= 30    */
public class FibonacciNumber {
    public static void main(String[] args) {
        System.out.println(fibTab(13));
    }

    // by memoization
    private static int fib(int n) {
        int[] m = new int[n + 1];
        return getFib(n, m);
    }

    private static int getFib(int n, int[] m) {
        if (n == 0 || n == 1) {
            return n;
        }
        if (m[n] != 0) { // already calculate
            return m[n];
        }
        // not calculate
        m[n] = getFib(n - 1, m) + getFib(n - 2, m);
        return m[n];
    }

    // by tabulation
    private static int fibTab(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        int[] dp = new int[n + 1];
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
