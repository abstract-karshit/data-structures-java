package heaps;

import java.util.PriorityQueue;

class CheckSmall {

    public static int[] findKSmallest(int[] arr, int k) {

        int[] result = new int[k];

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : arr) {
            pq.add(i);
        }

        for (int i = 0; i < k; i++) {
            result[i] = pq.poll();
        }
        return result;
    }
}

