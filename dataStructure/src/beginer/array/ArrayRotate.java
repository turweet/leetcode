package beginer.array;

import org.junit.Assert;
import org.junit.Test;

public class ArrayRotate {
    //    输入:[1,2,3,4,5,6,7]
//    和 k = 3
//    输出:[5,6,7,1,2,3,4]
    // k = 6 => [7,6,5,4,3,2,1]
//输入: [-1,-100,3,99] 和 k = 2
//输出: [3,99,-1,-100]

    public void rotate(int[] nums, int k) {
        if (k == 0 || nums.length == 1) {
            return;
        }
        if (k >= nums.length) {
            rotate(nums, k % nums.length); //其实可以不做判断是否大于长度，直接取余再调用也可以的
            return;
        }
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        if (start < 0 || end >= nums.length) {
            throw new IllegalArgumentException();
        }
        int count = (end - start + 1) / 2;
        int temp;
        for (int i = 0; i < count; i++) {
            temp = nums[start + i];
            nums[start + i] = nums[end - i];
            nums[end - i] = temp;
        }
    }

    /**
     * 一个更加优雅的实现
     * @param nums
     * @param start
     * @param end
     */
    private void reverse_better(int[] nums, int start, int end) {
        int temp;
        while (start < end) {
            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }


    /**
     *
     * 答案没有问题但是发生了超时，并且使用了额外空间
     *
     * @param nums
     * @param k
     */
    public void rotate_bad(int[] nums, int k) {
        if (k > nums.length) {
            rotate_bad(nums, k % nums.length);
            return;
        }
        int[] result = new int[nums.length];
        for (int i = 0; i < k; i++) {
            result[i] = nums[nums.length - k + i];
        }
        for (int i = 0; i < nums.length - k; i++) {
            result[k + i] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = result[i];
        }
    }

    @Test
    public void test() {
        int nums1[] = {1, 2, 3, 4, 5, 6, 7};
        int nums1_result[] = {5, 6, 7, 1, 2, 3, 4};
        rotate(nums1, 3);
        Assert.assertArrayEquals(nums1_result, nums1);

        int nums2[] = {1, 2};
        int nums2_result[] = {2, 1};
        rotate(nums2, 3);
        Assert.assertArrayEquals(nums2_result, nums2);
    }
}

//总结：
//简单的实现并不难，但是使用了额外的空间，在循环上也会稍微耗时一些
//答案通过翻转的方式实现，确实很厉害，还是得多做观察，多做观察，看看实例给出的数组是怎么做的
//最终的效果是什么样的，从而看出用反转即可实现
//
//即使在看到反转实现的思路之后自己写代码也花了不少时间，反转程序本身没什么问题，但是
//1. 对于调用反转的数组区域方面发生了问题，还是要多观察，确定从哪个位置分割开，分别做翻转
//2. 边界条件，比如只有一个值的数组的情况，k大于数组长度的情况，k为0的情况