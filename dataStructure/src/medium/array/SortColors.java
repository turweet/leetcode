package medium.array;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/sort-colors/description/
 */
public class SortColors {
    /**
     * 注意0 1 2 有可能某种颜色不存在的情况
     *
     * @param nums
     */
    public void sortColors_bad(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                map.put(0, map.getOrDefault(0, 0) + 1);
            } else if (nums[i] == 1) {
                map.put(1, map.getOrDefault(1, 0) + 1);
            } else {
                map.put(2, map.getOrDefault(2, 0) + 1);
            }
        }

        int count0 = 0;
        if (map.containsKey(0)) {
            count0 = map.get(0);
            for (int i = 0; i < count0; i++) {
                nums[i] = 0;
            }
        }
        if (map.containsKey(1)) {
            int count1 = map.get(1);
            for (int i = count0; i < count0 + count1; i++) {
                nums[i] = 1;
            }
        }

        if (map.containsKey(2)) {
            int count2 = map.get(2);
            for (int i = nums.length - count2; i < nums.length; i++) {
                nums[i] = 2;
            }
        }
    }
}
