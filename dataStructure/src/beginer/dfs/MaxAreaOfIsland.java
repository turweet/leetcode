package beginer.dfs;

/**
 * https://leetcode.com/problems/max-area-of-island/description/
 */
public class MaxAreaOfIsland {
    private int first;
    private int second;

    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        first = grid.length - 1;
        second = grid[0].length - 1;
        for (int i = 0; i <= first; i++) {
            for (int j = 0; j <= second; j++) {
                int cur = dfs(grid, i, j);
                if (cur > max) {
                    max = cur;
                }
            }
        }
        return max;
    }

    private int dfs(int[][] grid, int f, int s) {
        if (f < 0 || f > first || s < 0 || s > second) {
            return 0;
        }
        if (grid[f][s] > 0) {
            grid[f][s] = 0; // 需要先置为0再return，而不能先return再置为0
            return 1 +
                    dfs(grid, f + 1, s) +
                    dfs(grid, f - 1, s) +
                    dfs(grid, f, s + 1) +
                    dfs(grid, f, s - 1);
        }
        return 0;
    }
}
