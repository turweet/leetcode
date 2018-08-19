package medium.graph;

/**
 * https://leetcode.com/problems/number-of-islands/description/
 */
public class NumberofIslands {

    /**
     * 遇到1就给岛的数量加1，然后把所有联通的陆地都置为0
     *
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int result = 0;
        int items = grid.length;
        int itemCounts = grid[0].length;
        for (int i = 0; i < items; i++) {
            for (int j = 0; j < itemCounts; j++) {
                if (grid[i][j] == '1') {
                    result++;
                    dfs(grid, i, j, items - 1, itemCounts - 1);// 这里的边界忘记减一了
                }
            }
        }
        return result;
    }

    private void dfs(char[][] grid, int start1, int start2, int bound1, int bound2) {
        if (start1 >= 0 && start2 >= 0 && start1 <= bound1 && start2 <= bound2) {
            if (grid[start1][start2] == '1') {
                grid[start1][start2] = '0';
                dfs(grid, start1 + 1, start2, bound1, bound2); //递归应该写在为1的里边
                dfs(grid, start1, start2 + 1, bound1, bound2);
                dfs(grid, start1 - 1, start2, bound1, bound2);
                dfs(grid, start1, start2 - 1, bound1, bound2);
            }
        }
    }
}
