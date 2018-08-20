package medium.array;

/**
 * https://leetcode.com/problems/search-a-2d-matrix/description/
 */
public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int second = matrix[0].length - 1;
        return searchMatrix(matrix, target, 0, second); //注意这里从0开始的
    }

    private boolean searchMatrix(int[][] matrix, int target, int start1, int start2) {
        if (start1 < 0 || start1 >= matrix.length) {
            return false;
        }
        if (start2 < 0 || start2 >= matrix[0].length) {
            return false;
        }
        if (matrix[start1][start2] > target) {
            return searchMatrix(matrix, target, start1, start2 - 1);
        } else if (matrix[start1][start2] < target) {
            return searchMatrix(matrix, target, start1 + 1, start2);
        } else {
            return true;
        }
    }
}
