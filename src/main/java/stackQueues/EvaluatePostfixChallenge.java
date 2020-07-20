package stackQueues;

import java.util.Objects;
import java.util.Stack;

class EvaluatePostfixChallenge {

    public static int evaluatePostFix(String expression) {
        if (Objects.isNull(expression) || expression.isEmpty()) {
            return Integer.MIN_VALUE;
        }

        Stack<String> buffer = new Stack<>();
        buffer.push(String.valueOf(expression.charAt(0)));

        for (int i = 1; i < expression.length(); i++) {
            String c = String.valueOf(expression.charAt(i));
            if (isOperator(c)) {
                int right = Integer.parseInt(buffer.pop());
                int left = Integer.parseInt(buffer.pop());
                buffer.push(String.valueOf(compute(c, left, right)));
            } else {
                buffer.push(c);
            }
        }

        return Integer.parseInt(buffer.pop());

    }

    static boolean isOperator(String op) {
        return "*".equals(op) || "/".equals(op) || "+".equals(op) || "-".equals(op);
    }

    static int compute(String op, int left, int right) {
        switch (op) {
            case "+": {
                return left + right;
            }
            case "*": {
                return left * right;
            }
            case "-": {
                return left - right;
            }
            case "/": {
                return left / right;
            }
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(evaluatePostFix("921*-8-4+"));
    }
}