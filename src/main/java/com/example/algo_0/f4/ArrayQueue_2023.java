package com.example.algo_0.f4;

import java.util.Arrays;

public class ArrayQueue_2023<E> {
    private int front, rear, size, maxSize;
    private E[] data;

    @SuppressWarnings("unchecked")
    public ArrayQueue_2023(int initialSize) {
        size = 0;
        front = 0;
        maxSize = initialSize;
        rear = 0;
        data = (E[]) new Object[maxSize];
    }

    public boolean offer(E element) {
        if (size == maxSize)
            reallocate();
        data[rear] = element;
        rear = rear + 1 % maxSize;
        size++;
        return true;
    }

    public E peek() {
        if (size == 0) return null;
        return data[front];
    }

    public E poll() {
        if (size == 0) {
            return null;
        } else {
            size--;
            E element = data[front];
            // TODO: Wrong precedence statement
            // front = front + 1 % maxSize;
            front = (front + 1) % maxSize;
            return element;
        }
    }

    private void reallocate() {
        // TODO: Wrong attempt to reallocate
        /*
        maxSize *= 2;
        data = Arrays.copyOf(data, maxSize);
         */

        int newMaxSize = maxSize * 2;
        E[] newData = (E[]) new Object[newMaxSize];
        int j = front;
        for (int i = 0; i < size; i++) {
            newData[i] = data[j];
            j = (j + 1) % maxSize;
        }
        front = 0;
        rear = 0;
        maxSize = newMaxSize;
        data = newData;
    }

    @Override
    public String toString() {
        return "ArrayQueue_2023{" +
               "front=" + front +
               ", rear=" + rear +
               ", size=" + size +
               ", maxSize=" + maxSize +
               ", data=" + Arrays.toString(data) +
               '}';
    }
}
