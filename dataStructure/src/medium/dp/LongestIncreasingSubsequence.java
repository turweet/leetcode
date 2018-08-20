package medium.dp;


import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 花花酱讲解：https://www.youtube.com/watch?v=7DKFpWnaxLI
 */
public class LongestIncreasingSubsequence {

    /**
     * beat 34%
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS_On2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int[] items = new int[nums.length];
        items[0] = 1;
        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            items[i] = smallerMaxIncrease(nums, items, i);
            if (items[i] > max) {
                max = items[i];
            }
        }
        return max;
    }

    private int smallerMaxIncrease(int[] nums, int[] items, int pos) {
        int target = nums[pos];
        int max = 1;
        boolean has = false;
        for (int i = 0; i < pos; i++) { //注意这里从0开始的
            if (nums[i] < target && items[i] >= max) {
                max = items[i];
                has = true;
            }
        }
        if (has) {
            return max + 1;
        } else {
            return max;
        }
    }


    /**
     * 用的dp的方法，但是仍然算的是连续的增长的最长的，这里是可以不连续的
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS_wrong_lianxu(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int[] items = new int[nums.length];
        items[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            items[i] = nums[i] > nums[i - 1] ? 1 + items[i - 1] : 1;
        }
        int max = 0;
        for (int i = 0; i < items.length; i++) {
            if (items[i] > max) {
                max = items[i];
            }
        }
        return max;
    }


    /**
     * 题意理解错了，增长序列可以是不连续的
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS_understand_wrong(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int count = 1;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[j - 1]) {
                    count++;
                } else {
                    break;
                }
            }
            max = Math.max(max, count);
        }
        return max;
    }
}
