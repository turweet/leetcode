package beginer.string;

/**
 * Implement strStr().
 * <p>
 * Return the index of the first occurrence of needle in haystack,
 * or -1 if needle is not part of haystack.
 * <p>
 * Example 1:
 * <p>
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 * <p>
 * Example 2:
 * <p>
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 * <p>
 * Clarification:
 * <p>
 * What should we return when needle is an empty string?
 * This is a great question to ask during an interview.
 * <p>
 * For the purpose of this problem, we will return 0
 * when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
 */
public class IndexOf {

    public int indexOf(String haystack, String needle) {
        if (needle == null || haystack == null) {
            return -1;
        }
        if (needle.isEmpty()) {
            return 0;
        }
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)
                    && haystack.length() - i >= needle.length()) {
                for (int j = 0; j < needle.length(); j++) {
                    if (haystack.charAt(i + j) != needle.charAt(j)) {
                        break;
                    }
                    if (j == needle.length() - 1) {
                        return i;
                    }
                }
            }
        }
        return -1;
    }

}
