package base;

public class TestSubString {
    public static void main(String[] args) {
        String s = "abadef";
        for (int i = 0; i <= s.length(); i++) {
            System.out.println("current i:" + i);
            System.out.println("  " + s.substring(0, i));
            System.out.println("  " + s.substring(i));
        }
    }
}
