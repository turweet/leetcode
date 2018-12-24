package medium.hash;

import util.ArrayUtil;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

//https://leetcode.com/problems/hand-of-straights/
public class HandofStraights {
    public boolean isNStraightHand(int[] hand, int W) {
        if (hand.length % W != 0) {
            return false;
        }
        if (W == 1) {
            return true;
        }
        sort(hand);
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < hand.length; i++) {
            map.put(hand[i], map.getOrDefault(hand[i], 1));
        }


        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();

        int flag = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

        }
    }

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
    //参考：https://www.geeksforgeeks.org/iterative-quick-sort/
}
