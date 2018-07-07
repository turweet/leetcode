package base.sort;

/**
 * 学习非递归的写法
 */
public class MergeSort implements ISort {
    int[] aux;

    @Override
    public void sort(int[] arr) {
        aux = new int[arr.length];
        sort(arr, 0, arr.length - 1);
    }

    public void sort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = low + (high - low) / 2;
        sort(arr, low,  mid);
        sort(arr, mid + 1, high);
        merge(arr, low, mid, high);
    }

    public void merge(int[] a, int low, int mid, int high) {
        int i = low;
        int j = mid + 1;
        for (int k = low; k <= high; k++) {
            aux[k] = a[k];
        }
        for (int k = low; k <= high; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > high) {
                a[k] = aux[i++];
            } else if (aux[i] > aux[j]) {
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
        }
    }
}
