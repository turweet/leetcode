package medium.arraystring;

import java.util.*;

/**
 * Given a non-empty array of integers, return the k most frequent elements.
 * <p>
 * For example,
 * Given [1,1,1,2,2,3] and k = 2, return [1,2].
 * <p>
 * Note:
 * <p>
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 * <p>
 * <p>
 * <p>
 * 题意位前k个频率最高的数字
 */
public class TopKFrequent {
    /**
     * 用map来存储谁都会，难点在于需要在小于快排的时间复杂度内排好序，这里是关键
     * 这里用了额外的数组，长度对应原始数组长度加一，然后就可以把从最小的1开始到最大的全部相同
     * 的频率的值存储起来，然后从最高位开始找出k个数即可
     *
     * @param nums
     * @param k
     * @return
     */
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer>[] arr = new List[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        for (int key : map.keySet()) {
            int count = map.get(key);
            if (arr[count] == null) {
                arr[count] = new ArrayList<>();
            }
            arr[count].add(key);
        }
        List<Integer> result = new ArrayList<>();
        for (int i = arr.length - 1; i >= 1; i--) {
            List<Integer> list = arr[i];
            if (list != null) {
                for (int j = 0; j < list.size(); j++) {
                    if (k > 0) {
                        result.add(list.get(j));
                        k--;
                    } else {
                        return result;
                    }
                }
            }
        }
        return result;
    }
}
