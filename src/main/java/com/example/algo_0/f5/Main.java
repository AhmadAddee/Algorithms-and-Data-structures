package com.example.algo_0.f5;

public class Main {
    private static int count = 0;
/*
    public static int findMax(int[] array, int start) {
        if (start == array.length - 1) { //Base case
            return array[start];
        }
        else { // Recursive case
            int max = findMax(array, start + 1);
            if (array[start] > max)
                return array[start];
            else
                return max;
        }
    }*/

    /****
     *
     * NB 11
     *
     */
    public static int findMaxValue(int[] arr) {
        return findMaxValue(arr, 0, arr.length - 1, 0);
    }

    public static int findMaxValue(int[] arr, int first, int last, int maxValue) {
        count++;
        if (first > last) return maxValue;
        if (arr[first] > maxValue) maxValue = arr[first];
        return findMaxValue(arr, first+1, last, maxValue);
    }

    /****
     *
     * NB 12
     *
     */
    /*
    public static int exponentRecursive(int x, int n) {
        if (n < 0) return -1;
        if (n == 0) return 1;
        count++;
        if (n == 1) return x;
        return x * exponentRecursive(x, n - 1);
    }

    public static int exponentIterative(int x, int n) {
        if (n < 0) return -1;
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= x;
        }
        return result;
    }*/

    /****
     *
     * NB 13
     *
     */
    /*
    public static double squareRootOf(double n) {
        return squareRootOf(n, 1, 2.718);
    }

    public static double squareRootOf(double n, int a, double e) {
        if (n == 0) return 0.000;
        double x = n / 2;
        double y = (x + (n/x))/2;
        if (Math.abs(x - y) < 0.001){
            return Math.round(y * 1000.0) / 1000.0;
        }
        return squareRootOf(y, a, e);
    }*/

    /****
     *
     * NB 15
     *
     */
    /*
    public static int binaryToInt(String binary) {
        if (binary.length() == 0) { // Base case
            return 0;
        }
        else {
            int lastDigit = binary.charAt(binary.length() - 1) - '0'; // Last digit of the binary number
            binary = binary.substring(0, binary.length() - 1); // Remove last digit
            return lastDigit + 2 * binaryToInt(binary); // Recursive call
        }
    }*/

    /****
     *
     * NB 14.1
     *
     */
    public static int getSwapCount(int blue, int white, int red, int maxDepth) {
        count++;
        // Base case - no need to swap
        if (blue == white && white == red) {
            return 0;
        }

        // End recursion if maxDepth is reached
        if (maxDepth == 0) {
            return 15;
        }

        // Calculate the min of the 3 swap operations
        int bToW = getSwapCount(blue - 1, white + 1, red + 3, maxDepth - 1);
        int wToB = getSwapCount(blue + 2, white - 1, red + 4, maxDepth - 1);
        int rToW = getSwapCount(blue + 1, white + 5, red - 1, maxDepth - 1);

        int minSwaps = Math.min(bToW, Math.min(wToB, rToW));
        return minSwaps + 1;
    }

    public static void main(String[] args) {
        //int[] n = {1, 2, 5, 2, 9, 0};

        /****
         * @TEST
         * NB 11
         */
        /*
        System.out.println("_________________NB 11________________");
        System.out.println("The max value found in the array is: " + findMaxValue(n));
        System.out.println(count);*/

        /****
         * @TEST
         * NB 12
         */
        /*
        System.out.println("_________________NB 12________________");
        System.out.println("The result of 4^3 is: " + exponentCursive(4, 5));
        System.out.println("The result of 4^3 is: " + exponentIterative(4, 5));
        System.out.println(count);*/

        /****
         * @TEST
         * NB 13
         */
        //System.out.println(squareRootOf(25, 5, 5));

        /****
         * @TEST
         *
         */
        //System.out.println(findMax(n, 0));

        /****
         * @TEST
         * NB 15
         */
        //System.out.println("The result is:" + binaryToInt("1011"));

        /****
         * @TEST
         * NB 14.1
         */
        System.out.println(getSwapCount(5, 1, 3, 15));
        System.out.println(count);
    }
}
