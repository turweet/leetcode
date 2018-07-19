package beginer.other;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MissingNubmer {
    /**
     * 1. 没有想出来用排序的方法
     * 2. 审题不清楚，没有考虑到边界的情况，比如只有1个数字，还有就是多个数字都是连续的情况，
     * 其实是丢了最后一个，这些东西一上来就得搞清楚才行，举出边界条件的例子
     *
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        if (nums[0] != 0) {
            return 0;
        }
        if (nums[nums.length - 1] < nums.length) {
            return nums[nums.length - 1] + 1;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] + 1 != nums[i + 1]) {
                return nums[i] + 1;
            }
        }
        return -1;
    }

    public int missingNumbe2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i <= nums.length; i++) {
            set.add(i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                set.remove(nums[i]);
            }
        }
        return (int) set.toArray()[0];
    }

    /**
     * 求和的这种方式真的没有想到啊
     * @param nums
     * @return
     */
    public int missingNumber_Best(int[] nums) {
        int should = 0;
        for (int i = 0; i < nums.length + 1; i++) {
            should = should + i;
        }
        int real = 0;
        for (int i = 0; i < nums.length; i++) {
           real = real + nums[i] ;
        }
        return should - real;
    }
}
