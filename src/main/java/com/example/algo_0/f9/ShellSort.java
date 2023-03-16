package com.example.algo_0.f9;

import java.util.Arrays;

public class ShellSort {
    private static int count = 0;

    public static int[] sort(int[] array){
        int interval = array.length / 2;

        while (interval > 0){
            for (int index = interval; index < array.length; index++){
                int data = array[index];
                int dataIndex = index;
                while (dataIndex > interval - 1 && data < array[dataIndex - interval]){
                    count++;
                    System.out.println("interval is " + interval + " switching " + array[dataIndex - interval] + " into " + array[dataIndex]);
                    array[dataIndex] = array[dataIndex - interval];
                    dataIndex -= interval;
                }
                array[dataIndex] = data;
            }
            if (interval == 2)
                interval = 1;
            else
                interval /= (int) 2.2;
        }
        return array;
    }

    public static void main(String[] args){
        int[] arr = {5, 4, 2, 6, 1, 3, 7, 10, 8, 9};
        arr = sort(arr);
        System.out.println(count);
        System.out.println(Arrays.toString(arr));
    }
}
