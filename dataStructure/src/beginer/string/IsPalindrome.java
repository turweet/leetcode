package beginer.string;

import java.util.ArrayList;
import java.util.List;

public class IsPalindrome {
    public boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        List<Character> charList = new ArrayList<>();
        for (char c : chars) {
            if (Character.isLetter(c)) {
                charList.add(Character.toLowerCase(c));
            }
            if (Character.isDigit(c)) {
                charList.add(c);
            }
        }
        int start = 0;
        int end = charList.size() - 1;
        while (start < end) {
            if (charList.get(start) == charList.get(end)) {
               start++;
               end--;
            } else {
                return false;
            }
        }
        return true;
    }
}
//总结：
//注意审题，题目中说的是包含数字和字符的，所以不能遗漏数字
