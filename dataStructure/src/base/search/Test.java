package base.search;

import org.junit.Assert;

public class Test {
    @org.junit.Test
    public void test() {
        int[] a = {1, 2, 3, 4, 5};
        int key = 0;
        BinarySearch binarySearch = new BinarySearch();
        org.junit.Assert.assertEquals(-1, binarySearch.search(key, a));
        Assert.assertEquals(-1, binarySearch.search_re(key, a));
    }
}
