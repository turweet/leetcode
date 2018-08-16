package medium.arraystring;

/**
 * 给定一个未排序的数组，请判断这个数组中是否存在长度为3的递增的子序列。
 * <p>
 * 正式的数学表达如下:
 * <p>
 * 如果存在这样的 i, j, k,  且满足 0 ≤ i < j < k ≤ n-1，
 * 使得 arr[i] < arr[j] < arr[k] ，返回 true ; 否则返回 false 。
 * <p>
 * 要求算法时间复杂度为O(n)，空间复杂度为O(1) 。
 * <p>
 * 示例:
 * 输入 [1, 2, 3, 4, 5],
 * 输出 true.
 * <p>
 * 输入 [5, 4, 3, 2, 1],
 * 输出 false
 */
public class IncreasingTriplet {
    /**
     * 时间复杂度太高
     * @param nums
     * @return
     */
    public boolean increasingTriplet_bad(int[] nums) {
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (nums[j] <= nums[i]) {
                    continue;
                }
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[k] > nums[j] && nums[j] > nums[i]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * 注意比较时的等号状态，需要有等号
     *
     * 因为是三个数，所以就保存两个较小的数，看有没有第三个数比他大
     * @param nums
     * @return
     */
    public boolean increasingTriplet(int[] nums) {
        int small1 = Integer.MAX_VALUE; //第一小的数字
        int small2 = Integer.MAX_VALUE; //第二小的数字
        for (int i = 0; i < nums.length; i++) {
           if (nums[i] <= small1) {
               small1 = nums[i];
           } else if (nums[i] <= small2) {
               small2 = nums[i];
           } else {
               return true;
           }
        }
        return false;
    }
}
