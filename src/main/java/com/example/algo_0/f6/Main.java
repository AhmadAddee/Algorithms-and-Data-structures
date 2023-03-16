package com.example.algo_0.f6;

import javax.swing.plaf.IconUIResource;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static long count = 1L;

    public static int hissen(int n, int up, int down, int destination, int position, int amountTrip) {
        count++;
        if (position == destination)
            return amountTrip;
        else if (amountTrip > 30) /**********///??????????????????????
            return Integer.MAX_VALUE;

        int amountUp = Integer.MAX_VALUE, amountDown = Integer.MAX_VALUE;
        if (position + up <= n)
            amountUp = hissen(n, up, down, destination, position + up, amountTrip + 1);
        if (position - down >= 0)
            amountDown = hissen(n, up, down, destination, position - down, amountTrip + 1);

        return Math.min(amountUp, amountDown);
    }

    public static int hissen(int n, int up, int down, int destination) {
        return hissen(n, up, down, destination, 1, 0);
    }

    public static int amountTripWidth(int n, int up, int down, int destination) {
        Queue<Status> q = new LinkedList<>();
        Status s = new Status(1, 0);

        while (s.position != destination) {
            count++;
            if (s.position + up <= n)
                q.offer(new Status(s.position+up, s.amountTrip+1));
            if (s.position - down >= 1)
                q.offer(new Status(s.position-down, s.amountTrip+1));
            s = q.poll();
        }
        return s.amountTrip;
    }

    public static void towerOfHanoi(int n, int f, int t, int x){
        count++;
        if( n > 0) {
            towerOfHanoi(n-1, f, x, t);
            //System.out.println(f + "->" + t);
            towerOfHanoi(n-1, x, t, f);
        }
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

        /*****
         * @Test NB 17
         */
        LinkedList_Rec<String> list = new LinkedList_Rec<>();
        for (int i = 1; i <= 6; i++)
            list.add("e"+i);
        System.out.println(list.size());
        System.out.println(list.get(3));

        /*****
         * @Test NB 16
         */
        //System.out.println(exchange(5, 1, 3));

        System.out.println(amountTripWidth(100, 15, 8, 2));
        System.out.println(count);
    }

    public static class Status {
        private int position;
        private int amountTrip;

        public Status(int position, int amountTrip) {
            this.position = position;
            this.amountTrip = amountTrip;
        }
    }

    public static class Node_<E>{
        private E data;
        private Node_<E> next;

        private void toStringRec(StringBuilder sb, Node_<E> p) {
            sb.append(p.data.toString());
            if (p.next != null) {
                sb.append(" ==> ");
                toStringRec(sb, p.next);
            }
        }

        public String toStringRec() {
            StringBuilder sb = new StringBuilder("[");
            if (next != null) toStringRec(sb, next);
            sb.append("]");
            return sb.toString();
        }
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
