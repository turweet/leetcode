package beginer.dp;

public class MaxSubArray {
    /**
     * 超时
     * @param nums
     * @return
     */
    public int maxSubArray_bad(int[] nums) {
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (sum(nums, i, j) > max) {
                    max = sum(nums, i, j);
                }
            }
        }
        return max;
    }

    private int sum(int[] a, int start, int end) {
        if (start == end) {
            return a[start];
        }
        int result = 0;
        for (int i = start; i <= end; i++) {
            result += a[i];
        }
        return result;
    }

}
