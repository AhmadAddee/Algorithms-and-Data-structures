package com.example.algo_0.f9;

/***
 * Is used in e.g. shellsort, mergesort and quicksort.
 * This algorithm breaks down a problem into two (or more) sub problem of the same (or close) type.
 * These sub problem get also broken down into smaller problem.
 * Recursion is used to implement this type of algorithm.
 */
public class SondraHarska {

    public static int max(int[] a, int low, int high){
        if (low == high) {
            return a[low];
        }
        else {
            int m1, m2;
            m1 = max(a, low, (low+high)/2);
            m2 = max(a, (low + high) / 2+1, high);
            if (m1 < m2) {
                return m2;
            }
            else {
                return m1;
            }
        }
    }

    public static int mini(int[] a, int low, int high){
        if (low == high)
            return a[low];
        else {
            int m1, m2;
            m1 = mini(a, low, (high+low) /2);
            m2 = mini(a, (low+high) / 2+1, high);
            if (m1 < m2)
                return m1;
            else
                return m2;
        }
    }

    public static int exp(int base, int expon){
        if (expon == 1)
            return base;
        if (expon == 0)
            return 1;
        int p = exp(base, expon/2);
        if (expon % 2 == 0)
            return p * p;
        return p * p * base;
    }

    public static int dubble(int a, int times){
        for (int i = 1; i <= times; i++)
            a *= 2;
        return a;
    }

    public static void main(String[] args){
        int[] arr = {5, 4, 2, 6, 1, 3, 7, 10, 8, 9, 25, 22, 13, 14, 12, 20, 11, 19, 15, 21, 20, 16, 17, 23, 18, 22, 24};
        int result = max(arr, 0, 24);
        System.out.println(result);
        System.out.println(mini(arr, 0, 24));
        System.out.println(exp(2, 30));
        System.out.println(dubble(1, 30));
    }
}
