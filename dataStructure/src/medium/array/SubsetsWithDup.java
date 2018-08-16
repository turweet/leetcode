package medium.array;

import java.util.*;

public class SubsetsWithDup {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int count = map.get(nums[i]);
                map.put(nums[i], count);
            } else {
                map.put(nums[i], 1);
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        List<Integer> nonDuplist = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 0) {
                nonDuplist.add(entry.getKey());
            } else {
                List<Integer> cur = new ArrayList<>();
                for (int i = 0; i < entry.getValue(); i++) {
                    cur.add(entry.getKey());
                }
                result.add(cur);
            }
        }
        Integer[] nondupArray = new Integer[nonDuplist.size()];
        nondupArray = nonDuplist.toArray(nondupArray);
        subsetsWithDup(nondupArray, 0, result);
        return null;
    }

    private void subsetsWithDup(Integer[] nums, int pos, List<List<Integer>> lists) {

    }
}
