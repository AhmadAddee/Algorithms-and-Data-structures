package com.example.algo_0.f5;

public class Factorial {

    /**Find faculty-number through recursion, O(n)*/
    public static int facRe(int n){
        if (n == 0)
            return 1;
        else
            return n * facRe(n - 1) ;
    }//less effective 'cause it can lead to overhead

    /**Find faculty-number through iteration, O(n)*/
    public static int facIter(int nFinal){
        int fakn = 1;
        for (int n = 2; n <= nFinal; n++)
            fakn *= n;
        return fakn;
    }





    public static void main(String[] args){
        System.out.println(facIter(6));
    }
}
