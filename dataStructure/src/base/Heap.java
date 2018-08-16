package base;

import org.junit.Test;

import java.util.PriorityQueue;

public class Heap {
    @Test
    public void test() {
        int[] a = {1,23,452,323,44,5};
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(a.length);
        for (int i = 0; i < a.length; i++) {
            priorityQueue.add(a[i]);
        }
        for (int i = 0; i < a.length; i++) {
            a[i] = priorityQueue.remove();
        }
        for (int i :
                a) {
            System.out.println(i);
        }

    }
}
