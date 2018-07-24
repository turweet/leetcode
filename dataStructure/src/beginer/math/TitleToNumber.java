package beginer.math;

import java.util.HashMap;
import java.util.Map;

public class TitleToNumber {

//    private Map<Character, Integer> map = null;

    public int titleToNumber(String s) {
//        if (map == null) {
//            map = getMap();
//        }
        char[] chars = s.toCharArray();
        int ret = 0;
        int len = chars.length;
        for (int i = len - 1; i >= 0; i--) {
//            ret += Math.pow(26, len - i - 1) * map.get(chars[i]);
            ret += Math.pow(26, len - i - 1) * (chars[i] - 'A' + 1);
        }
        return ret;
    }

//    private Map<Character, Integer> getMap() {
//        Map<Character, Integer> map = new HashMap<>();
//        int value = 0;
//        for (char i = 'A'; i <= 'Z'; i++) {
//            value++;
//            map.put(i, value);
//        }
//        return map;
//    }
}
