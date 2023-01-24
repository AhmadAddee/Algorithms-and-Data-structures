package com.example.algo_0.f2;


/*****
 * Dubbellänkad lista:***************
 + Vi kan sätta in före och efter en nod vi har en referens till.
 + Vi kan ta bort en nod utan att ha en referens till noden innan.
 + Vi kan traversera listan åt bägge håll.
 + Att sätta in n st element sist i en tom lista blir O(n)

 * Cirkulär lista:************
 + Vi kan traversera hela listan från godtyckligt element.
 + Riskerar inte att falla av listan.
 - Måste dock undvika oändliga loopar.
 */

public class DubbleLinkedList_2023<E>{
    private Node_<E> head;
    private Node_<E> tail;
    private int size;

    public DubbleLinkedList_2023() {
        head = null;
        tail = null;
        size = 0;
    }

    public void add(int index, E element) {


    }


    private class Node_<E>{
        private Node_ <E> next;
        private Node_<E> prev;
        private E data;
    }
}
