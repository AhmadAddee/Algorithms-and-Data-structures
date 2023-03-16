package com.example.algo_0.f9;

/****
 * Best and worst case in number of comparisons are both same O(n^2)
 * Best and worst case in number of exchanges are both same O(n)
 */
public class SelectionSort {

    private static int count = 0;

    public static void sort(int[] array){
        for (int index = 0; index < array.length - 1; index++){
            for (int j = index + 1; j < array.length; j++){
                count++;
                if (array[j] < array[index]){
                    int mini = array[index];
                    array[index] = array[j];
                    array[j] = mini;
                }
            }
        }
/*
        for (int index = 0; index < array.length -2; index++) {
            int minIndex = index;
            for (int i = index+1; i < array.length -1; i++) {
                if (array[i] < array[minIndex])
                    minIndex = i;
                int tmp = array[index];
                array[index] = array[minIndex];
                array[minIndex] = tmp;
            }
        }
 */
    }

    public static void main(String[] args){
        int[] arr = {5, 4, 2, 6, 1, 3, 7, 10, 8, 9};
        SelectionSort.sort(arr);
        System.out.println(count);
        for (int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }
}
