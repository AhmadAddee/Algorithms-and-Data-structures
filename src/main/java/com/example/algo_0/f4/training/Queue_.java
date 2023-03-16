package com.example.algo_0.f4.training;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.Queue;

public class Queue_<E> extends AbstractQueue<E> implements Queue<E> {

    private E[] data;
    private int maxSize, size, front, rear;

     @SuppressWarnings("unchecked")
    public Queue_(int initialSize) {
        size = 0;
        maxSize = initialSize;
        front = 0;
        rear = maxSize - 1;
        data = (E[]) new Object[maxSize];
    }

    public Queue_() {
        this(10);
    }

    @Override
    public boolean offer(E element) {
         if (size == maxSize)
             reallocate();
         rear = (rear + 1) % maxSize;
         data[rear] = element;
         size++;
         return true;
    }

    @Override
    public E poll() {
         if (isEmpty())
             return null;
         else {
             size--;
             E element = data[front];
             front = (front + 1) % maxSize;
             return element;
         }
    }

    @Override
    public E peek() {
         if (isEmpty())
             return null;
         else return data[front];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @SuppressWarnings("unchecked")
    private void reallocate() {
         int newSize = 2 * maxSize;
         E[] tmp = (E[]) new Object[newSize];
         int count = front;
        for (int i = 0; i < size; i++) {
            tmp[i] = data[count];
            count = (count + 1) % maxSize;
        }
        maxSize = newSize;
        front = 0;
        rear = size - 1;
        data = tmp;
    }

    @Override
    public Iterator<E> iterator() {
        return new Itr();
    }

    @Override
    public int size() {
        return size;
    }

    private class Itr implements Iterator<E> {

         private int index;
         private int count = 0;

         public Itr() {
             index = front;
         }

        @Override
        public boolean hasNext() {
            return count < size;
        }

        @Override
        public E next() {
             if (!hasNext())
                 return null;
             else {
                 E element = data[index];
                 index = (index + 1) % maxSize;
                 count++;
                 return element;
             }
        }
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
