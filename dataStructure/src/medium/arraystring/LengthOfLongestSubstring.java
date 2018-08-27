package medium.arraystring;


import java.util.HashMap;
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
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 */
public class LengthOfLongestSubstring {

    /**
     * 超时
     *
     * @param s
     * @return
     */
    public int lenthOfLongestSubstring_bad(String s) {
        int max = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (isAllUnique(s, i, j)) {
                    max = Math.max(max, j - i);
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

    /**
     * 举例如下：
     * 0 1 2 3 4 5 6 7
     * a b c a b c b b
     * i = 3 j = 1
     * i = 4 j = 2
     * i = 5 j = 3
     * i = 6 j = 5
     * i = 7 j = 7
     * 所以j维护了从j到i包括j的最长位置
     * map就是维护这char所对应的最新的位置
     * @param s
     * @return
     */
    public int lenthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                // j的意思是从j开始到现在的i的最大长度
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }
            max = Math.max(max, i - j + 1);
            map.put(s.charAt(i), i);
        }
        return max;
    }
}
