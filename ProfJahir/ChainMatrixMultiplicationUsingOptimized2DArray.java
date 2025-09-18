package ProfJahir;

public class ChainMatrixMultiplicationUsingOptimized2DArray {

    public static int minMul(int[] d, int[][] P, int n) {
        // M[i][j] will store the minimum multiplication cost for matrices i.j
        int[][] M = new int[n + 1][n + 1];

        // Base case: cost of multiplying one matrix is zero
        for (int i = 1; i <= n; i++) {
            M[i][i] = 0;
        }

        // diagonal = chain length - 1 (number of gaps in i and j)
        for (int diagonal = 1; diagonal < n; diagonal++) {
            for (int i = 1; i <= n - diagonal; i++) {
                int j = i + diagonal;   // Ending matrix index

                // Initial splitting at i (first possible split)
                M[i][j] = M[i + 1][j] + d[i - 1] * d[i] * d[j];
                P[i][j] = i;

                // Now try all possible splits k in  i and j
                for (int k = i + 1; k < j; k++) {
                    // cost if we split at k → (Ai..Ak) x (A(k+1)..Aj)
                    int q = M[i][k] + M[k + 1][j] + d[i - 1] * d[k] * d[j];

                    // If this cost is smaller, update optimal cost and split
                    if (q < M[i][j]) {
                        M[i][j] = q;
                        P[i][j] = k;
                    }
                }
            }
        }
        System.out.println("   Multiplication Matrix->");
        for (int[] row : M) {
            for (int num : row) {
                System.out.printf("%4d", num);
            }
            System.out.println();
        }
        return M[1][n]; // Minimum cost for multiplying A1.An
    }


    public static void order(int i, int j, int[][] P) {
        if (i == j) {
            // Single matrix: just print its name (A, B, C, ...)
            System.out.print((char) ('A' + i - 1));
        } else {
            int k = P[i][j]; // Optimal split position
            System.out.print("(");
            order(i, k, P);    // Parenthesize left part
            order(k + 1, j, P); // Parenthesize right part
            System.out.print(")");
        }
    }

    public static void main(String[] args) {
        // Matrix chain dimensions:
        // Matrix A1 = 5x2, A2 = 2x3, A3 = 3x4, A4 = 4x6
        int[] d = {5, 2, 3, 4, 6};
        int n = d.length - 1; // Number of matrices (d has n+1 values)

        // To store optimal split points
        int[][] P = new int[n + 1][n + 1];

        // Compute minimum cost
        int minCost = minMul(d, P, n);
        System.out.println("Minimum number of multiplications: " + minCost);

        // Print optimal parenthesization
        System.out.print("Optimal Parenthesization: ");
        order(1, n, P);
    }
}
