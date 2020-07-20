package heaps;

import java.util.Arrays;

class Heap {
    int currentHeapSize;

    private void maxHeapify(int[] heapArray, int index, int heapSize) {
        int largest = index;
        while (largest < heapSize / 2) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;

            if (left < heapSize && heapArray[left] > heapArray[index]) {
                largest = left;
            }

            if (right < heapSize && heapArray[right] > heapArray[largest]) {
                largest = right;
            }

            if (largest != index) {
                int temp = heapArray[index];
                heapArray[index] = heapArray[largest];
                heapArray[largest] = temp;
                index = largest;
            } else {
                break;
            }
        }
    }

    public void buildMaxHeap(int[] heapArray, int heapSize) {
        if (heapSize == 0 || heapSize == 1) {
            return;
        }
        currentHeapSize = heapSize;
        for (int i = (heapSize - 1) / 2; i >= 0; i--) {
            maxHeapify(heapArray, i, heapSize);
        }
    }

    public int[] insert(int[] heapArray, int x, int heapSize) {
        int[] newHeapArray =  Arrays.copyOf(heapArray, heapSize + 1);
        newHeapArray[heapSize] = x;
        currentHeapSize++;
        int index = heapSize;
        int parent = (heapSize - 1) / 2;
        while (index > 0) {
            if (newHeapArray[parent] < newHeapArray[index]) {
                int temp = newHeapArray[index];
                newHeapArray[index] = newHeapArray[parent];
                newHeapArray[parent] = temp;
                index = parent;
                parent = (parent - 1) / 2;
            } else {
                break;
            }
        }
        return newHeapArray;
    }

    public void delete(int[] heapArray, int heapSize) {
        int temp = heapArray[0];
        heapArray[0] = heapArray[heapSize - 1];
        heapArray[heapSize - 1] = temp;
        currentHeapSize--;
        maxHeapify(heapArray, 0, currentHeapSize);
    }

    public static void main(String[] args) {
        int[] heapArray = {1, 4, 7, 12, 15, 14, 9, 2, 3, 16};
        System.out.println("Before heapify: " + Arrays.toString(heapArray));
        Heap heap = new Heap();
        heap.buildMaxHeap(heapArray, heapArray.length);
        System.out.println("After heapify: " + Arrays.toString(heapArray));

        heapArray = heap.insert(heapArray, 20, heapArray.length);
        System.out.println("After insert 20: " + Arrays.toString(heapArray));
        heap.delete(heapArray, heapArray.length);
        System.out.println("After delete 20: " + Arrays.toString(heapArray));

    }
}
