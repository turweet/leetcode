package beginer.dp;

/**
 * 本质上就是斐波那契数列
 */
public class ClimbStairs {
    /**
     * 此种方法会产生超时，时间复杂度超高
     * https://leetcode.com/problems/climbing-stairs/solution/
     *
     * @param n
     * @return
     */
    public int climbStairs_rec(int n) {
        return cs_recInner(0, n);
    }

    private int cs_recInner(int i, int n) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        return cs_recInner(i + 1, n) +
                cs_recInner(i + 2, n); //意为第i步之后还有多少种走法
    }


    /**
     * 利用备忘录记住，不会超时
     *
     * @param n
     * @return
     */
    public int climbStairs_rec_withMemo(int n) {
        int[] memo = new int[n + 1];
        return cs_recInner_withMemo(0, n, memo);
    }

    public int cs_recInner_withMemo(int i, int n, int[] memo) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        if (memo[i] > 0) {
            return memo[i];
        }
        memo[i] = cs_recInner_withMemo(i + 1, n, memo) +
                cs_recInner_withMemo(i + 2, n, memo);//爬到第i步之后还有多少种走法
        return memo[i];
    }

    public int climbStairs_withFib(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return climbStairs_withFib(n - 1)
                + climbStairs_withFib(n - 2);
    }

    public int climbStairs_withFib_better(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int result = -1;
        int left = 2;
        int right = 1;
        for (int i = 3; i <= n; i++) {
            result = left + right;
            right = left;
            left = result;
        }
        return result;
    }
}
