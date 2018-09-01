package hard.binarysearch;

/**
 * https://leetcode.com/problems/median-of-two-sorted-arrays/description/
 * example: [1, 2, 3] and [4, 5]
 * [1, 2] and [3, 4]
 */
public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int len = len1 + len2;

        if (len == 0) {
            return 0.0;
        }
        if (len1 == 1 && len2 == 1) {
            return (nums1[0] + nums2[0] ) / 2;
        }

        if (len % 2 == 1) { //奇数
            return kthLargest(nums1, nums2, 0, 0, len / 2);
        } else { //偶数
            double a = kthLargest(nums1, nums2, 0, 0, len / 2);
            double b = kthLargest(nums1, nums2, 0, 0, len / 2 + 1);
            return (a + b) / 2;
        }
    }

    private double kthLargest(int[] a, int[] b, int aStart, int bStart, int k) {
        int lenA = a.length;
        int lenB = b.length;

        int mk = k / 2;
        if (lenA == 0 || aStart >= lenA) {
            return b[mk]; //这里应该返回中间值
        }
        if (lenB == 0 || bStart >= lenB) {
            return a[mk];
        }
        if (k == 1) {
            return Math.min(a[aStart], b[bStart]);
        }
        if (aStart + mk >= lenA) {
            return kthLargest(a, b, lenA, bStart, k);
        }
        if (bStart + mk >= lenB) {
            return kthLargest(a, b, aStart, lenB, k);
        }

        if (a[mk] < b[mk]) {
            return kthLargest(a, b, aStart + mk + 1, bStart, k - mk);
        } else {
            return kthLargest(a, b, aStart, bStart + mk + 1, k - mk);
        }

    }
}
