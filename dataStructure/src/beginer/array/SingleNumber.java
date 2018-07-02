package beginer.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//还有一个异或的方式有时间可以看看
//https://leetcode.com/problems/single-number/solution/
public class SingleNumber {

    /**
     * 通过排序之后比较的方式实现
     * 注意长度为1，只有一个元素的情况
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i = i + 2) {
            if (nums[i] == nums[i + 1]) {
                if (i + 2 == nums.length - 1) { // 关键判断
                    return nums[i + 2];
                }
            } else {
                return nums[i];
            }
        }
        throw new IllegalArgumentException();
    }

    /**
     * 时间复杂度是On2次方,空间复杂度是On
     *
     * @param nums
     * @return
     */
    public int singleNumber_byHashSet(int nums[]) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                set.remove(nums[i]);
            } else {
                set.add(nums[i]);
            }
        }
        return (int) set.toArray()[0];
    }

    /**
     * 通过数学的方式来实现，别树一帜。因为所有的除了那个特殊的答案，所有的数字都是二倍的
     * @param nums
     * @return
     */
    public int singleNumber_byMath(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int repeatResult = 0;
        for (int i : set) {
            repeatResult += i;
        }
        int realResult = 0;
        for (int i: nums) {
            realResult += i;
        }
        return repeatResult * 2 - realResult;
    }

}
