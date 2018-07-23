package beginer.dp;

/**
 * On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).
 * <p>
 * Once you pay the cost, you can either climb one or two steps. You need to find minimum cost to reach the top of the floor, and you can either start from the step with index 0, or the step with index 1.
 * <p>
 * Example 1:
 * Input: cost = [10, 15, 20]
 * Output: 15
 * Explanation: Cheapest is start on cost[1], pay that cost and go to the top.
 * Example 2:
 * Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
 * Output: 6
 * Explanation: Cheapest is start on cost[0], and only step on 1s, skipping cost[3].
 * Note:
 * cost will have a length in the range [2, 1000].
 * Every cost[i] will be an integer in the range [0, 999].
 *
 *
 *
 * 做这个题先用递归写没有问题，之后就想用memo怎么做，一定要把图画出来转成和fib类似的问题就好做了
 */
public class MinCostClimbingStairs {
    /**
     * 递归法
     * <p>
     * 思路完全正确，但是超时了
     *
     * @param cost
     * @return
     */
    public int minCostClimbingStairs_rec(int[] cost) {
        return inner(cost, 0, 1);
    }

    public int inner(int[] cost, int s1, int s2) {
        int len = cost.length;
        if (s1 >= len || s2 >= len) {
            return 0;
        }
        if (s2 == len - 1) {
            return Math.min(cost[s2], cost[s2 - 1]);
        }
        if (s2 == len - 2) {
            return Math.min(cost[s2], cost[s2 - 1] + cost[s2 + 1]);
        }
        return Math.min(cost[s1] + inner(cost, s1 + 1, s1 + 2),
                cost[s2] + inner(cost, s2 + 1, s2 + 2));
    }


    /**
     * 递归with memo
     *
     * @param cost
     * @return
     */
    public int minCostClimbingStairs_memo(int[] cost) {
        int[] memo = new int[cost.length];
        for (int i = 0; i < memo.length; i++) {
            memo[i] = -1;
        }
        memoInner(cost, memo, 0);
        return Math.min(memo[0], memo[1]);
    }

    private int memoInner(int[] cost, int[] memo, int n) {
        int len = cost.length;
        if (n == len - 2 || n == len - 1) {
            return cost[n];
        }
        if (memo[n] != -1) {
            return memo[n];
        }
        memo[n] = cost[n] + Math.min(memoInner(cost, memo, n + 1),
                memoInner(cost, memo, n + 2));
        return memo[n];
    }


    public int minCostClimbingStairs_bottomUp(int[] cost) {
        int len = cost.length;
        int right = cost[len - 1];//attention 做这种fib类型的dp问题最好还是用left和right做临时变量会好些
        int left  = cost[len - 2];
        int cm = Math.min(left, right);
        for (int i = len - 3; i >=0 ; i--) {
            //attention 这里交换的顺序很重要，不能错
            cm = cost[i]+ Math.min(left, right);
            right = left;
            left = cm;
        }
        return Math.min(cm,right);//attention 因为有之前的交换，所以这应该和right比较才对
    }
}
