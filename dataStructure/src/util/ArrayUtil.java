package util;

import java.util.ArrayList;
import java.util.List;

public class ArrayUtil {
    public static List<Integer> arrayIntToList(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i : nums) {
            list.add(i);
        }
        return list;
    }
}
