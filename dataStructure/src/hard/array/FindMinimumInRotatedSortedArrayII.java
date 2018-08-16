package hard.array;

/**
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/description/
 */
public class FindMinimumInRotatedSortedArrayII {

    public int findMin(int[] nums) {
        return findMin(nums, 0, nums.length - 1);
    }

    private int findMin(int[] nums, int lo, int hi) {
        int mid = lo + (hi - lo) / 2;
        int left = firstNotSameAtLeft(nums, mid);
        int right = firstNotSameAtRight(nums, mid);
        if (nums[mid] < left && nums[mid] > right) {
            return nums[mid];
        }
        if (nums[mid] < left && nums[mid] < right) { //在递增的位置
//           return findMin()
        }
        return 0;
    }

    private int firstNotSameAtLeft(int[] nums, int pos) {
        for (int i = pos; i >= 0; i++) {
            if (nums[i] != nums[pos]) {
                return nums[i];
            }
        }
        return Integer.MAX_VALUE;
    }

    private int firstNotSameAtRight(int[] nums, int pos) {
        for (int i = pos; i < nums.length; i++) {
            if (nums[i] != pos) {
                return nums[i];
            }
        }
        return Integer.MIN_VALUE;
    }

}
