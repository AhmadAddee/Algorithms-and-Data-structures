package com.example.algo_0.f2;

import java.util.Iterator;
import java.util.NoSuchElementException;

/*********
 Fördelarna:
    * den kan växa dynamiskt
    * det är effedktivt att stoppa in eller ta ut element mitt i.
      Har vi referensen till noden innan ör att ta bort eller sätta in element O(1).
 Nackdelarna:
    * varje element kräver plats för en referens till nästa nod => dubbelt så många referenser jmf med en arraylist.
    * att hitta ett element är O(n)
 */
public class LinkedList_2023<E> implements Iterable<E>{

    private Node_<E> head;
    private int size;

    public LinkedList_2023() {
        head = null;
        size = 0;
    }

    public boolean add(E element) {
        add(size, element);
        return true;
    }

    public void add(int index, E item) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException(Integer.toString(index));

        if (index == 0) addFirst(item);
        else {
            Node_<E> node = getNode(index - 1);
            addAfter(node, item);
        }
    }

    public E get(int index) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException(Integer.toString(index));

        Node_<E> node = getNode(index);
        return node.data;
    }

    public Iterator<E> iterator() {
        return new Itr(head);
    }

    private void addFirst(E item) {
        head = new Node_<E>(item, head);
        size++;
    }

    private void addAfter(Node_<E> node, E item) {
        node.next = new Node_<>(item, node.next);
        size++;
    }

    // Return null om noden saknas.
    private Node_<E> getNode(int index) {
        Node_<E> node = head;
        for (int i = 0; i < index && node != null; i++) {
            node = node.next;
        }
        return node;
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
