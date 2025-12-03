package RecursionAndBacktracking;

import java.util.ArrayList;
import java.util.List;

/*
The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.
Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a
queen and an empty space, respectively.

Example 1:
Input: n = 4
Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above

Example 2:
Input: n = 1
Output: [["Q"]]
 */
public class NQueen {
    public static void main(String[] args) {
        for (List<String> l : solveNQueens(4)) {
            for (String s : l) {
                for (String st : s.split("")) {
                    System.out.print(st + "  ");
                }
                System.out.println();
            }
            System.out.println();

        }

    }

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        // initializing board with (.)
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                board[i][j] = '.';
        solve(board, 0, ans);
        return ans;
    }

    public static void solve(char[][] board, int row, List<List<String>> ans) {
        if (row == board.length) {
            List<String> solution = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            for (char[] chars : board) {
                for (int j = 0; j < board.length; j++) {
                    sb.append(chars[j]);
                }
                solution.add(sb.toString());
                sb.delete(0, sb.length()); // for deleting
            }
            ans.add(solution);
        }
        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 'Q';
                solve(board, row + 1, ans);
                board[row][col] = '.';
            }
        }
    }

    public static boolean isSafe(char[][] board, int row, int col) {
        // checking for below column
        for (int i = row - 1; i >= 0; i--)
            if (board[i][col] == 'Q')
                return false;
        // checking for left upper diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 'Q')
                return false;
        // checking for right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++)
            if (board[i][j] == 'Q')
                return false;
        // finally
        return true;

    }
}
