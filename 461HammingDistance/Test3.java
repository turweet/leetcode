import java.util.*;

public class Test3 {

    public static void main(String[] args) {
        System.out.println(hammingDistance(1, 4));
        ;
    }

    public static int hammingDistance2(int x, int y) {
        int z = x ^ y;
        int res = 0;
        String string = Integer.toBinaryString(z);
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == '1') {
                res++;
            }

        }
        return res;
    }

    public static int hammingDistance(int x, int y) {
        List<Integer> xa = getPositions(x);
        List<Integer> ya = getPositions(y);
        int result = 0;
        for (Integer i :
                xa) {
            if (!ya.contains(i)) {
                result++;
            }
        }
        for (Integer i :
                ya) {
            if (!xa.contains(i)) {
                result++;
            }
        }
        return result;
    }

    public static List<Integer> getPositions(int x) {
        List<Integer> list = new ArrayList<>();
        int jieguo;
        int yushu;
        int pos = 0;
        jieguo = x / 2;
        yushu = x % 2;
        if (yushu == 1)
            list.add(pos);

        while (jieguo != 0) {
            yushu = jieguo % 2;
            jieguo = jieguo / 2;
            pos++;
            if (yushu == 1)
                list.add(pos);
        }
        return list;

    }

}
