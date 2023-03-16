package com.example.algo_0.f6.training;

import javax.swing.plaf.basic.BasicTreeUI;
import java.util.LinkedList;
import java.util.Queue;

public class BackTracking_ {

    private static class Tillstand {
        public int position, antatResor;
        public Tillstand(int p, int a) {
            position = p;
            antatResor = a;
        }
    }

    private static int coutnt;
    public static int amountTravel(int n, int up, int down, int destination) {
        return amountTravel(n, up, down, destination, 1, 0);
    }

    public static int amountTravel(int n, int up, int down, int destination, int position, int amount) {
        Queue<Tillstand> queue = new LinkedList<>();
        Tillstand t = new Tillstand(1, 0);

        while (t.position != destination) {
            coutnt++;
            if ((t.position + up) <= n)
                queue.offer(new Tillstand(t.position + up, t.antatResor + 1));
            if ((t.position - down) <= 1)
                queue.offer(new Tillstand(t.position - down, t.antatResor + 1));
            t = queue.poll();
        }

        return t.antatResor;
/*
        if (position == destination)
            return amount;
        else if (amount > 30)
            return Integer.MAX_VALUE;
        else {
            int antalUpp = Integer.MAX_VALUE, antalNed = Integer.MAX_VALUE;
            if (position < destination && (position + up) <= n)
                antalUpp = amountTravel(n, up, down, destination, position + up, amount + 1);
            if (position > destination && (destination - down) > 0)
                antalNed = amountTravel(n, up, down, destination, position - down, amount + 1);
            return Integer.min(antalUpp, antalNed);
        }

 */
    }

    public static void tornetIHanoey(int n, int f, int t, int x) {
        if (n > 0) {
            tornetIHanoey(n - 1, f, x, t);
            System.out.println(f+"->"+t);
            tornetIHanoey(n -1, x, t, f);
        }
    }

    public static boolean hittaUt(boolean[][] labrynt, int x, int y){
        coutnt++;
        if (labrynt[x][y])
            return true;
        else {
            if (x > 0 && labrynt[x - 1][y])
                if (hittaUt(labrynt, x - 1, y))
                    return true;
            if (y < 5 && labrynt[x][y + 1])
                if (hittaUt(labrynt, x, y + 1))
                    return true;
            if (x < 5 && labrynt[x + 1][y])
                if (hittaUt(labrynt, x + 1, y))
                    return true;
            if (y > 0 && labrynt[x][y - 1])
                if (hittaUt(labrynt, x, y - 1))
                    return true;
            labrynt[x][y] = false;
            return false;
        }
    }

    public static void main(String[] args) {
        String[][] labrynt = new String[6][6];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (i != 0 && i != 5 && j != 0 && j != 5)
                    labrynt[i][j] = "O ";
                else labrynt[i][j] = "X ";
            }
        }

        labrynt[5][4] = "O ";

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print(labrynt[i][j]);
            }
            System.out.println();
        }


        //System.out.println(hittaUt(labrynt, 0, 0));
        //System.out.println(coutnt);
    }
}
