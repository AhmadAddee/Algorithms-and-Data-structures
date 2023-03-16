package com.example.algo_0.f4;

public class TestQueue<E> {

    private int size;
    private int maxSize;
    private int front;
    private int rear;
    private E[] data;

    public TestQueue(int initialMaxSize) {
        maxSize = initialMaxSize;
        size = 0;
        front = 0;
        rear = maxSize-1;
        data = (E[]) new Object[maxSize];
    }

    public boolean offer(E element){
        if (size == maxSize)
            reallocate();
        rear = (rear + 1) % maxSize; //in order to come back to 0 when the array is full
        //could be else in this way:
//        if (rear == maxSize)
//            rear = 0;
        data[rear] = element;
        size++;
        return true;
    }

    public E poll(){
        if (isEmpty())
            return null;
//        if (front == maxSize)
//            front = 0;
        else {
            size--;
            E element = data[front];
            front = (front + 1) % maxSize;//instead of if-sats upov
            return element;
        }
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public E peek(){
        if (isEmpty())
            return null;
        return data[front];
    }

    private void reallocate(){
        int newMaxSize = maxSize * 2;
        E[] newData = (E[]) new Object[newMaxSize];
        int j = front;
        for (int i = 0; i <= size; i++){
            newData[i] = data[j];
            j = (j + 1) % maxSize;
        }
        front = 0;
        rear = size - 1;
        maxSize = newMaxSize;
        data = newData;
    }

    public static void main(String[] args) {
        TestQueue<String> queue = new TestQueue<>(10);
        for (int i = 0; i < 8; i++)
            queue.offer("e " + (i+1));
        queue.poll();
        queue.poll();
        for (int i = 8; i < 14; i++)
            queue.offer("e " + (i+1));

        while (!queue.isEmpty())
            System.out.println(queue.poll());
    }
}
