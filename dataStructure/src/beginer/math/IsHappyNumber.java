package beginer.math;

import org.junit.Test;
import summary.Attention;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/happy-number/description/
 * Write an algorithm to determine if a number is "happy".
 * <p>
 * A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
 * <p>
 * Example:
 * <p>
 * Input: 19
 * Output: true
 * Explanation:
 *
 * 错误点：
 * 1. 没有算平方
 * 2. 没有更新循环里边的值
 * 3. char直接转换成int的错误
 */
public class IsHappyNumber {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        set.add(n);
        int temp = n;
        while (true) {
            int val = getBitSquare(temp);
            if (val == 1) {
                return true;
            }
            if (set.contains(val)) {
                return false;
            }
            set.add(val);
            temp = val;
        }
    }

    @Attention("char 0 对应的整数值需要减去48")
    private int getBitSquare(int n) {
        String s = String.valueOf(n);
        char[] chars = s.toCharArray();
        int ret = 0;
        for (int i = 0; i < chars.length; i++) {
            int val = chars[i] - 48;
            ret = ret + val * val;
        }
        return ret;
    }

    @Test
    public void test() {
        isHappy(19);
    }
}
