package ProfJahir;

/*
write a program to compute binomial coefficient n c r
i) by using divide and conquer

   by using dynamic programming
ii ) by using 2-d array of size n+1 X n+1
iii ) by using 2-d array of tri angular type
iv ) by using trapezium
v ) single 1-d array

 */
public class BinomialCoefficient {
    public static void main(String[] args) {
        System.out.println("by using divide and conquer : ");
        System.out.println(bin(5, 2));
        System.out.println("by using 2-d array of size n+1 X n+1");
        System.out.println(binTwoDim(5, 2));
        System.out.println("by using 2-d array of tri angular type");
        System.out.println(binTri(5, 2));
        System.out.println("by using trapezium");
        System.out.println(binTrap(5, 2));
        System.out.println("single 1-d array");
        System.out.println(binOneDim(12, 6));
    }

    // by using divide and conquer
    public static int bin(int n, int k) {
        if (k == 0 || k == n) {
            return 1;
        } else {
            return bin(n - 1, k - 1) + bin(n - 1, k);
        }
    }

    // by using 2-d array of size n+1 X n+1
    public static int binTwoDim(int n, int k) {
        int[][] b = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    b[i][j] = 1;
                } else {
                    b[i][j] = b[i - 1][j - 1] + b[i - 1][j];
                }
            }
        }
        return b[n][k];
    }

    // by using 2-d array of tri angular type
    public static int binTri(int n, int k) {
        int[][] b = new int[n + 1][];
        // creating tri angular matrix
        for (int a = 0; a <= n; a++) {
            b[a] = new int[a + 1];
        }

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < b[i].length; j++) {
                if (j == 0 || j == i) {
                    b[i][j] = 1;
                } else {
                    b[i][j] = b[i - 1][j - 1] + b[i - 1][j];
                }
            }
        }
        return b[n][k];
    }

    // by using trapezium
    public static int binTrap(int n, int k) {
        int[][] b = new int[n + 1][];
        // creating tri angular matrix
        for (int a = 0; a <= n; a++) {
            b[a] = new int[Math.min(a, k) + 1];
        }
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < b[i].length; j++) {
                if (j == 0 || j == i) {
                    b[i][j] = 1;
                } else {
                    b[i][j] = b[i - 1][j - 1] + b[i - 1][j];
                }
            }
        }
        return b[n][k];
    }

    // single 1-d array
    public static int binOneDim(int n, int k) {
        if (k < 0 || k > n) return 0;
        int[] b = new int[k + 1];
        b[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = Math.min(i, k); j > 0; j--) {
                b[j] += b[j - 1];
            }
        }
        return b[k];
    }
}
