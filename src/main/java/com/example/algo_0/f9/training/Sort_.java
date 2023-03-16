package com.example.algo_0.f9.training;

public class Sort_ {

    public static void selectionSort(int[] array) {
        for (int index = 0; index < array.length - 1; index++) {
            int minIndex = index;
            for (int i = index + 1; i < array.length; i++) {
                if (array[i] < array[minIndex])
                    minIndex = i;
            }
            int tmp = array[minIndex];
            array[minIndex] = array[index];
            array[index] = tmp;
        }
    }

    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int tmp = array[i]; int dataIndex = i-1;
            while (dataIndex > 0 && array[dataIndex] > tmp) {
                array[dataIndex + 1] = array[dataIndex];
                dataIndex--;
            }
            array[dataIndex +1] = tmp;
        }
    }

    public static void shellSort(int[] array) {
        int gap = array.length/2;
        while (gap > 0) {
            for (int index = gap; index < array.length; index++) {
                int data = array[index]; int dataIndex = index;
                while (dataIndex > (gap-1) && data < array[dataIndex-gap]) {
                    array[index] = array[dataIndex-gap];
                    dataIndex -= gap;
                }
                array[dataIndex] = data;
            }
            if (gap == 2)
                gap = 1;
            else gap /= 2.2;
        }
    }

    private static void merge(int[] array, int[] b, int[] c) {
        int indexa = 0, indexb = 0, indexc = 0;
        while (indexa < array.length && indexb < b.length) {
            if (array[indexa] <= b[indexb])
                c[indexc++] = array[indexa++];
            else c[indexc++] = b[indexb++];
        }
        while (indexa < array.length)
            c[indexc++] = array[indexa++];
        while (indexb < b.length)
            c[indexc++] = b[indexb++];
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 7, 4, 10, 3, 6, 9, 8};
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("\nSort:");
        shellSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
