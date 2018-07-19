package beginer.math;

public class IsPowerOfThree {
    /**
     * times:3
     * 1. 忘记了4 / 3也是1的这种情况
     * @param n
     * @return
     */
    public boolean isPowerOfThree(int n) {
        while (n > 1) {
            int yu = n % 3;
            n = n / 3;
            if (yu > 0) {
                return false;
            }
        }
        return n == 1;
    }
}
