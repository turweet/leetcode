package beginer.sortNsearch;

/**
 * https://leetcode.com/problems/merge-sorted-array/description/
 */
public class MergeSortedArray {
    public void merge_bad(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }
        //sort from 0 to m+n-1
        for (int i = 0; i < m + n; i++) {
            for (int j = i + 1; j < m + n; j++) {
                if (nums1[j] < nums1[i]) {
                    int temp = nums1[j];
                    nums1[j] = nums1[i];
                    nums1[i] = temp;
                }
            }
        }
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (i > -1 && j > -1) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }
        while (j > -1) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }
}
//总结：
//答案能大体看懂，但是总是感觉和答案之间隔着一个鸿沟，真的很巧妙，不容易想到啊
