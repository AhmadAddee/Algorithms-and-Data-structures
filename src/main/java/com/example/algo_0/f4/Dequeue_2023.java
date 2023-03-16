package com.example.algo_0.f4;

public class Dequeue_2023<E> {
    private Node_<E> head;
    private Node_<E> tail;

    public Dequeue_2023() {
        head = null;
        tail = null;
    }

    public E pollFirst() {
        if (head == null)
            return null;
        Node_<E> node = head;
        if (head.next ==null) tail = null;
        else head.next.prev = node;
        head = head.next;
        return node.data;
    }

    public E pollLast() {
        if(tail == null)
            return null;
        Node_<E> node = tail;
        if(head.next == null) head = null;
        else tail.prev.next = null;
        tail = tail.prev;
        return node.data;
    }

    public boolean offerFirst(E element) {
        Node_<E> node = new Node_<>();
        node.data = element;
        if (empty()) tail = node;
        else head.prev = node;
        node.next = head;
        head = node;
        return true;
    }

    public boolean offerLast(E element) {
        Node_<E> node = new Node_<>();
        node.data = element;
        if (empty()) head = node;
        else {
            tail.next = node;
            node.prev = tail;
        }
        tail = node;
        return true;
    }

    public boolean empty() {
        return head == null;
    }

    private class Node_<E> {
        private Node_<E> prev;
        private Node_<E> next;
        private E data;
    }
}
