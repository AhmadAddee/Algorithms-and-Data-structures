package com.example.algo_0.f10;

import java.util.Arrays;

import static com.example.algo_0.f10.NB29d.sort;

public class Main {

    public static void main(String[] args) {
        /****
         *
         * @TEST: NB 30
         */
        Heap<String> heap = new Heap<String>();
        heap.add("b");
        heap.add("f");
        heap.add("e");
        heap.add("h");
        heap.add("a");
        heap.add("d");
        heap.add("g");
        heap.add("c");
        while (heap.size() > 0) {
            System.out.print(heap.remove() + " ");
        }

        /****
         *
         * @TEST: NB 29d
         */
        int[] arr = {5, 4, 2, 6, 1, 3, 7, 10, 8, 9};
        sort(arr);
        System.out.println("\n" + Arrays.toString(arr));
    }
}
