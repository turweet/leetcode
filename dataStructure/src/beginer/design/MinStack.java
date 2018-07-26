package beginer.design;


import summary.Attention;

public class MinStack {
    private Pair<Integer, Integer>[] container = new Pair[5];
    @Attention("注意这里min的初始值不必要设置成Int.Min，只需要在放置第一个item的时候给他设置一下内容就好了")
    private int min;
    private int curHeight = -1;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
    }

    public void push(int x) {
        if (curHeight == -1) {
            min = x;
        } else {
            if (x < min) min = x;
        }
        if (curHeight == container.length - 1) {
            resize();
        }
        container[curHeight + 1] = new Pair(x, min);
        curHeight++;
    }

    public void pop() {
        if (curHeight == -1) throw new IllegalStateException();
        curHeight--;
        if (curHeight >= 0) {
            min = container[curHeight].second;
        }
        //resize
    }

    public int top() {
        if (curHeight == -1) throw new IllegalStateException();
        return container[curHeight].first;
    }

    public int getMin() {
        if (curHeight == -1) throw new IllegalStateException();
        return (int) min;
    }

    private void resize() {
        Pair<Integer, Integer>[] temp = new Pair[container.length * 2];
        for (int i = 0; i < container.length; i++) {
            temp[i] = container[i];
        }
        container = temp;
    }

    @Attention("注意泛型的声明")
    public static class Pair<T, E> {
        public T first;
        public E second;

        public Pair(T first, E second) {
            this.first = first;
            this.second = second;
        }
    }
}
