package com.example.algo_0.f2;

import java.util.Iterator;

public class Main {

    public static class Node_{
        public String data;
        public Node_ next;
    }

    public static void main(String[] args) {

        // NB2, IntList
        IntList_2023 intLIst = new IntList_2023(2);
        for (int i = 0; i < 2; i++)
            intLIst.add(i+1);
        System.out.println("List of 1 & 2 " + intLIst);
        intLIst.add(3);
        System.out.println("List size: " + intLIst.size());
        intLIst.add(4);
        System.out.println("List size: " + intLIst.size());
        intLIst.add(5);
        System.out.println("List size: " + intLIst.size());
        intLIst.remove(2);
        System.out.println("List size: " + intLIst.size());
        System.out.println("After removing nr 3 in index 2: " + intLIst);
        System.out.println("intLIst.indexOf(2): " + intLIst.indexOf(2));
        intLIst.set(2, 2);
        System.out.println("intLIst.set(2, 2): " + intLIst);


/*
        LinkedList_2023<String> list = new LinkedList_2023<>();
        for (int i = 1; i <= 10; i++)  // O(n^2)
            list.add("Sträng " + i);
        Iterator<String> iter = list.iterator();
       // while (iter.hasNext()) { // O(n)

        System.out.println(iter.next());
            iter.remove();
        System.out.println(iter.next());
        iter.remove();
        System.out.println(iter.next());
        iter.remove();
        //}

 */


/*
        LinkedList_2023<Integer> list = new LinkedList_2023<>();
        for (int i = 1; i <= 10; i++)  // O(n^2)
            list.add(i);
        Iterator<Integer> iter = list.iterator();

        while (iter.hasNext()) {
            int nextInt = iter.next();
            System.out.println(nextInt);
            if (nextInt % 2 == 0)
                iter.remove();
        }

 */

    }
}
