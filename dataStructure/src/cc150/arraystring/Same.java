package cc150.arraystring;

import java.util.Arrays;

/**
 * 题目描述
 * <p>
 * 给定两个字符串，请编写程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。这里规定大小写为不同字符，且考虑字符串中的空格。
 * <p>
 * 给定一个string stringA和一个string stringB，请返回一个bool，代表两串是否重新排列后可相同。保证两串的长度都小于等于5000。
 * 测试样例：
 * <p>
 * "This is nowcoder","is This nowcoder"
 * <p>
 * 返回：true
 * <p>
 * "Here you are","Are you here"
 * <p>
 * 返回：false
 */
public class Same {
    /**
     * 排序之后看每个位置是否相同
     * @param stringA
     * @param stringB
     * @return
     */
    public boolean checkSame(String stringA, String stringB) {
        // write code here
        if (stringA.length() != stringB.length()) {
            return false;
        }
        char[] charsA = stringA.toCharArray();
        char[] charsB = stringB.toCharArray();
        Arrays.sort(charsA);
        Arrays.sort(charsB);
        for (int i = 0; i < charsA.length; i++) {
            if (charsA[i] != charsB[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断每个char出现的频率是否相同
     *
     * @param stringA
     * @param stringB
     * @return
     */
    public boolean checkSame2(String stringA, String stringB) {
        if (stringA.length() != stringB.length()) {
            return false;
        }
        int[] charSet = new int[256];
        for (int i = 0; i < stringA.length(); i++) {
            int index = stringA.charAt(i);
            charSet[index]++;
        }
        for (int i = 0; i < stringB.length(); i++) {
            int index = stringB.charAt(i);
            if (--charSet[index] < 0) {
                return false;
            }
        }
        return true;
    }


}
