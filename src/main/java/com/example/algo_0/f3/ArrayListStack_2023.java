package com.example.algo_0.f3;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class ArrayListStack_2023<E> implements StackInt_2023<E>{
    private ArrayList<E> data;

    public ArrayListStack_2023() {
        data = new ArrayList<>();
    }
    @Override
    public E push(E element) {
        data.add(element);
        return element;
    }

    @Override
    public E peek() {
        if (empty()) throw new EmptyStackException();
        return data.get(data.size() - 1);
    }

    @Override
    public E pop() {
        if (empty()) throw new EmptyStackException();
        E element = data.get(data.size() - 1);
        data.remove(data.size() - 1);
        return element;
    }

    @Override
    public boolean empty() {
        return data.size() == 0;
    }


    /*****
     *
     * @Test
     */
    public static void main(String[] args) {
        ArrayListStack_2023<Integer> stack = new ArrayListStack_2023<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println("Peek: " + stack.peek());

        while (!stack.empty()){
            System.out.println(stack.pop());
        }

        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(8);
        stack.push(9);

        while (!stack.empty()){
            System.out.println(stack.pop());
        }
    }
}
