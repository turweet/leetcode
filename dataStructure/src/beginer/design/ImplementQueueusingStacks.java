package beginer.design;

import java.util.Stack;

public class ImplementQueueusingStacks {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    private int peek;

    /**
     * Initialize your data structure here.
     */
    public ImplementQueueusingStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        if (stack1.isEmpty()) {
            stack1.push(x);
            peek = x;
        } else {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            stack1.push(x);
            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
                peek = stack1.peek();
            }
        }
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        int x = stack1.pop();
        if (stack1.size() > 0) {
            peek = stack1.peek();
        }
        return x;
    }

    /**
     * Get the front element.
     */
    public int peek() {
        return peek;
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return stack1.isEmpty();
    }
}
