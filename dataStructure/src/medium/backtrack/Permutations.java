package medium.backtrack;

import java.util.ArrayList;
import java.util.List;


/**
 * Given a collection of distinct integers, return all possible permutations.
 * <p>
 * Example:
 * <p>
 * Input: [1,2,3]
 * Output:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 * 关于回溯法很好的总结：
 * https://leetcode.com/problems/permutations/discuss/18239/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partioning)
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtracking(ans, new ArrayList<>(), nums);
        return ans;
    }

    private void backtracking(List<List<Integer>> ans, List<Integer> tempList, int[] nums) {
        if (tempList.size() == nums.length) {
            ans.add(new ArrayList<>(tempList)); //注意这里需要new出新的对象
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (tempList.contains(nums[i])) {
                    continue;
                } else {
                    tempList.add(nums[i]); //choose
                    backtracking(ans, tempList, nums); //explore
                    tempList.remove(tempList.size() - 1); //un-choose
                }
            }
        }
    }
}
