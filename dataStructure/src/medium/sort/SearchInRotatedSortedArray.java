package medium.sort;

public class SearchInRotatedSortedArray {
    /**
     * wrong: 5 1 2 3 4 find 1
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int len = nums.length;
        return search(nums, 0, len - 1, target);
    }

    private int search(int[] nums, int lo, int hi, int target) {
        if (lo > hi) {
            return -1;
        }
        int mid = lo + (hi - lo) / 2;
        if (target > nums[mid]) {
            if (nums[hi] < target) {
                //left
                return search(nums, lo, hi - 1, target);
            } else {
                //right
                return search(nums, mid + 1, hi, target);
            }
        } else if (target < nums[mid]) {
            if (nums[lo] > target) {
                //right
                return search(nums, mid + 1, hi, target);
            } else {
                //left
                return search(nums, lo, hi - 1, target);
            }
        } else {
            return mid;
        }
    }
}
