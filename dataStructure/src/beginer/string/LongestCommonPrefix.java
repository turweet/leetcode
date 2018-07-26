package beginer.string;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        String result = "";
        char[] chars = new char[strs.length];
        for (int i = 0; ; i++) {
            if (strs[i].length() < i + 1) {
                return result;
            }
        }
    }

}
