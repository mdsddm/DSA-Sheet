package RecursionAndBacktracking;

/*  37. Sudoku Solver
Write a program to solve a Sudoku puzzle by filling the empty cells.
A sudoku solution must satisfy all the following rules:
Each of the digits 1-9 must occur exactly once in each row.
Each of the digits 1-9 must occur exactly once in each column.
Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
The '.' character indicates empty cells.
Example 1:
Input: board = [["5","3",".",".","7",".",".",".","."]
               ,["6",".",".","1","9","5",".",".","."],
                [".","9","8",".",".",".",".","6","."],
                ["8",".",".",".","6",".",".",".","3"],
                ["4",".",".","8",".","3",".",".","1"],
                ["7",".",".",".","2",".",".",".","6"],
                [".","6",".",".",".",".","2","8","."],
                [".",".",".","4","1","9",".",".","5"],
                [".",".",".",".","8",".",".","7","9"]]
Output: [["5","3","4","6","7","8","9","1","2"],
         ["6","7","2","1","9","5","3","4","8"],
         ["1","9","8","3","4","2","5","6","7"],
         ["8","5","9","7","6","1","4","2","3"],
         ["4","2","6","8","5","3","7","9","1"],
         ["7","1","3","9","2","4","8","5","6"],
         ["9","6","1","5","3","7","2","8","4"],
         ["2","8","7","4","1","9","6","3","5"],
         ["3","4","5","2","8","6","1","7","9"]]
Explanation: The input board is shown above and the only valid solution is shown below:
 */
public class Sudoku {
    public static void main(String[] args) {
        char a = '5';
        int b = Character.getNumericValue(a);
        System.out.println("ooo: "+b);

        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        solveSudoku(board);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++)
                System.out.print(board[i][j] + " ");
            System.out.println();
        }

    }

    public static void solveSudoku(char[][] board) {
        sudokuSolver(board, 0, 0);
    }

    public static boolean isSafe(char[][] board, int row, int col, int digit) {
        // row
        for (int i = 0; i < 9; i++)
            if (board[i][col] == (char) ('0' + digit)) return false;
        // column
        for (int j = 0; j < 9; j++)
            if (board[row][j] == (char) ('0' + digit)) return false;
        // grid
        int sr = (row / 3) * 3;
        int sc = (col / 3) * 3;
        for (int i = sr; i < sr + 3; i++)
            for (int j = sc; j < sc + 3; j++)
                if (board[i][j] == (char) ('0' + digit)) return false;
        // finally
        return true;
    }

    public static boolean sudokuSolver(char[][] board, int row, int col) {
        if (row == 9) {
            return true;
        }
        int nRow = row, nCol = col + 1;
        if (nCol == 9) {
            nRow++;
            nCol = 0;
        }
        if (board[row][col] != '.') {
            return sudokuSolver(board, nRow, nCol);
        }
        for (int digit = 1; digit <= 9; digit++) {
            if (isSafe(board, row, col, digit)) {
                board[row][col] = (char) ('0' + digit);
                // checking for next column
                if (sudokuSolver(board, nRow, nCol)) return true;
                // backtracking if solution not found again set '.'
                board[row][col] = '.';
            }
        }
        return false;
    }
}
