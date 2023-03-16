package com.example.algo_0.f9;

/****
 * Best case in both number of comparisons and number of exchanges is O(n)
 * Worst case in both number of comparisons and number of exchanges is O(n^2)
 */
public class InsertionSort {

    private static int count = 0;

    public static void insertionSort(int[] arr){
        for (int index = 1; index < arr.length; index++){
            int data = arr[index];
            int dataIndex = index;
            while (dataIndex > 0 && data < arr[index-1]){
                count++;
                arr[dataIndex] = arr[dataIndex - 1];
                dataIndex--;
            }
            arr[dataIndex] = data;
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 4, 2, 6, 1, 3, 7, 10, 8, 9};
        insertionSort(arr);
        System.out.println(count);
        for (int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }
}
