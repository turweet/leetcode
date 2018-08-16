package beginer.array;

import util.ArrayUtil;
import util.ListUtil;

import java.util.*;

/**
 * https://leetcode.com/problems/intersection-of-two-arrays-ii/description/
 * 注意这个题是不考虑顺序的
 */
public class Intersect {
    public int[] intersect_not_work(int[] nums1, int[] nums2) {
        List<Integer> first = ArrayUtil.arrayIntToList(nums1);
        List<Integer> result = new ArrayList<>();
        for (int i :
                nums2) {
            if (first.contains(i)) {
                result.add(i);
            }
        }
        return ListUtil.listIntToArray(result);
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = arrayToMapCount(nums1);
        Map<Integer, Integer> map2 = arrayToMapCount(nums2);

        Set<Integer> keySet1 = map1.keySet();
        Set<Integer> keySet2 = map2.keySet();

        List<Integer> result = new ArrayList<>();
        for (int i : keySet1) {
            if (keySet2.contains(i)) {
                int small = map1.get(i) <= map2.get(i) ? map1.get(i) : map2.get(i);
                for (int j = 0; j < small; j++) {
                    result.add(i);
                }
            }
        }
        return ListUtil.listIntToArray(result);
    }


    public static Map<Integer, Integer> arrayToMapCount(int[] ints) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : ints) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        return map;
    }

}

//总结：
//1. 最开始用的那种方式感觉挺对的，结果不行，思考不全面，举得验证例子也不全面
//2. 后来看到别人说了一句hashMap我也有了思路，所以在即使解决简单的数组问题时用set，map，hash这样的东西有时候
//既方便又省里
