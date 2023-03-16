package com.example.algo_0.f2.training;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * Länkad lista är en datastruktur där varje element ligger i en nod som håller reda på nästa nod.
 *
 * Fördelarna:
 * + den kan växa dynamiskt
 * + det är effektivt att stoppa in eller ta ut element mitt i.
 *   Har vi referensen till noden innan är att ta bort eller sätta in element O(1)
 * Nackdelarna:
 * - Varje element kräver plats för en referens till nästa nod
 * - Att hitta ett element är O(n)
 */

public class LinkedList_<E> implements Iterable<E>{

    private static class Node_<E> {
        private E data;
        private Node_<E> next;

        public Node_(E data, Node_<E> next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node_<E> head;
    private int size;

    public LinkedList_() {
        this.head = null;
        size = 0;
    }

    public boolean add(int index, E element) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException(index);
        if (index == 0) {
            addFirst(element);
        } else {
            Node_<E> node = getNode(index - 1);
            addAfter(node, element);
        }
        size++;
        return true;
    }

    public boolean add(E element) {
        return add(size, element);
    }

    private void addFirst(E element) {
        head = new Node_<>(element, head);
    }

    private void addAfter(Node_<E> node, E element) {
        node.next = new Node_<>(element, node.next);
    }

    private Node_<E> getNode(int index) {
        Node_<E> node = head;
        for (int i = 0; i < index && node != null; i++) {
            node = node.next;
        }
        return node;
    }

    public E get(int index) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException(index);
        return getNode(index).data;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node_<E> node = head;
        if (node != null) {
            while (node.next != null) {
                sb.append(node.data)
                        .append(" ==> ");
                node = node.next;
            }
            sb.append(node.data)
                    .append("]");;
        }
        return sb.toString();
    }

    public Iterator<E> iterator() {
        return new Itr(head);
    }


    private class Itr implements Iterator<E> {

        private Node_<E> current;
        private Node_<E> previous;
        private Node_<E> prePrevious;

        public Itr(Node_<E> start) {
            this.current = start;
            previous = null;
            prePrevious = null;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            if (!hasNext())
                throw new NoSuchElementException();
            E returnValue = current.data;
            prePrevious = previous;
            previous = current;
            current = current.next;
            return returnValue;
        }

        @Override
        public void remove() {
            if (previous == null)
                throw new IllegalStateException();
            if (prePrevious == null) {
                head = current;
            } else {
                prePrevious.next = current;
            }
            previous = null;
            size--;
        }
    }

    public static void main(String[] args) {
        LinkedList_<String> list = new LinkedList_<>();

        list.add(0, "1");
        list.add(1, "2");
        list.add(2, "3");
        list.add(3, "4");
        list.add("5");

        Iterator<String> iterator = list.iterator();

        System.out.println(list.get(3));
        System.out.println(list);
        System.out.println("Will removed " + iterator.next());
        iterator.remove();
        System.out.println(list);
        System.out.println("Will removed " + iterator.next());
        iterator.remove();
        System.out.println(list);
        System.out.println("Will removed " + iterator.next());
        iterator.remove();
        System.out.println(list);

        while (iterator.hasNext())
            System.out.println(iterator.next());
    }
}
