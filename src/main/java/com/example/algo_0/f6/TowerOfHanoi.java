package com.example.algo_0.f6;

public class TowerOfHanoi {
    static void hanoi(int n, int f, int t, int x){
        if (n > 0){
            hanoi(n - 1, f, x, t);
            System.out.println(f + " -> " + t);
            hanoi(n - 1, x, t, f);
        }
    }


    public static void main(String[] args){
        hanoi(3, 1, 2, 3);
    }
}
