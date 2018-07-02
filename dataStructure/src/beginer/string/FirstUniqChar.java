package beginer.string;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstUniqChar {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i <s.length(); i++) {
            if (map.keySet().contains(s.charAt(i))) {
                map.put(s.charAt(i), -1);
            } else {
                map.put(s.charAt(i), i);
            }
        }
        for (Map.Entry<Character, Integer> entry: map.entrySet()) {
            if (entry.getValue() != - 1) {
                return entry.getValue();
            }
        }
        return -1;
    }
}
//总结：
//开始单纯使用数组和string的方式没有很好的思路，然后想到了排序或者用set和map来解决，果然map有思路了
//- linkedHashMap是按照插入顺序排序的一个map这个很有帮助
//- string的charAt方法也很好，不用转换成数组了
