package base.search;

public class BinarySearch {
    public int search(int key, int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2; //注意这里的计算方式！！二分的时候很重要
            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public int search_re(int key, int[] a) {
        if (a == null || a.length == 0) {
            return -1;
        }
        return search_re(key, a, 0, a.length / 2, a.length - 1);
    }

    public int search_re(int key, int[] a, int lo, int mid, int hi) {
        if (lo > hi) {
            return -1;
        }
        if (a[mid] == key) {
            return mid;
        } else if (a[mid] > key) {
            return search_re(key, a, lo, lo + (mid - 1 - lo) / 2, mid - 1);
        } else {
            return search_re(key, a, mid + 1, mid + 1 + (hi - mid - 1) / 2, hi);
        }
    }
}
