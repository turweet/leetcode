package medium.arraystring;

import java.lang.reflect.Array;
import java.util.*;

public class ThreeSum {
    /**
     * times:3
     * 问题：1. 审题不清楚，要求的是不能有重复的，所以用到了set，还有二分查找时只查后边的就可以了
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (binarySearch(-(nums[i] + nums[j]), nums, j + 1, nums.length - 1)) {
                    result.add(Arrays.asList(nums[i], nums[j], -(nums[i] + nums[j])));
                }
            }
        }
        return new ArrayList<>(result);
    }

    public boolean binarySearch(int target, int[] nums, int lo, int hi) {
        int mid = lo + (hi - lo) / 2;
        if (lo > hi) {
            return false;
        }
        if (nums[mid] == target) {
            return true;
        } else if (nums[mid] < target) {
            return binarySearch(target, nums, mid + 1, hi);
        } else {
            return binarySearch(target, nums, lo, mid - 1);
        }
    }

    public List<List<Integer>> threeSumBetter(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < num.length - 2; i++) {
            if (i == 0 || (i > 0 && num[i] != num[i - 1])) {
                int lo = i + 1, hi = num.length - 1, sum = 0 - num[i];
                while (lo < hi) {
                    if (num[lo] + num[hi] == sum) {
                        res.add(Arrays.asList(num[i], num[lo], num[hi]));
                        while (lo < hi && num[lo] == num[lo + 1]) lo++;
                        while (lo < hi && num[hi] == num[hi - 1]) hi--;
                        lo++;
                        hi--;
                    } else if (num[lo] + num[hi] < sum) {
                        // improve: skip duplicates
                        while (lo < hi && num[lo] == num[lo + 1]) lo++;
                        lo++;
                    } else {
                        // improve: skip duplicates
                        while (lo < hi && num[hi] == num[hi - 1]) hi--;
                        hi--;
                    }
                }
            }
        }
        return res;
    }
}
