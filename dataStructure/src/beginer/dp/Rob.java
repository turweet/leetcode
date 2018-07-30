package beginer.dp;

public class Rob {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        return rob(nums, 0);
    }

    public int rob(int[] a, int n) {
        if (n == a.length - 1) {
            return a[n];
        }
        if (n == a.length - 2) {
            return Math.max(a[n], a[n + 1]);
        }
        return Math.max(rob(a, n + 1),
                a[n] + rob(a, n + 2));
    }

    public int rob_memo(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] memo = new int[nums.length];
        for (int i = 0; i < memo.length; i++) {
            memo[i]= -1;
        }
        return rob_memo(nums, 0, memo);
    }

    public int rob_memo(int[] a, int n, int[] memo) {
        if (n == a.length - 1) {
            return a[n];
        }
        if (n == a.length -2) {
            return Math.max(a[n], a[n + 1]);
        }
        if (memo[n] != -1) {
            return memo[n];
        }
        int result = Math.max(rob_memo(a, n + 1, memo),
                a[n] + rob_memo(a, n + 2, memo));
        memo[n] = result;
        return result;
    }
}
