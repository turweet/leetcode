package base.dynamicprogramming;

import org.junit.Assert;
import org.junit.Test;

public class FibTest {
    @Test
    public void test() {
        Fibonacci fibonacci = new Fibonacci();
        System.out.println(fibonacci.fib_bad(4));
        System.out.println(fibonacci.fib_bottomToTopBetter(4));
        for (int i = 0; i < 10; i++) {
            int result = fibonacci.fib_bad(i);
            Assert.assertEquals(result, fibonacci.fib_memo(i));
            Assert.assertEquals(result, fibonacci.fib_bottomToTop(i));
            Assert.assertEquals(result, fibonacci.fib_bottomToTopBetter(i));
        }
    }
}
