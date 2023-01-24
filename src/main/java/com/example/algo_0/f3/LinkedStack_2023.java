package com.example.algo_0.f3;

import java.util.EmptyStackException;

public class LinkedStack_2023<E> implements StackInt_2023<E>{
    private Node_<E> top;

    public LinkedStack_2023() {
        top = null;
    }

    @Override
    public E push(E element) {
        top = new Node_<>(element, top);
        return element;
    }

    @Override
    public E pop() {
        if (empty()) throw new EmptyStackException();

        E element = top.data;
        top = top.next;
        return element;
    }

    @Override
    public E peek() {
        if (empty()) throw new EmptyStackException();

        return top.data;
    }

    @Override
    public boolean empty() {
        return top == null;
    }

    // @TODO:
    public int size() {
        Node_<E> node = top;
        int count = 0;
        while (node != null) {
            node = node.next;
            count++;
        }
        return count;
    }

    // @TODO:
    public E peek(int index) {
        if (index < 0) throw new IndexOutOfBoundsException();
        Node_<E> node = top;
        for (int i = 0; i < index && node != null; i++) {
            node = node.next;
        }
        return node != null? node.data : null;
    }

    // @TODO:
    public E flush() {
        Node_<E> node = top;
        while (top != null) {
            node = top;
            top = top.next;
        }
        return node.data;
    }

    private static class Node_ <E>{
        private E data;
        private Node_<E> next;

        private Node_(E dataItem, Node_<E> nodeRef) {
            data = dataItem;
            next = nodeRef;
        }
    }


    /******
     *
     * @Test
     */
    public static void main(String[] args) {
        LinkedStack_2023<Integer> stack = new LinkedStack_2023<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println("Stack size: " + stack.size());
        System.out.println("Peek: " + stack.peek());
        System.out.println("Peek the first: " + stack.peek(0));

        while (!stack.empty()){
            System.out.println(stack.pop());
            System.out.println("Stack size: " + stack.size());
        }

        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(8);
        stack.push(9);

        System.out.println("Stack size: " + stack.size());
        System.out.println("The last element in tht stack: " + stack.flush());;
        System.out.println("Stack size: " + stack.size());

        System.out.println(stack.peek(22));

    }
}
