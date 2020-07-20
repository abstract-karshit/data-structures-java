package stackQueues;

class SortValuesChallenge {

    public static void sortStack(Stack<Integer> stack) {
        // Write -- Your -- Code
        java.util.Stack<Integer> buffer = new java.util.Stack<>();
        if (stack.isEmpty()) {
            return;
        }

        while (!stack.isEmpty()) {
            int elem = stack.pop();
            if (buffer.empty()) {
                buffer.push(elem);
            } else {
                while (!buffer.empty() && buffer.peek() > elem) {
                    stack.push(buffer.pop());
                }
                buffer.push(elem);
            }
        }

        while (!buffer.empty()) {
            stack.push(buffer.pop());
        }
    }
}