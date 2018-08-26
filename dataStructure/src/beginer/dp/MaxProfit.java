package beginer.dp;

/**
 * 只允许交易一次
 */
public class MaxProfit {

    /**
     * 因为只允许交易一次，所以最简单的就是直接两层循环搞定
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] - prices[i] > max) {
                    max = prices[j] - prices[i];
                }
            }
        }
        return max;
    }

    /**
     * 在一遍遍历的过程中不断更换最小值，在过程中用后边的值减去最小值做计算得到最大利润
     *
     * 其实这个也是双指针，一个指针向前走，一个指针指向当前最大值
     *
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int minPrice = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
            if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }


    public int myDp(int[] prices) {
        return mp(prices, 0);
    }

    private int mp(int[] prices, int start) {
        if (start >= prices.length - 1) {
            return 0;
        }
        return Math.max(maxInArray(prices, start + 1) - prices[start],
                mp(prices, start + 1));
    }

    private int maxInArray(int[] price, int start) {
        int max = price[start];
        for (int i = start + 1; i < price.length; i++) {
            if (price[i] > max) {
                max = price[i];
            }
        }
        return max;
    }
}
