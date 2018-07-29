package beginer.string;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * <p>
 * If there is no common prefix, return an empty string "".
 * <p>
 * Example 1:
 * <p>
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 * <p>
 * Example 2:
 * <p>
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * <p>
 * Note:
 * <p>
 * All given inputs are in lowercase letters a-z.
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        String result = "";
        if (strs == null || strs.length == 0) {
            return result;
        }
        int minLen = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            int len = strs[i].length();
            if (len < minLen) {
                minLen = len;
            }
        }
        for (int i = 0; i < minLen; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != c) {
                    return result;
                }
            }
            result += c;
        }
        return result;
    }

    public String longestCommonPrefixBetter(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }

}
