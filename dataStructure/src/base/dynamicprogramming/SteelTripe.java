package base.dynamicprogramming;

import org.junit.Assert;
import org.junit.Test;

public class SteelTripe {
    public int[] price = {1, 5, 8, 9, 10, 17, 17, 20, 24, 30};

    public int cut_rec(int n) {
        if (n == 0) {
            return 0;
        }
        int result = price[n - 1];
        for (int i = 1; i < n; i++) {
            result = Math.max(result, price[i - 1] + cut_rec(n - i));
        }
        return result;
    }

    public int cut_memo(int n) {
        int[] memo = new int[n];
        for (int i = 0; i < n; i++) {
            memo[i] = -1;
        }
        return cut_memo_inner(memo, n);
    }

    private int cut_memo_inner(int[] memo, int n) {
        if (memo[n - 1] != -1) {
            return memo[n - 1];
        }
        int result = price[n - 1];
        for (int i = 1; i < n; i++) {
            result = Math.max(result, price[i - 1] + cut_memo_inner(memo, n - i));
            memo[n - 1] = result;
        }
        return result;
    }

    public int cut_bottomToTop(int n) {
        int[] memo = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int iMax = price[i - 1];
            for (int j = 1; j < i; j++) {
                iMax = Math.max(iMax, price[j - 1] + memo[i - j]);
            }
            memo[i] = iMax;
        }
        return memo[n];
    }


    public static int cut_origin(int[] p, int n) {
        if (n == 0)
            return 0;
        int q = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            q = Math.max(q, p[i - 1] + cut_origin(p, n - i));
        }
        return q;
    }

    @Test
    public void test() {
        for (int i = 1; i <= 10; i++) {
            int result = cut_origin(price, i);
            System.out.println("len: " + i + " money" + result);
            Assert.assertEquals(result, cut_rec(i));
            Assert.assertEquals(result, cut_memo(i));
            Assert.assertEquals(result, cut_bottomToTop(i));
        }
    }
}
