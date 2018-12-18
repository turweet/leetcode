package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/next-closest-time/description/
 * 给你一个时间HH:MM形式的，用给出时间的数字排列出一个新的时间要求距离当前时间最近
 * 可以重复使用某个数字
 */
public class NextClosestTime {
    public String nextClosestTime(String time) {
        char[] times = time.toCharArray();
        int[] t;
        Map<String, Integer> map = new HashMap<>();
        if (times.length == 5) {
            t = new int[4];
            t[0] = Character.getNumericValue(times[0]);
            t[1] = Character.getNumericValue(times[1]);
            t[2] = Character.getNumericValue(times[3]);
            t[3] = Character.getNumericValue(times[4]);
            if (t[0] == t[1] && t[1] == t[2] && t[2] == t[3]) {
                return time;
            }
            for (int i = 0; i < 4; i++) {
                if (t[i] > 2) {
                    continue;
                }
                String s0 = String.valueOf(t[i]);
                for (int j = 0; j < 4; j++) {
                    if (s0.equals("2") && t[j] > 3) {
                        continue;
                    }
                    String s1 = s0 + String.valueOf(t[j]);
                    for (int k = 0; k < 4; k++) {
                        if (t[k] > 5) {
                            continue;
                        }
                        String s2 = s1 + String.valueOf(t[k]);
                        for (int l = 0; l < 4; l++) {
                            String s3 = s2 + String.valueOf(t[l]);
                            map.put(s3, Integer.valueOf(s3));
                        }
                    }
                }
            }
        } else { //length is 4
            t = new int[3];
            t[0] = Character.getNumericValue(times[0]);
            t[1] = Character.getNumericValue(times[2]);
            t[2] = Character.getNumericValue(times[3]);
            for (int i = 0; i < 3; i++) {
                String s0 = String.valueOf(t[i]);
                for (int j = 0; j < 3; j++) {
                    if (t[j] > 5) {
                        continue;
                    }
                    String s1 = s0 + String.valueOf(t[j]);
                    for (int k = 0; k < 3; k++) {
                        String s2 = s1 + String.valueOf(t[k]);
                        map.put(s2, Integer.valueOf(s2));
                    }
                }
            }
        }


        int smallAndSmallest = Integer.MAX_VALUE;
        String smalK = "";
        int bigButSmallest = Integer.MAX_VALUE;
        String bigk = "";
        int target = charsToInt(t);
        for (Map.Entry<String, Integer> en : map.entrySet()) {
            int comp = Integer.valueOf(en.getValue());
            if (comp > target) {
                if (comp < bigButSmallest) {
                    bigButSmallest = comp;
                    bigk = en.getKey();
                }
            } else if (comp < target) {
                if (comp < smallAndSmallest) {
                    smallAndSmallest = comp;
                    smalK = en.getKey();
                }
            }
        }
        String ans;
        if (bigButSmallest < Integer.MAX_VALUE) {
            ans = bigk;
        } else {
            ans = smalK;
        }

        if (ans.length() == 4) {
            char[] cs = ans.toCharArray();
            char[] realcs = new char[cs.length + 1];
            realcs[0] = cs[0];
            realcs[1] = cs[1];
            realcs[2] = ':';
            realcs[3] = cs[2];
            realcs[4] = cs[3];
            return new String(realcs);
        } else {
            char[] cs = ans.toCharArray();
            char[] realcs = new char[cs.length + 1];
            realcs[0] = cs[0];
            realcs[1] = ':';
            realcs[2] = cs[2];
            realcs[3] = cs[3];
            return new String(realcs);
        }
    }

    public static void main(String[] args) {
        NextClosestTime time = new NextClosestTime();
        String s = time.nextClosestTime("00:13");
        System.out.println(s);
    }

    private int charsToInt(int[] cs) {
        int ans = 0;
        int len = cs.length;
        for (int i = 0; i < len; i++) {
            ans += cs[i] * Math.pow(10, len - i - 1);
        }
        return ans;
    }
}
