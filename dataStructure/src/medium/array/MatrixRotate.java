package medium.array;

/**
 * 通用的旋转说明：
 * https://leetcode.com/problems/rotate-image/discuss/18872/A-common-method-to-rotate-the-image
 */

public class MatrixRotate {
    public void rotate(int[][] matrix) {
        int count = matrix.length;
        for (int i = 0; i < count; i++) {
            for (int j = i; j < count; j++) {   //注意这里j是从i开始的
                exchange(matrix, getIntArray(i, j, 2),
                        getIntArray(j, i, 2));
            }
        }

        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count / 2; j++) {
                exchange(matrix, getIntArray(i, j, 2),
                        getIntArray(i, count - j - 1, 2));
            }
        }
    }

    private int[] getIntArray(int a, int b, int size) {
        int[] array = new int[size];
        array[0] = a;
        array[1] = b;
        return array;
    }

    private void exchange(int[][] matrix, int[] one, int[] two) {
        int a = one[0];
        int b = one[1];

        int i = two[0];
        int j = two[1];

        int temp = matrix[a][b];
        matrix[a][b] = matrix[i][j];
        matrix[i][j] = temp;
    }
}
