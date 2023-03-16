package com.example.algo_0.f4;

import java.util.*;

/***
 * Implements the AbstractQueue in order to avoid implement the hundred-thousand methods from Queue.
 * @param <E>
 */
public class CircleArrayQueue_2023<E> extends AbstractQueue<E> implements Queue<E> {

    private int front, rear, maxSize, size;
    private E[] data;

    @SuppressWarnings("unchecked")
    public CircleArrayQueue_2023(int initialMaxSize) {
        if (initialMaxSize == 0)
            maxSize = 10;
        else
            maxSize = initialMaxSize;
        size = 0;
        front = 0;
        rear = maxSize - 1;
        data = (E[]) new Object[maxSize];
    }

    @Override
    public boolean offer(E element) {
        if (size == maxSize) reallocate();
        rear = (rear + 1) % maxSize;
        data[rear] = element;
        size++;
        return true;
    }

    public E peek() {
        if (size == 0) return null;
        return data[front];
    }

    public E poll() {
        if (size == 0) return null;
        size--;
        E element = data[front];
        front = (front + 1) % maxSize;
        minimise();
        return element;
    }

    @SuppressWarnings("unchecked")
    private void reallocate() {
        int newMaxSize = maxSize * 2;
        E[] newData = (E[]) new Object[newMaxSize];
        int j = front;
        for (int i = 0; i < size; i++) {
            newData[i] = data[j];
            j = (j + 1) % maxSize;
        }
        front = 0;
        rear = size - 1;
        maxSize = newMaxSize;
        data = newData;
        System.out.println("The new size after reallocating: " + maxSize);
    }

    // @TODO: NB 8
    private void minimise(){
        if (size == maxSize/4){
            int newMaxSize = maxSize / 2;
            E[] newData = (E[]) new Object[newMaxSize];
            int j = front;
            for (int i =0; i < size; i++){
                newData[i] = data[j];
                j = (j+1) % maxSize;
            }
            front = 0;
            rear = size -1;
            maxSize = newMaxSize;
            data = newData;
            System.out.println("The new max size after minimizing it: " + maxSize + ", size now:" + size);
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new Iter();
    }

    public int size() {
        return size;
    }

    private class Iter implements Iterator<E> {
        private int index;
        private int count = 0;

        public Iter() {
            index = front;
        }

        @Override
        public boolean hasNext() {
            return count < size;
        }

        @Override
        public E next() {
            if (!hasNext()) throw new NoSuchElementException();
            E returnValue = data[index];
            index = (index + 1) % maxSize;
            count++;
            return returnValue;
        }
    }

}
