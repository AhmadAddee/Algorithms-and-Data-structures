package com.example.algo_0.f6;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList_Rec<E> implements Iterable<E> {

    private Node_<E> head;

    public LinkedList_Rec() {
        head = null;
    }

    public boolean add(E element) {
        add(size(), element);
        return true;
    }

    public void add(int index, E item) {
        if (index < 0 || index > size()) throw new IndexOutOfBoundsException(Integer.toString(index));

        if (index == 0) addFirst(item);
        else {
            Node_<E> node = getNodeRec(index - 1);
            addAfter(node, item);
        }
    }

    public E get(int index) {
        if (index < 0 || index > size()) throw new IndexOutOfBoundsException(Integer.toString(index));

        Node_<E> node = getNodeRec(index);
        return node.data;
    }

    public Iterator<E> iterator() {
        return new Itr(head);
    }

    private void addFirst(E item) {
        head = new Node_<E>(item, head);
    }

    private void addAfter(Node_<E> node, E item) {
        node.next = new Node_<>(item, node.next);
    }

    private Node_<E> getNode(int index) {
        Node_<E> node = head;
        for (int i = 0; i < index && node != null; i++) {
            node = node.next;
        }
        return node;
    }

    // @TODO: NB 17
    private Node_<E> getNodeRec(int index) {
        return getNodeRec(index, head, 0);
    }

    private Node_<E> getNodeRec(int index, Node_<E> node, int position) {
        if (node == null) return null;
        if (index == position) return node;
        return getNodeRec(index, node.next, position+1);
    }

    public int size(){
        return getSize(head, 0);
    }

    private int getSize(Node_<E> node, int size) {
        if (node == null)
            return size;
        return getSize(node.next, size+1);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node_<E> node = head;
        if (node != null) {
            while (node.next != null) {
                sb.append(node.data.toString())
                        .append("==>");
                node = node.next;
            }
            sb.append(node.data.toString());
        }
        sb.append("]");
        return sb.toString();
    }


    private static class Node_<E> {
        private E data;
        private Node_<E> next;

        public Node_(E data, Node_<E> next) {
            this.data = data;
            this.next = next;
        }
    }

    private class Itr implements Iterator<E> {
        Node_<E> current;
        Node_<E> previous;

        public Itr(Node_<E> start) {
            current = start;
            previous = current;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            if (current == null) throw new NoSuchElementException();
            E element = current.data;
            System.out.println("From next, current: " + current.data);
            System.out.println("From next, previous: " + previous.data);
            previous = current;
            current = current.next;
            return element;
        }

        @Override
        public void remove() {
            if (current == previous) throw new IllegalStateException();
            previous = current;
        }
    }
}
