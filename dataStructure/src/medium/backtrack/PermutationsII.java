package medium.backtrack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>();
        backtracking(ans, new ArrayList<>(), nums);
        return new ArrayList<>(ans);
    }

    private void backtracking(Set<List<Integer>> ans, List<Integer> tempList, int[] nums) {
        if (tempList.size() == nums.length) {
            ans.add(new ArrayList<>(tempList));
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
