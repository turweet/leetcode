package medium.arraystring;

/**
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
 * <p>
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
 * <p>
 * Find the minimum element.
 * <p>
 * You may assume no duplicate exists in the array.
 * <p>
 * Example 1:
 * <p>
 * Input: [3,4,5,1,2]
 * Output: 1
 * Example 2:
 * <p>
 * Input: [4,5,6,7,0,1,2]
 * Output: 0
 */
public class FindMin {
    public int findMin(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] < nums[i]) {
                return nums[i + 1];
            }
        }
        return Math.min(nums[0], nums[nums.length - 1]);
    }

    public static void main(String[] args) {
        int[] a = {5,4,3,2,1};
        System.out.println(new FindMin().findMin(a));
    }

    public int findMin2(int[] nums) {
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < min){
                min = nums[i];
            }
        }
        return min;
    }
}
