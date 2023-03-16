package com.example.algo_0.f5;

public class BinarySearch {

    /**Binary searching tree. compare the element in the middle first of all.
     * if the target is less than the middle recurs the left side,
     * otherwise search through the right side.
     * O(log(n))
     * **/
    private static int search(Object[] arr, Comparable target, int firstPos, int last){
        if (firstPos > last)
            return -1;
        else{
            int middle = (firstPos + last) / 2;
            int compResult = target.compareTo(arr[middle]);
            if (compResult == 0)
                return middle;
            else if (compResult < 0)
                return search(arr, target, firstPos, middle - 1);
            else
                return search(arr, target, middle + 1, last);
        }
    }

    public static int search(Object[] arr, Comparable target){ //a wrapper
        return search(arr, target, 0,arr.length - 1);
    }

    public static void main(String[] args){
        System.out.println(gcd(78, 21));
    }


    /**Greater common divisor, taking two numbers and using recursion to find out the shit.
     * **/
    public static int gcd(int firstOne, int secondOne){
        return gcdSolver(firstOne / secondOne, firstOne % secondOne);
    }

    private static int gcdSolver(int firstOne, int secondOne){
        if (secondOne == 0)
            return firstOne;
        else
            return gcdSolver(secondOne, firstOne % secondOne);
    }
}
