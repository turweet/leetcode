package summary;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntTips {

    /**
     * 去除数字中各位的快捷方法
     * @param n
     * @return
     */
    public List<Integer> getBitArray(int n) {
        List<Integer> ret = new ArrayList<>();
        do {
            ret.add(n % 10);
            n = n / 10;
        } while (n != 0);
        return ret;
    }
    @Test
    public void test() {
        Assert.assertEquals(Arrays.asList(1,2,3), getBitArray(321));
    }

}
