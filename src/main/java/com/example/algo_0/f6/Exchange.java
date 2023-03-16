package com.example.algo_0.f6;

import java.util.LinkedList;
import java.util.Queue;

public class Exchange {
    private static int count = 0;

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

    /*****
     *
     * @ NB 16
     */
    public static int exchange(int blue, int white, int red) {
        return exchange1(blue, white, red, 0);
    }

    public static int exchange1(int blue, int white, int red, int ex) {
        Queue<Tillstand> q = new LinkedList<>();
        Tillstand t = new Tillstand(blue, white, red);

        while(t.blue != t.white || t.white != t.red) {
            ex++;
            if (t.blue > 0)
                q.offer(new Tillstand(t.blue - 1, t.white + 1, t.red + 3));
            if (t.white > 0)
                q.offer(new Tillstand(t.blue + 2, t.white - 1, t.red + 4));
            if (t.red > 0)
                q.offer(new Tillstand(t.blue + 1, t.white + 5, t.red - 1));
            t = q.poll();
        }
        return ex;
    }

    public static void main(String[] args) {
        /****
         * @TEST
         * NB 14.1
         */
        System.out.println(getSwapCount(5, 1, 3, 15));
        System.out.println(count);

        /*****
         * @Test NB 16
         */
        System.out.println(exchange(5, 1, 3));
    }

    public static class Tillstand {
        private int blue, white, red;

        public Tillstand(int blue, int white, int red) {
            this.blue = blue;
            this.white = white;
            this.red = red;
        }
    }
}
