package Array;
import java.util.ArrayList;
import java.util.List;
/*
Given an m x n matrix, return all elements of the matrix in spiral order.

Example 1:
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]

Example 2:
Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix ={{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        System.out.println(spiralOrder(matrix));

    }
    public static List<Integer> spiralOrder(int[][] matrix) {
        int stRow=0,stCol=0;
        int enRow=matrix.length-1;
        int enCol=matrix[0].length-1;
        List<Integer> tList = new ArrayList<>();
        while (stRow<=enRow && stCol<=enCol){
            // top
            for(int j=stCol;j<=enCol;j++)
                tList.add(matrix[stRow][j]);
            // right
            for(int i=stRow+1;i<=enRow;i++)
                tList.add(matrix[i][enCol]);
            // bottom
            if(stRow!=enRow)
                for(int j=enCol-1;j>=stCol;j--)
                    tList.add(matrix[enRow][j]);
            // left
            if(stCol!=enCol)
                for(int i=enRow-1;i>=stRow+1;i--)
                    tList.add(matrix[i][stCol]);
            stRow++;stCol++;enRow--;enCol--;
        }
        return tList;
    }
}
