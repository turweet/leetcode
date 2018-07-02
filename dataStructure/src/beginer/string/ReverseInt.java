package beginer.string;

public class ReverseInt {
    /**
     * 遇到的问题：
     * 1. 在一开始没有考虑负数的情况，把负号也算进去了，应该求绝对值的
     * 2. 去掉开头0的时候没有考虑到只有一个0的时候
     * 3. 题目中提示的溢出问题，没有正确对待，最后加了异常捕获
     *
     * @param x
     * @return
     */
    public int reverse_bad(int x) {
        String s = String.valueOf(Math.abs(x));
        String sr = new ReverseString().reverseString(s);
        if (sr.startsWith("0") && sr.length() > 1) {
            sr = sr.substring(1);
        }
        try {
            int xr = Integer.parseInt(sr);
            if (x < 0) {
                return -xr;
            } else {
                return xr;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }

    }

    public int reverse(int x) {
        int px = x > 0 ? x : -x;
        long res = 0;
        while (true) {
            res = res * 10 + px % 10;
            px = px / 10;
            if (px == 0) {
                break;
            }
        }
        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) (x > 0 ? res: -res);
    }
}
