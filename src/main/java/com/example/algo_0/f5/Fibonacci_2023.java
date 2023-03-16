package com.example.algo_0.f5;

import javax.swing.plaf.IconUIResource;
import java.util.Arrays;

public class Fibonacci_2023 {
    private static int count = 0;
    public static int fib (int n) {
        count++;
        return (n == 1 || n == 2) ?
                1 :
                fib(n -1) + fib(n - 2);

    }

    public static int fibWithFn(int n) {
        return fn(1, 1, 3, n);
    }

    public static int fn(int fnMinus1, int fnMinus2, int n, int nFinal) {
        count++;
        return (n == nFinal) ?
                fnMinus1 + fnMinus2 :
                fn(fnMinus1+fnMinus2, fnMinus1, n+1, nFinal);
    }

    public static int fibIterative(int nFianl) {
        int fn = 1, fnMinus1 = 1, fnMinus2 = 1;

        for (int n = 3; n <= nFianl; n++) {
            count++;
            fn = fnMinus1 + fnMinus2;
            fnMinus2 = fnMinus1;
            fnMinus1 = fn;
        }
        return fn;
    }

    public static int faculty(int n) {
        count++;
        return (n == 0) ?
                1 :
                n * faculty(n - 1);
    }

    public static int linearSearch(Object[] arr, int target) {
        return linearSearch(arr, target, 0);
    }

    public static int linearSearch(Object[] arr, int target, int position) {
        return (arr.length == position) ?
                -1 :
                (arr[position].equals(target)) ?
                        position :
                        linearSearch(arr, target, position + 1);
    }

    public static int binarySearch(int[] arr, int target) {
        return binarySearch(arr, target, 0, arr.length - 1);
    }

    public static int binarySearch(int[] arr, int target, int first, int last) {
        count++;

        int middle = (first + last) / 2;
        return (first > last) ?
                -1 :
                (arr[middle] == target) ?
                        middle :
                        (arr[middle] > target) ?
                                binarySearch(arr, target, first, middle - 1) :
                                binarySearch(arr, target,middle + 1, last);
    }

    public static int gcd(int first, int second) {
        count++;
        int divisor = first / second;
        if (divisor == 0) return -1;
        int rest = first % second;
        if (rest == 0) return second;

        return gcd(second, rest);
    }

    public static int roads(int m, int n) {
        count++;
        if (n == 0  && m == 0)
            return 1;
        System.out.println("(" + m + ", " + n + ")");
        int amout = 0;
        if (m > 0) amout = roads(m-1, n);
        if (n > 0) amout = amout + roads(m, n-1);
        return amout;
    }

    public static void main(String[] args) {
        int[] arr = new int[1000000];
        for (int i = 0; i < arr.length; i++)
            arr[i] = i + 1;
        System.out.println(roads(2, 3));
        System.out.println(count);

    }
}
