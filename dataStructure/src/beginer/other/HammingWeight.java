package beginer.other;

import org.junit.Assert;
import org.junit.Test;

public class HammingWeight {

    /**
     * 有溢出的问题，没有算法上的问题
     *
     * @param n
     * @return
     */
    // you need to treat n as an unsigned value
    public int hammingWeight_wrong(int n) {
        int result = 0;
        while (n > 0) {
            result += n % 2;
            n = n / 2;
        }
        return result;
    }

    /**
     * 这个问题有问题，像测试用例中的大数在java是不被允许的，不过复习一下&操作和 <<=吧
     * 另外java的int类型是8bit * 4byte一共32位
     *
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int count = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((mask & n) != 0) {
                count++;
            }
            mask <<= 1;
        }
        return count;
    }

    @Test
    public void test() {
        Assert.assertEquals(1, hammingWeight(2));
        Assert.assertEquals(1, hammingWeight(1));
        Assert.assertEquals(1, hammingWeight(4));
    }

}
