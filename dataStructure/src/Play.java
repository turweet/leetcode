
public class Play {
    public void test(String s) {
        s = "dfd";
    }

    public static void main(String[] args) {
        String m = "dddd";
        Play play = new Play();
        play.test(m);
        System.out.println(m);
    }
}
