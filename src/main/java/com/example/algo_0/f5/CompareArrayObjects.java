package com.example.algo_0.f5;

public class CompareArrayObjects <E>{

    /**Find a target number through recursion using a wrapper, O(n) */
    public static int linearSearch(Object[] arr, Object target){
        return linearSearch(arr, target, 0);
    }

    private static int linearSearch(Object[] arr, Object target, int position){
        if (position == arr.length)
            return -1;
        else if (arr[position].equals(target))
            return position;
        else
            return linearSearch(arr, target, position + 1);
    }


    public static void main(String[] args){
        String[] str = new String[10];
        for (int i = 0; i < str.length; i++)
            str[i] = "String " + (i + 1);
        System.out.println(linearSearch(str, "String 6"));
    }
}
