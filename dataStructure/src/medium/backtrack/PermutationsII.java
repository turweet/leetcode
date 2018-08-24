package medium.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        backtracking(ans, new ArrayList<>(), nums, used);
        return ans;
    }

    private void backtracking(List<List<Integer>> ans, List<Integer> tempList, int[] nums, boolean[] used) {
        if (tempList.size() == nums.length) {
            ans.add(new ArrayList<>(tempList)); //注意这里需要new出新的对象
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {//最后这个且的条件不好理解，加不加!都可以，但是加了之后效率会更好
                    continue;
                } else {
                    tempList.add(nums[i]); //choose
                    used[i] = true;
                    backtracking(ans, tempList, nums, used); //explore
                    used[i] = false;
                    tempList.remove(tempList.size() - 1); //un-choose
                }
            }
        }
    }
}
