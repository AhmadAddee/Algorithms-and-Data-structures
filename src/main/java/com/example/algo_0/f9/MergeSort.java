package com.example.algo_0.f9;

import java.util.Arrays;

public class MergeSort {
    public static int[] merge(int[] left_arr, int[] right_arr, int[] newArr){
        int n = 0;
        int l = 0;
        int r = 0;

        while (l < left_arr.length && r < right_arr.length){
            if (left_arr[l] <= right_arr[r]) {
                newArr[n++] = left_arr[l];
                l++;
            }
            else {
                newArr[n++] = right_arr[r];
                r++;
            }
        }
        while (l < left_arr.length) {
            newArr[n++] = left_arr[l];
            l++;
        }
        while (r < right_arr.length) {
            newArr[n++] = right_arr[r];
            r++;
        }
        return newArr;
    }

    public static int[] mergeSort(int[] array){
        int n = array.length;
        if (array.length == 1)
            return array;

        int length = (n / 2);
        int[] left = new int[length];
        int[] right = new int[length];
        for (int i = 0; i < length; i++){
            left[i] = array[i];
        }
        int c = 0;
        for (int i = length; i < array.length; i++){
            System.out.println(i);
            right[c] = array[i];
            c++;
        }
        left = mergeSort(left);
        right = mergeSort(right);
        return merge(left, right, array);
    }

    public static void main(String[] args){
        int[] arr = {5, 4, 2, 6, 1, 3, 7, 10, 8, 12, 9, 11};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
