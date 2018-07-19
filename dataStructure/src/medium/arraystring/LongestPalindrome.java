package medium.arraystring;

import org.junit.Test;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为1000。

 示例 1：

 输入: "babad"
 输出: "bab"
 注意: "aba"也是一个有效答案。

 示例 2：

 输入: "cbbd"
 输出: "bb"


 */
public class LongestPalindrome {
    /**
     * 算法没有问题但是超时了
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        String max = String.valueOf(s.charAt(0));
        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (isPalindrome(s, i, j)) {
                    if (j - i + 1 > max.length())  {
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
        System.out.println(s.substring(1,3));
        System.out.println();
    }

}
