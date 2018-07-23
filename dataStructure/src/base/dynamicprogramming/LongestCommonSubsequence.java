package base.dynamicprogramming;

import org.junit.Assert;
import org.junit.Test;

/**
 * 首先得写出递归公式
 * 这个可以类似于fib那样画出分叉图，然后会发现有重复计算的，这时就知道怎么做了(一定得先画出分叉图之后就知道那里重复了就知道怎么用memo了)
 * 同样，画了分叉图之后就知道从底向上怎么算了
 * 来源：https://www.youtube.com/watch?v=Qf5R-uYQRPk&index=4&list=PLBZBJbE_rGRU5PrgZ9NBHJwcaZsNpf8yD&t=235s
 */
public class LongestCommonSubsequence {
    /**
     * 递归方式实现
     *
     * @param a
     * @param b
     * @return
     */
    public int longestCommonSubsequence_rec(char[] a, char[] b) {
        return inner_rec(a, b, a.length - 1, b.length - 1);
    }

    private int inner_rec(char[] a, char[] b, int n, int m) {
        if (n < 0 || m < 0) {
            return 0;
        }
        if (a[n] == b[m]) {
            return 1 + inner_rec(a, b, n - 1, m - 1);
        }
        return Math.max(inner_rec(a, b, n - 1, m),
                inner_rec(a, b, n, m - 1));
    }

    /**
     * 依靠递归和memo
     *
     * @param a
     * @param b
     * @return
     */
    public int longestCommonSubsequence_memo(char[] a, char[] b) {
        int[][] memo = new int[a.length][b.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                memo[i][j] = -1;
            }
        }
        return inner_memo(memo, a, b, a.length - 1, b.length - 1);
    }

    private int inner_memo(int[][] memo, char[] a, char[] b, int n, int m) {
        if (n < 0 || m < 0) {
            return 0;
        }
        if (memo[n][m] != -1) return memo[n][m];
        if (a[n] == b[m]) {
            memo[n][m] = 1 + inner_rec(a, b, n - 1, m - 1);
        } else {
            memo[n][m] = Math.max(inner_rec(a, b, n - 1, m),
                    inner_rec(a, b, n, m - 1));
        }
        return memo[n][m];
    }

    @Test
    public void test() {
        char[] a = {'A', 'C', 'D', 'F', 'E', 'G'};
        char[] b = {'A', 'B', 'D', 'E'};
        Assert.assertEquals(3, longestCommonSubsequence_rec(a, b));
        Assert.assertEquals(3, longestCommonSubsequence_memo(a, b));

        char[] a1 = {'A', 'A'};
        char[] b1 = {'B', 'B', 'B'};
        Assert.assertEquals(0, longestCommonSubsequence_rec(a1, b1));
        Assert.assertEquals(0, longestCommonSubsequence_memo(a1, b1));

        char[] a2 = {'A', 'A'};
        char[] b2 = {'A', 'A'};
        Assert.assertEquals(2, longestCommonSubsequence_rec(a2, b2));
        Assert.assertEquals(2, longestCommonSubsequence_memo(a2, b2));
    }

}
