package beginer.array;

import org.junit.Assert;
import org.junit.Test;

public class PlusOne {


    /**
     * 遇到大数会运行不畅，并且也不够简洁
     * @param digits
     * @return
     */
    public int[] plusOne_bad(int[] digits) {
        long num = 0;
        for (int i = 0; i < digits.length; i++) {
            num += digits[i] * Math.pow(10, digits.length - i - 1);
        }
        num += 1;
        int newLen;
        for (int i = 1; ; i++) {
            if (num / (long) Math.pow(10, i) == 0) {
                newLen = i;
                break;
            }
        }
        int[] result = new int[newLen];
        for (int i = 1; i <= newLen; i++) {
            if (newLen - i == 0) {
                result[newLen - i] = (int) (num / (long) Math.pow(10, newLen - 1));
                return result;
            }
            result[newLen - i] = (int) ((num % (long) Math.pow(10, i)) / (long) Math.pow(10, i - 1));
        }
        return result;
    }

    /**
     * 注意在写for循环的时候，有时候i从大数开始的，这时候i-- 很容易就忘了 仍然是i++
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        boolean needExpand = false;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
                if (i == 0) {
                    needExpand = true;
                }
            } else {
                digits[i] += 1;
                break;
            }
        }
        if (needExpand) {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            for (int i = 1; i < result.length; i++) {
                result[i] = 0;
            }
            return result;
        } else {
            return digits;
        }
    }


    @Test
    public void test() {
        int[] array = {9,8,7,6,5,4,3,2,1,0};
        int[] expected= {9,8,7,6,5,4,3,2,1,1};
        Assert.assertArrayEquals(expected,plusOne(array));
    }
}
