package com.example.algo_0.f5;

public class PossiblePaths {

    public static int pp(int m, int n){
        if (m == 0 && n == 0)
            return 1;
        else {
            int count = 0;
            if (m > 0)
                count = pp(m - 1, n);
            if (n > 0)
                count += pp(m, n - 1);
            return count;
        }
    }
    public static void main(String[] args){
        System.out.println(pp(2, 2));
    }
}
