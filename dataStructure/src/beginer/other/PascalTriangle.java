package beginer.other;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    /**
     * times: 3
     * 问题：
     * 1. 忽略了最开始的情况，要现有一个赋值1的情况才能继续下去
     * 2. 忽略了为0的情况
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0) {
            return result;
        }
        List<Integer> pre = new ArrayList<>();
        pre.add(1);
        result.add(pre);
        for (int i = 2; i <= numRows; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                int current = 0;
                if (j - 1 >= 0) {
                    current = current + pre.get(j - 1);
                }
                if (j < pre.size()) {
                    current = current + pre.get(j);
                }
                list.add(current);
            }
            result.add(list);
            pre = list;
        }
        return result;
    }
}
