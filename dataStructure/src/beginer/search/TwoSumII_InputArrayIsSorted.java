package beginer.search;

public class TwoSumII_InputArrayIsSorted {
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > target) {
                return null;
            } else {
                int another = search(numbers, i + 1, numbers.length - 1, target - numbers[i]);
                if (another != -1) {
                    int[] ans = {i + 1, another + 1};
                    return ans;
                }
            }
        }
        return null;
    }


    private int search(int[] nums, int lo, int hi, int target) {
        if (lo > hi) { //二分查找递归时这里是没有等号的
            return -1;
        } else {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < target) {
                return search(nums, mid + 1, hi, target);
            } else if (nums[mid] > target) {
                return search(nums, lo, mid - 1, target);
            } else {
                return mid;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {2, 7, 11, 15};
        TwoSumII_InputArrayIsSorted twoSumII_inputArrayIsSorted = new TwoSumII_InputArrayIsSorted();
        int[] i = twoSumII_inputArrayIsSorted.twoSum(a, 9);

    }
}
