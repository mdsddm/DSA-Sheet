package Array;
/*
Write an efficient algorithm that searches for a value target in an m x n integer matrix.
This matrix has the following properties:
Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.

Example 1:
Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
Output: true

Example 2:
Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
Output: false
 */
public class SearchIn2DArray2 {
    public static void main(String[] args) {
        int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        System.out.println(searchMatrix(matrix,20));
    }
    public static boolean searchMatrix(int[][] matrix, int target) {
        // storing length of row and column
        int m= matrix.length-1;
        int n= matrix[0].length-1;
        // variable to determined
        int x=m,y=0;
        while(x>=0 && y<=n) // condition
        {
            // found
            if(matrix[x][y]==target)
                return true;
            // target is small
            else if (matrix[x][y]>target)
                x--;
            else
                y++;
        }
        return false;
    }
}
