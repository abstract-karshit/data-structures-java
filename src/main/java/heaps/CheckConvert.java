package heaps;

class CheckConvert {

    public static void convertMax(int[] maxHeap) {
        Heap heap = new Heap();
        heap.buildMaxHeap(maxHeap, maxHeap.length);
    }

    public static void main(String[] args) {

    }
}