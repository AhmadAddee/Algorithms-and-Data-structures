package com.example.algo_0.f10;

public class NB29d {

    public static void sort(int[] data) {
        buildHeap(data);
        shrinkHeap(data);
    }

    private static void buildHeap(int[] data) {
        int n = 1;
        while (n < data.length) {
            n++;
            int child = n - 1;
            int parent = (child - 1) / 2;
            while (parent >= 0 && data[parent] < (data[child])) {
                swap(data, parent, child);
                child = parent;
                parent = (child - 1) / 2;
            }
        }
    }

    private static void shrinkHeap(int[] data) {
        int n = data.length;

        while (n > 0) {
            n--;
            swap(data, 0, n);
            int parent = 0;
            while (true) {
                int leftChild = 2 * parent + 1;
                if (leftChild >= n) {
                    break;
                }
                int rightChild = leftChild + 1;
                int maxChild = leftChild;
                if (rightChild < n && data[leftChild] < (data[rightChild])) {
                    maxChild = rightChild;
                }
                if (data[parent] < (data[maxChild])) {
                    swap(data, parent, maxChild);
                    parent = maxChild;
                } else {
                    break;
                }
            }

        }
    }

    private static void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
}
