package beginer.search;

import jdk.nashorn.internal.ir.IfNode;

/**
 * https://leetcode.com/problems/search-insert-position/description/
 */
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        return searchInsert(nums, target, 0, nums.length - 1);
    }

    private int searchInsert(int[] nums, int target, int lo, int hi) {
        if (lo == hi) {
            if (nums[lo] < target) {
                return lo + 1;
            } else if (nums[lo] > target) {
                return lo;
            }
        }
        int mid = lo + (hi - lo) / 2;
        if (nums[mid] > target) {
            return searchInsert(nums, target, lo, mid - 1);
        } else if (nums[mid] < target) {
            return searchInsert(nums, target, mid + 1, hi);
        } else {
            return mid;
        }
    }
}
