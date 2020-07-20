package stackQueues;

import java.util.Arrays;
import java.util.Stack;

class NextGreaterChallenge {

    public static int[] nextGreaterElement(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.empty() && arr[i] > stack.peek()) {
                stack.pop();
            }
            if (stack.empty()) {
                result[i] = -1;
            } else {
                result[i] = stack.peek();
            }
            stack.push(arr[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {4, 6, 3, 2, 8, 1, 11};
        System.out.println(Arrays.toString(arr));
        int[] result = nextGreaterElement(arr);
        System.out.println(Arrays.toString(result));
    }
}