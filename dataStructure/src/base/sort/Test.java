package base.sort;

import org.junit.Assert;

public class Test {

    @org.junit.Test
    public void test() {
        int[] arr1 = {7, 6, 5, 3, 2, 4, 1};
        int[] arr3 = {1, 2, 3, 4, 5, 6, 7};
        ISort iSort = new QuickSort();
        int[] arr2 = {1, 2, 3, 4, 5, 6, 7};
        iSort.sort(arr1);
        iSort.sort(arr3);
        Assert.assertArrayEquals(arr2, arr1);
        Assert.assertArrayEquals(arr2, arr3);
    }
}
