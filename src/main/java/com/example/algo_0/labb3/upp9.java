package com.example.algo_0.labb3;

import java.util.Arrays;
import java.util.Random;

public class upp9 {

    private int[] arrayToSort;

    public upp9(int[] arrayToSort){
        this.arrayToSort = arrayToSort;
    }

    public void radixSort() {
        // first get the element with the max value in the array
        // int max = Arrays.stream(arrayToSort).max().orElse(Integer.MAX_VALUE);
        int max = getMaxElementInArray();
        int exp = 1;
        // next step is to counting-sort the array first by the
        // least significant digit up to the most significant digit
        while (max / exp > 0) {
            countingSort(exp);
            exp = exp * 10;
        }
    }

    private int getMaxElementInArray() {
        int max = arrayToSort[0];
        for (int i = 1; i < arrayToSort.length; i++) {
            if (arrayToSort[i] > max) {
                max = arrayToSort[i];
            }
        }
        return max;
    }

    // Throwing a new exp-value everytime until exp-value is as big as max-value
    private void countingSort(int exp) {
        int n = arrayToSort.length;
        int[] outputArray = new int[n];
        int[] countArray = new int[10];

        // Counting every single element in the array
        for (int value : arrayToSort) {
            countArray[(value / exp) % 10]++;
        }
        // Counting every end position of each element
        for (int i = 1; i < 10; i++) {
            countArray[i] += countArray[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            countArray[(arrayToSort[i] / exp) % 10]--;
            outputArray[countArray[(arrayToSort[i] / exp) % 10]] = arrayToSort[i];
        }

        for (int i = 0; i < outputArray.length; i++) {
            arrayToSort[i] = outputArray[i];
        }
        System.out.println("Counting sort at exp " + exp + " " + Arrays.toString(arrayToSort));
    }

    public boolean IsSorted(){
        for(int i = 1; i < arrayToSort.length; i++){
            if(arrayToSort[i] < arrayToSort[i-1]){
                return false;
            }
        }
        return true;
    }



    public static void main(String[] args) {

        Random rand = new Random();
        int[] arr = new int[1_000_000];

        for (int i = 0; i < arr.length; i++) {

            arr[i] = rand.nextInt(1_000_000);
        }

        //System.out.println("\nOriginal Array " + Arrays.toString(arr) + "\n");
        long start = System.currentTimeMillis();
        upp9 sort = new upp9(arr);
        sort.radixSort();
        System.out.println(sort.IsSorted());
        long end = System.currentTimeMillis();
        long time = end - start;
        System.out.println("Time is " + time + " ms");
    }
}
