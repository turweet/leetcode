package base.sort;

import util.ArrayUtil;

public class Insertion implements ISort {
    public void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {  //当数组已经是从小到大有序的时候，时间复杂度是O(n)
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    ArrayUtil.exchange(arr, j - 1, j);
                }
            }
        }
    }
}
