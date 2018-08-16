package medium.arraystring;

import org.junit.Test;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba"也是一个有效答案。
 * <p>
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 */
public class LongestPalindrome {

    int max = 0;
    int start = 0;

    public String longestPalindromeBetter(String s) {
        for (int i = 0; i < s.length(); i++) {
            check(s, i, i);
            check(s, i, i + 1);
        }
        return s.substring(start, start + max);
    }

    private void check(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        if (j - i - 1 > max) {
            max = j - i - 1;
            start = i + 1;
        }
    }


    /**
     * 算法没有问题但是超时了
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        String max = String.valueOf(s.charAt(0));
        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (isPalindrome(s, i, j)) {
                    if (j - i + 1 > max.length()) {
                        max = s.substring(i, j + 1);
                    }
                }
            }
        }
        return max;
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    @Test
    public void test() {
        String s = "abcdef";
        System.out.println(s.substring(1, 2));
        System.out.println(s.substring(1, 3));
        System.out.println();
    }


}
