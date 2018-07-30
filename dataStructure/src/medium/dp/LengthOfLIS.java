package medium.dp;

/**
 * 花花酱讲解：https://www.youtube.com/watch?v=7DKFpWnaxLI
 */
public class LengthOfLIS {
    /**
     * 题意理解错了，增长序列可以是不连续的
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
