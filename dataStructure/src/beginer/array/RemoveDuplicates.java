package beginer.array;


import org.junit.Assert;
import org.junit.Test;

public class RemoveDuplicates {
//    int nums1[] = {1, 1, 1, 2};
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    //运行时有一个结果发生了超时
    public int removeDuplicates1(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int duplicateCount = 0;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == nums[i]) {
                    duplicateCount++;
                } else {
                    break;
                }
            }
            if (duplicateCount == 0) {
                continue;
            }
            for (int j = 0; j < duplicateCount; j++) {
                for (int k = i; k < nums.length - 1; k++) {
                    nums[k] = nums[k + 1];
                }
            }
        }

        int result = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                break;
            }
            result++;
        }
        return result;
    }

    @Test
    public void test() {
        int nums1[] = {1, 1, 1, 2};
        int result1 = removeDuplicates(nums1);
        Assert.assertEquals(2, result1);
        Assert.assertEquals(1,nums1[0]);
        Assert.assertEquals(2,nums1[1]);

        int nums2[] = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int result2 = removeDuplicates(nums2);
        Assert.assertEquals(5, result2);
        Assert.assertEquals(nums2[0], 0);
        Assert.assertEquals(nums2[1], 1);
        Assert.assertEquals(nums2[2], 2);
        Assert.assertEquals(nums2[3], 3);
        Assert.assertEquals(nums2[4], 4);

        int nums3[] = {1};
        int result3 = removeDuplicates(nums3);
        Assert.assertEquals(1, result3);
        Assert.assertEquals(1, nums3[0]);

    }

    public static void main(String[] args) {

    }
}
