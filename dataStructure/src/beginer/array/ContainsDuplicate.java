package beginer.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public boolean containsDuplicate_bad1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean containsDuplicate_bySort(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i+1]) {
                return true;
            }
        }
        return false;
    }

    /**
     * 仍然存在优化空间，不能因为想到了hash的方式就感觉ok了
     * @param nums
     * @return
     */
    public boolean containsDuplicate_hash_bad(int[] nums) {
        Set<Integer> container = new HashSet<>();
        for (int num : nums) {
            container.add(num);
        }
        return container.size() != nums.length;
    }

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> container = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (container.contains(nums[i])) {
                return true;
            } else {
                container.add(nums[i]);
            }
        }
        return container.size() != nums.length;
    }
}

//启示：
//1. 通过已有的数据结构比如hashset和map来帮助解决问题
//2. 数组问题有时候可以先把数组变成有序之后再解决就比较方便了

