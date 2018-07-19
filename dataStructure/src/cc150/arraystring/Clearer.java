package cc150.arraystring;


import java.util.ArrayList;
import java.util.List;

/**
 * 题目描述
 * <p>
 * 请编写一个算法，若N阶方阵中某个元素为0，则将其所在的行与列清零。
 * <p>
 * 给定一个N阶方阵int[][](C++中为vector<vector><int>>)mat和矩阵的阶数n，请返回完成操作后的int[][]方阵(C++中为vector<vector><int>>)，保证n小于等于300，矩阵中的元素为int范围内。</int></vector></int></vector>
 * 测试样例：
 * <p>
 * [[1,2,3],[0,1,2],[0,0,1]]
 * <p>
 * 返回：[[0,0,3],[0,0,0],[0,0,0]]
 */
public class Clearer {
    // wrongpoint
    /**
     * 直接在遍历过程中将所在行列置0是个陷阱，导致所以元素都为0了
     *
     * @param mat
     * @param n
     * @return
     */
    public int[][] clearZero(int[][] mat, int n) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    int[] ints = {i, j};
                    list.add(ints);
                }
            }
        }
        for (int[] p :
                list) {
            for (int i = 0; i < n; i++) {
                mat[p[0]][i] = 0;
                mat[i][p[1]] = 0;
            }
        }
        return mat;
    }

    /**
     * 找到0元素所在的行和列保存下来，之后对其置0
     * @param mat
     * @param n
     * @return
     */
    public int[][] clearZero2(int[][] mat, int n) {
        List<Integer> rows = new ArrayList<>();
        List<Integer> colums = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    rows.add(i);
                    colums.add(j);
                }
            }
        }
        for (int i :
                rows) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = 0;
            }
        }
        for (int i :
                colums) {
            for (int j = 0; j < n; j++) {
                mat[j][i] = 0;
            }
        }
        return mat;
    }
}
