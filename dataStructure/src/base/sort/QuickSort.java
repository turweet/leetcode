package base.sort;

import util.ArrayUtil;

public class QuickSort implements ISort {
    @Override
    public void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private void sort(int[] a, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    private int partition(int[] a, int lo, int hi) {
        int i = lo + 1;
        int j = hi;
        while (true) {
            while (a[i] < a[lo]) {
                i++;
                if (i >= hi) {
                    break;
                }
            }
            while (a[j] > a[lo]) {
                j--;
                if (j <= lo) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            ArrayUtil.exchange(a, i, j);
        }
        ArrayUtil.exchange(a, lo, j);
        return j;
    }
    // TODO: 18/07/2018 非递归的方式实现
}
