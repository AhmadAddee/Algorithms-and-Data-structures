package com.example.algo_0.f1;

public class TillVaxt {
    // Linear tillväxt: tillväxthastigheten blir O(n)
    /*
    I snitt behöver man gå igenom n/2 av listan.
     */
    public static int search(int[] x, int target) {
        int index = -1;
        for (int i = 0; i < x.length; i++){
            if (x[i] == target)
                return i;
        }
        return index;
    }

    // tillväxthastigheten blir O(n x m)
    public static boolean areDifferent(int[] x, int[] y) {
        for (int i = 0; i < x.length; i++) {
                if (search(y, x[i]) != -1)
                    return false;
        }
        return true;
    }

    // Kvadratisk tillväxt: tillväxthastigheten blir O(n^2)
    public static boolean areUnique(int[] x) {
        for (int i = 0; i < x.length; i++){
            for (int j = 0; j < x.length; j++){
                if (i != j && x[i] == x[j])
                    return false;
            }
        }
        return true;
    }

    // Logaritmisk tillväxt: tillväxthastigheten blir O(log n)
    /*
    i = 1, 2, 4, 8,..., 2^(k-1) < x.length =< 2^k, där k är antal gånger loopen exekverar.
     */
    public static void logN(int[] x) {
        for (int i = 1; i < x.length; i *= 2) {
            // Do something with x[i]
        }
    }
}
