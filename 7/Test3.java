public class Test3 {
    public static int reverse(int x) {
        int positiveX = x > 0 ? x : -x;
        long res = 0;
        while (true) {
            res = res * 10 + positiveX % 10;
            positiveX = positiveX / 10;
            if (positiveX == 0) {
                break;
            }
        }
        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) (x > 0 ? res : -res);

    }


    public static void main(String[] args) {
        System.out.println(reverse(2345));
    }

}
