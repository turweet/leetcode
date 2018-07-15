package beginer.math;

import java.util.ArrayList;
import java.util.List;

/**
 * [
 * "1",
 * "2",
 * "Fizz",
 * "4",
 * "Buzz",
 * "Fizz",
 * "7",
 * "8",
 * "Fizz",
 * "Buzz",
 * "11",
 * "Fizz",
 * "13",
 * "14",
 * "FizzBuzz"
 * ]
 */
public class FizzBuzz {
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            result.add(getString(i));
        }
        return result;
    }

    public String getString(int n) {
        String result = "";
        if (n % 3 == 0) {
            result += "Fizz";
        }
        if (n % 5 == 0) {
            result += "Buzz";
        }
        if (n % 3 != 0 && n % 5 != 0) {
            result += n;
        }
        return result;
    }
}
