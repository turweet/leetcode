package beginer.sortNsearch;

public class FirstBadVersion {
    public int firstBadVersion(int n) {
        return binaryCheck(0, n / 2, n);
    }

    boolean isBadVersion(int version) {
        return false;
    }

    int binaryCheck(int low, int mid, int high) {
        if (low > high) {
            return - 1;
        }
        if (isBadVersion(mid)) {
            if (!isBadVersion(mid - 1)) {
                return mid;
            } else {
                return binaryCheck(low, low + (mid - 1 - low) / 2,
                        mid - 1);
            }
        } else {
            return binaryCheck(mid + 1, mid + 1 + (high - mid - 1) / 2, high);
        }
    }
}
//总结：很明显的应用二分查找的题目，注意是否确认存在badVersion
