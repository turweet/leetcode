package beginer.math;

import org.junit.Test;
import summary.Attention;

public class TrailingZeroes {

    @Attention
    public int trailingZeroes(int n) {
        int ret = 0;
        while (n / 5 != 0) {
            ret = ret + n / 5;
            n = n / 5;
        }
        return ret;
    }

    public int trailingZeroeswrong(int n) {
        int tens = (n / 10) * 2;
        int a = n % 10;
        if (a >= 5) {
            return tens + 1;
        } else {
            return tens;
        }
    }

    /**
     * 不行，这样会溢出，才算到13的时候就溢出了
     * @param n
     * @return
     */
    public int trailingZeroes2(int n) {
        int ret = 1;
        while (n > 1) {
            ret = ret * n;
            n--;
        }
        int zeros = 0;
        while (ret % 10 == 0) {
            zeros++;
            ret = ret / 10;
        }
        return zeros;
    }

    @Test
    public void test() {
        trailingZeroes2(13);
    }

}
