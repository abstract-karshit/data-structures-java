package stackQueues;

import java.util.Stack;

public class MinStack {

    int maxSize;
    int currentSize = 0;
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    //constructor
    public MinStack(int maxSize) {
        // Write -- Your -- Code
        this.maxSize = maxSize;
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    //removes and returns value from stack
    public Integer pop() {
        // Write -- Your -- Code
        if (!stack.empty()) {
            minStack.pop();
            currentSize--;
            return stack.pop();
        }
        return Integer.MIN_VALUE;
    }

    //pushes value into the stack
    public void push(Integer value) {
        // Write -- Your -- Code
        if (currentSize > maxSize) {
            return;
        }
        stack.push(value);
        currentSize++;
        if (minStack.empty()) {
            minStack.push(value);
        } else {
            int min = Math.min(value, minStack.peek());
            minStack.push(min);
        }
    }

    //returns minimum value in O(1)
    public int min() {
        // Write -- Your -- Code
        if (!minStack.empty()) {
            return minStack.peek();
        }
        return Integer.MIN_VALUE;
    }
}
