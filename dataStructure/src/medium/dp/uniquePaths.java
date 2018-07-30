package medium.dp;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * <p>
 * The robot can only move either down or right at any point in time.
 * The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * <p>
 * How many possible unique paths are there?
 * <p>
 * <p>
 * Above is a 7 x 3 grid. How many possible unique paths are there?
 * <p>
 * Note: m and n will be at most 100.
 * <p>
 * Example 1:
 * <p>
 * Input: m = 3, n = 2
 * Output: 3
 * Explanation:
 * From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down
 * 2. Right -> Down -> Right
 * 3. Down -> Right -> Right
 * <p>
 * Example 2:
 * <p>
 * Input: m = 7, n = 3
 * Output: 28
 */
public class uniquePaths {
    private int M;
    private int N;

    public int uniquePaths_TimeLimit(int m, int n) {
        M = m;
        N = n;
        return inner(0, 0);
    }

    private int inner(int i, int j) {
        if (i < M - 1 && j < N - 1) {
            return inner(i + 1, j) + inner(i, j + 1);
        } else {
            return 1;
        }
    }


    public int uniquePaths_memo(int m, int n) {
        M = m;
        N = n;
        int[][] memo = new int[m][n];
        return inner_memo(0, 0, memo);
    }

    private int inner_memo(int i, int j, int[][] memo) {
        if (i < M - 1 && j < N - 1) {
            if (memo[i][j] != 0) {
                return memo[i][j];
            } else {
                int result = inner_memo(i + 1, j, memo) + inner_memo(i, j + 1, memo);
                memo[i][j] = result;
                return result;
            }
        } else {
            return 1;
        }
    }
}
