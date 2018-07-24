package beginer.array;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int value : nums) {
            if (map.containsKey(value)) {
                map.put(value, map.get(value) + 1);
                if (map.get(value) > nums.length / 2) {
                    return value;
                }
            } else {
                map.put(value, 1);
            }
        }
        throw new IllegalArgumentException();
    }
}
