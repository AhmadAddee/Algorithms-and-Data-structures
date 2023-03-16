package com.example.algo_0.f4.training;

public class LinkedQueue_<E> {

    private static class Node_<E> {
        private E data;
        private Node_<E> next;

        public Node_(E data, Node_<E> node) {
            this.data = data;
            this.next = node;
        }
    }

    private Node_<E> head;
    private Node_<E> tail;
    private int size;

    public LinkedQueue_() {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean offer(E element) {
        tail.next = new Node_<>(element, null);
        tail = tail.next;
        size++;
        return true;
    }

    public E poll() {
        if (isEmpty())
            return null;
        E returnValue = head.data;
        head = head.next;
        size--;
        return returnValue;
    }

    public E peek() {
        if (isEmpty())
            return null;
        return head.data;
    }

    private boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        Queue_<String> queue = new Queue_<>();

        for (int i = 0; i < 8; i++) {
            queue.offer("e " + (i + 1));
        }

        queue.poll();
        queue.poll();

        for (int i = 8; i < 14; i++)
            queue.offer("e " + (i + 1));

        while (queue.peek() != null)
            System.out.println(queue.poll());

    }
}
