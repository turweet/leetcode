package base.dynamicprogramming;

public class Fibonacci {
    public int fib_bad(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fib_bad(n - 1) + fib_bad(n - 2);
        }
    }

    /**
     * 备忘录式计算fib
     *
     * @return
     */
    public int fib_memo(int n) {
        int memo[] = new int[n + 1]; //注意这里的数组边界条件，是需要加一的
        return fib_memo_inner(n, memo);
    }

    private int fib_memo_inner(int n, int[] memo) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (memo[n] != 0) {
            return memo[n];
        }
        memo[n] = fib_memo_inner(n - 1, memo) +
                fib_memo_inner(n - 2, memo);
        return memo[n];
    }

    public int fib_bottomToTop(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int[] temp = new int[n + 1];
        temp[0] = 0;
        temp[1] = 1; //注意这里如果n为0的话是没有1这个数字的！！！！！！！！
        for (int i = 2; i <= n; i++) {
            temp[i] = temp[i - 1] + temp[i - 2];
        }
        return temp[n];
    }

    public int fib_bottomToTopBetter(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int result = -1;
        int memoMinus1 = 1;
        int memoMinus2 = 0;
        for (int i = 2; i <= n; i++) {
            result = memoMinus1 + memoMinus2;
            memoMinus2 = memoMinus1; //注意这两句的赋值顺序，赋值顺序很重要，一旦颠倒就肯定错了
            memoMinus1 = result;
        }
        return result;
    }
}