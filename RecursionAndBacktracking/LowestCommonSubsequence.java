package RecursionAndBacktracking;

import java.util.*;

public class LowestCommonSubsequence {
    // compute LCS length (DP)
    static int computeLcsLength(String X, String Y) {
        int m = X.length(), n = Y.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (X.charAt(i - 1) == Y.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[m][n];
    }

    // isPromising check from slide
    static boolean isPromising(int i, int j, int k, int m, int n, int L) {
        if (k == L - 1)
            return true;
        int leftX = m - (i + 1);
        int leftY = n - (j + 1);
        int need = L - (k + 1);
        return !(leftX < need || leftY < need);
    }

    // backtracking to print/all LCS (matches slide pseudocode)
    static void print_All_LCS(String X, String Y, int i, int j, int k,
            int m, int n, int L, char[] current, Set<String> out) {
        if (!isPromising(i, j, k, m, n, L))
            return;
        if (k == L - 1) {
            out.add(new String(current));
            return;
        }
        for (int ii = i + 1; ii < m; ii++) {
            for (int jj = j + 1; jj < n; jj++) {
                if (X.charAt(ii) == Y.charAt(jj)) {
                    current[k + 1] = X.charAt(ii);
                    print_All_LCS(X, Y, ii, jj, k + 1, m, n, L, current, out);
                }
            }
        }
    }

    public static void main(String[] args) {
        String X = "adce";
        String Y = "bdec";

        int m = X.length(), n = Y.length();
        int L = computeLcsLength(X, Y);
        Set<String> result = new LinkedHashSet<>();
        if (L > 0) {
            char[] current = new char[L];
            print_All_LCS(X, Y, -1, -1, -1, m, n, L, current, result);
        }

        System.out.println("LCS length = " + L);
        for (String s : result)
            System.out.println(s);
    }
}
