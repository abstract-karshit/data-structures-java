package stackQueues;

import java.util.Stack;

class QueueWithStack<V> {

    Stack<V> stack1;
    Stack<V> stack2;
    int currentSize = 0;
    int maxSize;

    public QueueWithStack(int maxSize) {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
        this.maxSize = maxSize;
    }

    public void enqueue(V value) {
        // Write -- Your -- Code
        if (currentSize >= maxSize) {
            return;
        }
        stack1.push(value);
        currentSize++;
    }

    public V dequeue() {
        V elem = null;
        if (stack1.empty()) {
            return elem;
        }

        while (!stack1.empty()) {
            stack2.push(stack1.pop());
            if (stack1.size() == 1) {
                elem = stack1.pop();
                currentSize--;
            }
        }

        while (!stack2.empty()) {
            stack1.push(stack2.pop());
        }
        return elem;
    }

    public boolean isEmpty() {
        //Write -- Your -- Code
        return stack1.empty();
    }
}
