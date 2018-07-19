package medium.arraystring;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MatrixSetZeroes {
    /**
     * times:1
     * 竟然一次通过还打败了93.3%的人
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        int one = matrix.length;
        int two = matrix[0].length;
        Set<Integer> oneSet = new HashSet<>();
        Set<Integer> twoSet = new HashSet<>();
        for (int i = 0; i < one; i++) {
            for (int j = 0; j < two; j++) {
                if (matrix[i][j] == 0) {
                    oneSet.add(i);
                    twoSet.add(j);
                }
            }
        }
        Iterator<Integer> iterator = oneSet.iterator();
        while (iterator.hasNext()) {
            int temp = iterator.next();
            for (int i = 0; i < two; i++) {
                matrix[temp][i] = 0;
            }
        }
        iterator = twoSet.iterator();
        while (iterator.hasNext()) {
            int temp = iterator.next();
            for (int i = 0; i < one; i++) {
                matrix[i][temp] = 0;
            }
        }
    }
}
