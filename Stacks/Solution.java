package Stacks;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for (int i = 0; i < t; i++) {
            int n = s.nextInt();
            int m = s.nextInt();
            int x = s.nextInt();
            List<Integer> a = new ArrayList<>();
            List<Integer> b = new ArrayList<>();
            for (int j = 0; j < n; j++)
                a.add(s.nextInt());
            for (int j = 0; j < m; j++)
                b.add(s.nextInt());
            System.out.println(twoStacks(x, a, b));
            s.close();
            /*
             * 1
             * 5 4 10
             * 4 2 4 6 1
             * 2 1 8 5
             */
        }
    }

    public static int twoStacks(int maxSum, List<Integer> a, List<Integer> b) {
        return helper(maxSum, a, b, 0, 0) - 1;
    }

    private static int helper(int maxSum, List<Integer> a, List<Integer> b, int sum, int count) {
        if (sum > maxSum) {
            return count;
        } else if (a.size() == 0) {
            return helper(maxSum, a, b.subList(1, b.size()), sum + b.get(0), count + 1);
        } else if (b.size() == 0) {
            return helper(maxSum, a.subList(1, a.size()), b, sum + a.get(0), count + 1);
        } else {
            int ans1 = helper(maxSum, a.subList(1, a.size()), b, sum + a.get(0), count + 1);
            int ans2 = helper(maxSum, a, b.subList(1, b.size()), sum + b.get(0), count + 1);
            return Math.max(ans1, ans2);
        }
    }
}
