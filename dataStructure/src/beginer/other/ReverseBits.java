package beginer.other;

import org.junit.Assert;
import org.junit.Test;

public class ReverseBits {
    // you need treat n as an unsigned value

    /**
     * @param n
     * @return
     */
    public int reverseBits(int n) {
        int left = (int) Math.pow(2, 31);
        int right = 1;
        int result = 0;
        for (int i = 0; i < 16; i++) {
            if ((n & left) == 0 && (n & right) == 1) {
                result += Math.pow(2, 32 - i - 1);
            } else if ((n & left) == 1 && (n & right) == 0) {
                result += Math.pow(2, i);
            } else if ((n & left) == 1 && (n & right) == 1) {
                result += Math.pow(2, 32 - i - 1) + Math.pow(2, i);
            }
            right = right >>> 1;
            left = left << 1;
        }
        return result;
    }

    @Test
    public void test() {
//        Assert.assertEquals(1, reverseBits(2147483648));
    }
}