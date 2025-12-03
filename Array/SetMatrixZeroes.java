package Array;

/*73. Set Matrix Zeroes
Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
You must do it in place.

Example 1:
Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
Output: [[1,0,1],[0,0,0],[1,0,1]]

Example 2:
Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 
Constraints:
m == matrix.length
n == matrix[0].length
1 <= m, n <= 200
-231 <= matrix[i][j] <= 231 - 1 */
public class SetMatrixZeroes {
    public static void main(String[] args) {
        int[][] matrix = { { 0, 1, 2, 0 }, { 3, 4, 5, 2 }, { 1, 3, 1, 5 } };
        setZeroes(matrix);
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + "  ");
            }
            System.out.println();
        }
    }

    private static void setZeroes(int[][] matrix) {
        boolean[][] isVis = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0 && isVis[i][j] == false) {
                    set(matrix, isVis, i, j);
                }
            }
        }
    }

    private static void set(int[][] matrix, boolean[][] isVis, int row, int col) {
        // top
        for (int i = 0; i < row; i++) {
            if (matrix[i][col] != 0) {
                isVis[i][col] = true;
                matrix[i][col] = 0;
            }
        }
        // right
        for (int j = col + 1; j < matrix[0].length; j++) {
            if (matrix[row][j] != 0) {
                isVis[row][j] = true;
                matrix[row][j] = 0;
            }
        }
        // bottom
        for (int i = row + 1; i < matrix.length; i++) {
            if (matrix[i][col] != 0) {
                isVis[i][col] = true;
                matrix[i][col] = 0;
            }
        }
        // left
        for (int j = 0; j < col; j++) {
            if (matrix[row][j] != 0) {
                isVis[row][j] = true;
                matrix[row][j] = 0;
            }
        }

    }
}
