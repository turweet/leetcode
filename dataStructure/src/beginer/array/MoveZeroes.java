package beginer.array;

import summary.TwoPointer;

/**
 * times:1
 */
public class MoveZeroes {
    @TwoPointer
    public void moveZeroes(int[] nums) {
        int len = nums.length;
        int i = 0;
        int j = i + 1;
        while (j < len) {
            if (nums[i] != 0) { //先找到第一个为0的位置
                i++;
                j = i + 1;
            } else {    //找到之后第一个不为0的位置并交换
                while (j < len) {
                    if (nums[j] != 0) {
                        exchange(nums, i, j);
                        i++;
                        j++;
                        break;
                    } else {
                        j++;
                    }
                }
            }
        }
    }

    public static void exchange(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
