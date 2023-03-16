package com.example.algo_0.f10;

import java.util.Arrays;

public class NB30 {

    public static <T extends Comparable<T>> void sort(T[] data) {
        buildHeap(data);
        shrinkHeap(data);
    }

    private static <T extends Comparable<T>> void buildHeap(T[] data) {
        int n = 1;
        while (n < data.length) {
            n++;
            int child = n - 1;
            int parent = (child - 1) / 2;
            while (parent >= 0 && data[parent].compareTo(data[child]) < 0) {
                swap(data, parent, child);
                child = parent;
                parent = (child - 1) / 2;
            }
        }
    }

    private static <T extends Comparable<T>> void shrinkHeap(T[] data) {
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
                if (rightChild < n && data[leftChild].compareTo(data[rightChild]) < 0) {
                    maxChild = rightChild;
                }
                if (data[parent].compareTo(data[maxChild]) < 0) {
                    swap(data, parent, maxChild);
                    parent = maxChild;
                } else {
                    break;
                }
            }
        }
    }

    private static <T extends Comparable<T>> void swap(T[] data, int i, int j) {
        T temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    public static void main(String[] args){
        Integer[] arr = {5, 4, 2, 6, 1, 3, 7, 10, 8, 9};
        sort(arr);
        String[] str = new String[10];
        str[0] = "String A";
        str[1] = "String F";
        str[2] = "String G";
        str[3] = "String C";
        str[4] = "String J";
        str[5] = "String B";
        str[6] = "String E";
        str[7] = "String H";
        str[8] = "String D";
        str[9] = "String I";

        sort(str);

        System.out.println(Arrays.toString(str));
    }
}
