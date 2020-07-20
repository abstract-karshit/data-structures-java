package heaps;

import java.util.Collections;
import java.util.PriorityQueue;

class CheckLarge {

    public static int[] findKLargest(int[] arr, int k) {
        int[] result = new int[k];
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i : arr) {
            pq.add(i);
        }

        for (int i = 0; i < k; i++) {
            result[i] = pq.poll();
        }
        return result;
    }
}
