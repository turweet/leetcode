package cc150.arraystring;

import java.util.Arrays;

/**
 * 题目描述
 * 请实现一个算法，确定一个字符串的所有字符是否全都不同。这里我们要求不允许使用额外的存储结构。
 * <p>
 * 给定一个string iniString，请返回一个bool值,True代表所有字符全都不同，False代表存在相同的字符。保证字符串中的字符为ASCII字符。字符串的长度小于等于3000。
 * <p>
 * 测试样例：
 * "aeiou"
 * 返回：True
 * "BarackObama"
 * 返回：False
 */
public class Different {
    /**
     * 很普通的两次循环解决问题
     *
     * @param iniString
     * @return
     */
    public boolean checkDifferent(String iniString) {
        for (int i = 0; i < iniString.length() - 1; i++) {
            for (int j = i + 1; j < iniString.length(); j++) {
                if (iniString.charAt(i) == iniString.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 假设string里边都是ascii字符，ascii字符一共有256个（2的8次方）
     *
     * @param iniString
     * @return
     */
    public boolean checkDifferent2(String iniString) {
        if (iniString.length() > 256) {
            return false;
        }
        boolean[] chars = new boolean[256];
        for (int i = 0; i < iniString.length(); i++) {
            int c = iniString.charAt(i);
            if (chars[c]) {
                return false;
            }
            chars[c] = true;
        }
        return true;
    }

    /**
     * 将原来的字符串排序，在比较相邻是否相同
     *
     * @param iniString
     * @return
     */
    public boolean checkDifferent3(String iniString) {
        char[] chars = iniString.toCharArray();
        Arrays.sort(chars);
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == chars[i + 1]) {
                return false;
            }
        }
        return true;
    }


}
