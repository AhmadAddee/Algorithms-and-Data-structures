package com.example.algo_0.f5;

public class Fibonaci {

    /**Find Fibonacci-number through recursion, O(2^n) */
    public static int rekursFib(int n){
        if (n == 1 || n == 2) {
            return 1;
        }
        else {
            return rekursFib(n - 1) + rekursFib(n - 2);
        }
    }

    /**Find Fibonacci-number through iteration, O(n)*/
    public static int iterationFib(int fFinal){
        int fn = 1, fnMinus1 = 1, fnMinus2 = 1;
        for (int n = 3; n <= fFinal; n++){
            fn = fnMinus1 + fnMinus2;
            fnMinus2 = fnMinus1;
            fnMinus1 = fn;
        }
        return fn;
    }

    /**Find Fibonacci-number through recursion using a wrapper */
    public static int svansRekursivtFib(int n){ //wrapper, kräver n > 2
        if (n <= 2)
            throw new IllegalArgumentException("The number should be greater than 2!");
        return fn(1, 1, 3, n);
    }

    private static int fn(int fnMinus1, int fnMinus2, int n, int nFinal){
        if (n == nFinal)
            return fnMinus1 + fnMinus2;
        else
            return fn(fnMinus1 + fnMinus2, fnMinus1, n + 1, nFinal);
    }


    public static void main(String[] args){
        System.out.println(svansRekursivtFib( 55));
    }

}
