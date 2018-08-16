package medium.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 * <p>
 * Note: The solution set must not contain duplicate subsets.
 * <p>
 * Example:
 * <p>
 * Input: nums = [1,2,3]
 * Output:
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 * <p>
 * https://leetcode.com/problems/subsets/description/
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        if (nums.length == 0) {
            return result;
        }
        subsets(nums, result, 0);
        return result;
    }

    public void subsets(int[] nums, List<List<Integer>> lists, int pos) {
        if (pos == nums.length) {
            return;
        }
        List<List<Integer>> loop = new ArrayList<>();
        for (int i = 0; i < lists.size(); i++) {
            List<Integer> list = lists.get(i);
            List<Integer> add = new ArrayList<>();
            add.addAll(list);
            add.add(nums[pos]);
            loop.add(add);
        }
        lists.addAll(loop);
        subsets(nums, lists, pos + 1);
    }
}
