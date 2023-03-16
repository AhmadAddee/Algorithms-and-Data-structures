package com.example.algo_0.f2.training;

import org.w3c.dom.Node;

import java.util.Iterator;

public class DubbleLinkedList_<E> implements Iterable<E>{

    private static class Node_<E> {
        private E data;
        private Node_<E> next;
        private Node_<E> prev;

        public Node_(E data, Node_<E> next, Node_<E> prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

    private Node_<E> head;
    private Node_<E> tail;
    private int size;

    public DubbleLinkedList_() {
        this.head = null;
        this.tail = null;
        size = 0;
    }

    public boolean add(int index, E element) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException(index);

        if (head == null)
            head = tail = new Node_<>(element, null, null);
        else {
            if (index == 0)
                addFirst(element);
            else if (index == size)
                addLast(element);
            else {
                Node_<E> node = getNode(index - 1);
                addAfter(node, element);
            }
        }
        size++;
        return true;
    }

    public boolean add(E element) {
        add(size, element);
        return true;
    }
    private void addFirst(E element) {
        /*
        Node_<E> node = head;
        if (node == tail) {
            tail.next = new Node_<>(tail.data, null, tail);
            tail = tail.next;
            head.data = element;
        }
        else {*/
            head.prev = new Node_<>(element, head, null);
            head = head.prev;
       // }
    }

    private void addAfter(Node_<E> node, E element) {
        Node_<E> tmp = node;
        node.next = new Node_<>(element, node.next, node);
        tmp.next.prev = node.next;
    }

    private void addLast(E element) {
        tail.next = new Node_<>(element, null, tail);
        tail = tail.next;
    }

    private Node_<E> getNode(int index) {
        Node_<E> node = head;
        for (int i = 0; i < index && node != null; i++) {
            node = node.next;
        }
        return node;
    }

    public E getFirst() {
        return head.data;
    }

    public E getLast() {
        return tail.data;
    }

    public E get(int index) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException(index);
        return getNode(index).data;
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

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    public static void main(String[] args) {
        DubbleLinkedList_<String> list = new DubbleLinkedList_<>();

        list.add(0, "1");
        System.out.println(list);
        list.add(1, "2");
        System.out.println(list);
        list.add(0, "5");
        System.out.println(list);
        list.add(0, "3");
        System.out.println(list);
        list.add(0, "4");
        System.out.println(list);

        System.out.println("size: " + list.size);

        System.out.println("first: " + list.getFirst());
        System.out.println("last: " + list.getLast());
    }
}
