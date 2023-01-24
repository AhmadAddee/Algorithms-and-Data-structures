package com.example.algo_0.f3;

import java.util.Arrays;
import java.util.EmptyStackException;

public class ArrayStack_2023<E> implements StackInt_2023<E>{
    private E[] data;
    private int top;
    private int maxSize;

    public ArrayStack_2023() {
        top = -1;
        maxSize = 10;
        data = (E[]) new Object[maxSize];
    }

    @Override
    public E push(E element) {
        //if (element == null) throw new NullPointerException();
        if (top == maxSize - 1) reallocate();

        data[++top] = element;
        return element;
    }

    @Override
    public E peek() {
        if (empty()) throw new EmptyStackException();

        return data[top];
    }

    @Override
    public E pop() {
        if (empty()) throw new EmptyStackException();

        return data[top--];
    }

    @Override
    public boolean empty() {
        return top == -1;
    }

    private void reallocate() {
        maxSize *= 2;
        data = Arrays.copyOf(data, maxSize);
    }
}
