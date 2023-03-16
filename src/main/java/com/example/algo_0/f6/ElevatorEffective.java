package com.example.algo_0.f6;

import java.util.LinkedList;
import java.util.Queue;

public class ElevatorEffective {

    private static class Tillstand{
        private int position, antalresor;
        public Tillstand(int p, int n){
            position = p;
            antalresor = n;
        }
    }

    /** Uses a queue to effective the recursion, since it searches in width and not deep.
     * */
    public static int antalResorHiss(int n, int upp, int ned, int dest){
        Queue<Tillstand> q = new LinkedList<Tillstand>();
        Tillstand t = new Tillstand(1, 0);

        while (t.position != dest){
            if (t.position + upp <= n)
                q.offer(new Tillstand(t.position + upp, t.antalresor + 1));
            if (t.position - ned >= 1)
                q.offer(new Tillstand(t.position - ned, t.antalresor + 1));
            t = q.poll();
            System.out.println(t.position + "   " + t.antalresor);
        }
        return t.antalresor;
    }

    public static void main(String[] args){
        System.out.println(antalResorHiss(7, 3, 1, 2));
    }
}
