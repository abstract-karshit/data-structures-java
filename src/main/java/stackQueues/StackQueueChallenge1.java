package stackQueues;

import java.util.LinkedList;
import java.util.Queue;

public class StackQueueChallenge1 {

    public static String[] findBin(int number) {
        String[] result = new String[number];
        Queue<String> queue = new LinkedList<>();
        queue.add("1");
        for (int i = 1; i <= number; i++) {
            String elem = queue.poll();
            result[i-1] = elem;
            queue.add(elem + "0");
            queue.add(elem + "1");
        }
        return result; //For number = 3 , result = {"1","10","11"};
    }

    public static void main(String[] args) {

    }
}
