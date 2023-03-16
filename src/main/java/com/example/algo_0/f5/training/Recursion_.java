package com.example.algo_0.f5.training;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class Recursion_ {

    public static int count = 0;

    public static int fibonacci(int n) {
        count ++;
        if (n < 3)
            return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static int fibIterative(int finalN) {
        int fn = 1, minus1 = 1, minus2 = 1;
        count = 0;
        for (int i = 3; i <= finalN; i++) {
            fn = minus1 + minus2;
            minus2 = minus1;
            minus1 = fn;
            count++;
        }
        return fn;
    }

    public static int fakultet(int n) {
        count++;
        if (n == 1)
            return 1;
        return n * fakultet(n - 1);
    }

    public static int search(int index, int[] array, int target) {
        count++;
        if (index == array.length)
            return -1;
        if (array[index] == target)
            return index;
        return search(index + 1, array, target);
    }

    public static int binarySearch(int[] array, int start, int end, int target) {
        count++;
        if (start > end)
            return -1;
        else {
            int middle = (start + end) / 2;
            if (array[middle] == target)
                return middle;
            else if (array[middle] > target) {
                return binarySearch(array, start, middle - 1, target);
            } else
                return binarySearch(array, middle + 1, end, target);
        }
    }

    public static int gcd(int n, int m) {
        count++;
        if (m == 0)
            return n;
        return gcd(m, n % m);
    }

    public static int way(int n, int m) {
        if (n == 0 && n == 0)
            return 1;
        else {
            int count = 0;
            if (m > 0)
                count = way(n, m - 1);
            if (n > 0)
                count += way(n - 1, m);
            return count;
        }
    }

    public static void main(String[] args) {
        //System.out.println("Fiobnacci rec 20 = " + fibonacci(20) + ", count = " + count);
        //System.out.println("Fiobnacci it 20 = " + fibIterative(20) + ", count = " + count);
        //System.out.println("Fakultet of 20 = " + fakultet(10) + ", count = " + count);
        System.out.println(way(3, 2));
    }
}
