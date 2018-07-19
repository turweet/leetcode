package cc150.arraystring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 题目描述
 * <p>
 * 假定我们都知道非常高效的算法来检查一个单词是否为其他字符串的子串。请将这个算法编写成一个函数，给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成，要求只能调用一次检查子串的函数。
 * <p>
 * 给定两个字符串s1,s2,请返回bool值代表s2是否由s1旋转而成。字符串中字符为英文字母和空格，区分大小写，字符串长度小于等于1000。
 * 测试样例：
 * <p>
 * "Hello world","worldhello "
 * <p>
 * 返回：false
 * <p>
 * "waterbottle","erbottlewat"
 * <p>
 * 返回：true
 */
public class ReverseEqual {
    //attention
    public boolean checkReverseEqual(String s1, String s2) {
        if (s1.equals("")) {
            return s1.equals(s2);
        }
        if (s1.length() != s2.length()) {
            return false;
        }
        return isSubString(s1 + s1, s2);
    }

    private boolean isSubString(String s, String s2) {
        return s.contains(s2);
    }

    /**
     * 这种方法不对，比如s1="ttttottttott" s2="tttttttttott"
     *
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkReverseEqual_wrong(String s1, String s2) {
        int len = s1.length();
        if (len != s2.length()) {
            return false;
        }
        if (len == 0 || len == 1) {
            return s1.equals(s2);
        }
        Map<Character, List<char[]>> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            char c = s1.charAt(i);
            char[] value = new char[2];
            if (i == 0) {
                value[0] = s1.charAt(len - 1);
                value[1] = s1.charAt(1);
            } else if (i == len - 1) {
                value[0] = s1.charAt(len - 2);
                value[0] = s1.charAt(0);
            } else {
                value[0] = s1.charAt(i - 1);
                value[1] = s1.charAt(i + 1);
            }
            if (map.containsKey(c)) {
                map.get(c).add(value);
            } else {
                List<char[]> list = new ArrayList<>();
                list.add(value);
                map.put(c, list);
            }
        }
        for (int i = 0; i < len; i++) {
            char c = s2.charAt(i);
            if (!map.containsKey(c)) {
                return false;
            }
            char[] value = new char[2];
            if (i == 0) {
                value[0] = s1.charAt(len - 1);
                value[1] = s1.charAt(1);
            } else if (i == len - 1) {
                value[0] = s1.charAt(len - 2);
                value[0] = s1.charAt(0);
            } else {
                value[0] = s1.charAt(i - 1);
                value[1] = s1.charAt(i + 1);
            }
            if (!map.get(c).contains(value)) {
                return false;
            }
        }
        return true;
    }
}
