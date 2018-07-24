package beginer.math;

import summary.Attention;

/**
 * Implement int sqrt(int x).
 * <p>
 * Compute and return the square root of x,
 * where x is guaranteed to be a non-negative integer.
 * <p>
 * Since the return type is an integer,
 * the decimal digits are truncated and only the integer part of the result is returned.
 * <p>
 * Example 1:
 * <p>
 * Input: 4
 * Output: 2
 * <p>
 * Example 2:
 * <p>
 * Input: 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since
 * the decimal part is truncated, 2 is returned.
 */
public class MySqrt {
    @Attention("这个为什么不对呢？不明白")
    public int mySqrt_wrong(long x) {
        for (int i = 0; ; i++) {
            if (i * i <= x && x < (i + 1) * (i + 1)) {
                return i;
            }
        }
    }

    public static void main(String[] args) {
        new MySqrt().mySqrt_wrong(2147395600);
    }
}
