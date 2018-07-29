package medium.design;

import summary.Attention;

import java.util.Random;

public class ShuffleanArray {
    private int[] origin;
    private Random random;

    public ShuffleanArray(int[] nums) {
        origin = nums;
        random = new Random();
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        return origin;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        int[] result = new int[origin.length];
        int[] temp = origin.clone();
        int i = 0;
        while (temp.length > 0) {
            int pos = random.nextInt(temp.length);
            result[i] = temp[pos];
            int[] newTemp = new int[temp.length - 1];
            for (int j = 0; j < newTemp.length; j++) {
                if (j >= pos) {
                    newTemp[j] = temp[j + 1];
                } else {
                    newTemp[j] = temp[j];
                }
            }
            temp = newTemp;
            i++;
        }
        return result;
    }

    @Attention("shuffle技巧；另外注意random.next(j)实际的产出是[0,j-1]包括0和j-1本身")
    public int[] shuffleBetter() {
        int[] clone = origin.clone();
        for (int i = clone.length - 1; i >= 1; i--) {
            int j = random.nextInt(i + 1);
            exchange(clone, i, j);
        }
        return clone;
    }

    public static void exchange(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
