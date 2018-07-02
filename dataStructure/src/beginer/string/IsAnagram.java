package beginer.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IsAnagram {
    /**
     * 手写代码时请注意，Integer不能直接用==比较，需要用equals
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram_byHashMap(String s, String t) {
        if (s.length() != t.length()) { //优先处理，不浪费时间和空间
            return false;
        }

        Map<Character, Integer> maps = stringCharCountMap(s);
        Map<Character, Integer> mapt = stringCharCountMap(t);

        if (maps.keySet().size() == mapt.keySet().size()) {
            for (Map.Entry<Character, Integer> entry : maps.entrySet()) {
                if (!mapt.keySet().contains(entry.getKey())
                        || !mapt.get(entry.getKey()).equals(entry.getValue())) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }

    }

    public static Map<Character, Integer> stringCharCountMap(String s) {
        Map<Character, Integer> maps = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (maps.keySet().contains(s.charAt(i))) {
                maps.put(s.charAt(i), maps.get(s.charAt(i)) + 1);
            } else {
                maps.put(s.charAt(i), 1);
            }
        }
        return maps;
    }

    public boolean isAnagram_bySort(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] schars = s.toCharArray();
        char[] tchars = t.toCharArray();

        Arrays.sort(schars);
        Arrays.sort(tchars);

        for (int i = 0; i < schars.length; i++) {
            if (schars[i] != tchars[i]) {
                return false;
            }
        }
        return true;
    }

    public static final int LETTER_COUNT = 26;

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] count = new int[LETTER_COUNT];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
        for (int i : count) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}
//总结：
//一开始想到了用hashMap，但是用有序的数组来处理这种情况，真的非常简单，好用
//注意在开始判断条件避免空间和时间的浪费
//利用26个字母的特性和char的减法真的很厉害了