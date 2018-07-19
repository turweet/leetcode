package beginer.other;

public class HammingDistance {
    /**
     * times:1
     * @param x
     * @param y
     * @return
     */
    public int hammingDistance(int x, int y) {
        int count = 0;
        int mask = 1;
        for (int i = 0; i < 31; i++) {
            if ((x & mask) !=  (y & mask)) {
                count++;
            }
            mask <<= 1;
        }
        return count;
    }
}
