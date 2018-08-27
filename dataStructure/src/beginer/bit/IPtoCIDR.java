package beginer.bit;

import java.util.ArrayList;
import java.util.List;

public class IPtoCIDR {
    public List<String> ipToCIDR(String ip, int n) {
        long start = ipToLong(ip);
        List<String> ans = new ArrayList();
        while (n > 0) {
            int mask = Math.max(33 - bitLength(Long.lowestOneBit(start)),
                    33 - bitLength(n));
            ans.add(longToIP(start) + "/" + mask);
            start += 1 << (32 - mask);
            n -= 1 << (32 - mask);
        }
        return ans;
    }

    private long ipToLong(String ip) {
        long ans = 0;
        for (String x : ip.split("\\.")) {
            ans = 256 * ans + Integer.valueOf(x);
        }
        return ans;
    }

    private String longToIP(long x) {
        return String.format("%s.%s.%s.%s",
                x >> 24, (x >> 16) % 256, (x >> 8) % 256, x % 256);
    }

    private int bitLength(long x) {
        if (x == 0) return 1;
        int ans = 0;
        while (x > 0) {
            x >>= 1;
            ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
//        Input: ip = "255.0.0.7", n = 10
//        Output: ["255.0.0.7/32","255.0.0.8/29","255.0.0.16/32"]
        IPtoCIDR iPtoCIDR = new IPtoCIDR();
        iPtoCIDR.ipToCIDR("255.0.0.7", 10);
    }
}
