package stackQueues;

class ReverseKChallenge <V> {

    public static <V> void reverseK(Queue<V> queue, int k) {
        Queue<V> tempQueue = new Queue<>(queue.getMaxSize() - k);
        Stack<V> tempStack = new Stack<>(k);

        int count = 0;
        while (!queue.isEmpty()) {
            V elem = queue.dequeue();
            if (count < k) {
                count++;
                tempStack.push(elem);
            } else {
                tempQueue.enqueue(elem);
            }
        }

        while (!tempStack.isEmpty()) {
            V elem = tempStack.pop();
            queue.enqueue(elem);
        }

        while (!tempQueue.isEmpty()) {
            V elem = tempQueue.dequeue();
            queue.enqueue(elem);
        }
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>(5);

        queue.enqueue(5);
        queue.enqueue(8);
        queue.enqueue(9);
        queue.enqueue(12);
        queue.enqueue(4);

        reverseK(queue, 4);

        System.out.println();

    }
}