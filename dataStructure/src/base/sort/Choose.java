package base.sort;

import util.ArrayUtil;

public class Choose implements ISort {
    @Override
    public void sort(int[] arr) {//不论输入的数组有序与否都不影响算法的执行效率
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    arr[min] = arr[j];
                }
            }
            ArrayUtil.exchange(arr, i, min);
        }
    }
}
