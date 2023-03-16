package com.example.algo_0.f4;

import com.example.algo_0.f3.LinkedStack_2023;

public class LinkedListQueue_2023<E> {
    private Node_<E> head;
    private Node_<E> tail;
    private int size;

    public LinkedListQueue_2023() {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean enqueue(E element) {
        Node_<E> node = tail;
        tail = new Node_<>(element, null);
        if (isEmpty()) head = tail;
        else node.next = tail;
        size++;
        return true;
    }

    public E dequeue() {
        if (size == 0) return null;
        E element = head.data;
        head = head.next;
        size--;
        return element;
    }

    public int size() {
        return size;
    }

    private boolean isEmpty() {
        return size == 0;
    }


    private class Node_<E> {
        private E data;
        private Node_<E> next;

        public Node_(E data, Node_<E> next) {
            this.data = data;
            this.next = next;
        }
    }
}
