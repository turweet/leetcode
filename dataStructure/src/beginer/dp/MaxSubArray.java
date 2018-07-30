package beginer.dp;

/**
 * 被标注为easy的题并不简单，比我做的medium的题目还难，大家也是这样反应的
 * 原题：https://leetcode.com/problems/maximum-subarray/description/
 * 讲解：https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
 */
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
