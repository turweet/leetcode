package beginer.array;


import org.junit.Assert;
import org.junit.Test;

/**
 * 这个题可以买卖多次
 */
public class MaxProfit {

    public int maxProfit(int[] prices) {
        int result = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] > prices[i]) {
                result += prices[i + 1] - prices[i];
            }
        }
        return result;
    }

    public int maxProfit_bruteForce(int[] prices) {
        return calculate(prices, 0);
    }

    private int calculate(int prices[], int s) {
        if (s >= prices.length)
            return 0;
        int max = 0;
        for (int start = s; start < prices.length; start++) {
            int maxProfit = 0;
            for (int i = start + 1; i < prices.length; i++) {
                if (prices[start] < prices[i]) {
                    int profit = calculate(prices, i + 1) + prices[i] - prices[start];
                    if (profit > maxProfit)
                        maxProfit = profit;
                }
            }
            if (maxProfit > max)
                max = maxProfit;
        }
        return max;
    }

    /**
     * 找到每一个谷值和对应的峰值，然后用峰值减去谷值，再把这些结果相加
     * 你看这里就没有考虑，不能连续买入卖出的问题
     * @param prices
     * @return
     */
    public int maxProfit_vallyPeak(int[] prices) {
        int vally;
        int peak;
        int maxProfit = 0;
        for (int i = 0; i < prices.length - 1; ) {
            for (; i < prices.length - 1 && prices[i] >= prices[i + 1]; i++) { //找到下一个vally点

            }
            vally = prices[i];
            for (; i < prices.length - 1 && prices[i] <= prices[i + 1]; i++) { //找到下一个peak点

            }
            peak = prices[i];
            maxProfit += peak - vally;
        }
        return maxProfit;
    }

    @Test
    public void test() {
        int prices[] = {1, 7, 2, 3, 6, 7, 6, 7};
        int result = 12;
        Assert.assertEquals(result, maxProfit(prices));
    }
}
//注意：
//1. 这里可以选择不交易
//2. 注意传进来的数组为长度0的情况

//思路：
//感觉这个题应该自己多举一些例子，然后发现最后的最大利润就是直接让相邻增长的做减法再加起来就好了
//也许凭空想象这个有点难度，但是举些例子应该就好说了

//坑：
//一开始思考这个题的时候，想的是先找出买入卖出的时机，这个不好找，觉得根本没有思路，所以没有做出来
//结果只是需要考虑能赚多少钱就好了，不需要考虑买入卖出时机
//还有那个不能连续买入卖出的规定有点唬人，其实这个规则并没有那么重要

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/solution/