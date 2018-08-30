package medium.array;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/spiral-matrix/description/
 */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if (matrix == null
                || matrix.length == 0
                || matrix[0] == null
                || matrix[0].length == 0) {
            return ans;
        }
        int row = matrix.length - 1;
        int col = matrix[0].length - 1;

        int i = 0;
        int totalCount = (row + 1) * (col + 1);
        while (ans.size() < totalCount) {
            add(ans, matrix, i, row - i, i, col - i);
            i++;
        }
        return ans;
    }

    private void add(List<Integer> list,
                     int[][] matrix,
                     int rowStart,
                     int rowEnd,
                     int colStart,
                     int colEnd) {
        int count = matrix.length * matrix[0].length;
        int rowPos = rowStart;
        int colPos = colStart;
        while (colPos <= colEnd) {
            list.add(matrix[rowPos][colPos]);
            colPos++;
        }
        if (list.size() >= count) {
            return;
        }
        colPos--;
        rowPos++;
        while (rowPos <= rowEnd) {
            list.add(matrix[rowPos][colPos]);
            rowPos++;
        }
        if (list.size() >= count) {
            return;
        }
        rowPos--;
        colPos--;
        while (colPos >= colStart) {
            list.add(matrix[rowPos][colPos]);
            colPos--;
        }
        if (list.size() >= count) {
            return;
        }
        colPos++;
        rowPos--;
        while (rowPos > rowStart) {
            list.add(matrix[rowPos][colPos]);
            rowPos--;
        }
    }

    public static void main(String[] args) {
        int[][] a = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        SpiralMatrix matrix = new SpiralMatrix();
        matrix.spiralOrder(a);
    }
}
