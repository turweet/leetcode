package medium.arraystring;


import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个字符串，找出不含有重复字符的最长子串的长度。
 * <p>
 * 示例：
 * <p>
 * 给定 "abcabcbb" ，没有重复字符的最长子串是 "abc" ，那么长度就是3。
 * <p>
 * 给定 "bbbbb" ，最长的子串就是 "b" ，长度是1。
 * <p>
 * 给定 "pwwkew" ，最长子串是 "wke" ，长度是3。请注意答案必须是一个子串，"pwke" 是 子序列  而不是子串。
 */
public class LengthOfLongestSubstring {

    /**
     * 超时
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (isAllUnique(s, i, j)) {
                    max = Math.max(max,j - i);
                } else {
                    break;
                }
            }
        }
        return max;
    }

    private boolean isAllUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i <= end; start++) {
            if (set.contains(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
