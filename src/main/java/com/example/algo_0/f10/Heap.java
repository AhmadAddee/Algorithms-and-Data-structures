package com.example.algo_0.f10;

public class Heap <E extends Comparable<E>>{
    private E[] array;
    private int size;
    private final int INITIAL_SIZE = 16;

    public Heap() {
        array = (E[]) new Comparable[INITIAL_SIZE];
        size = 0;
    }

    public Heap(int initialSize) {
        if (initialSize > 0) {
            array = (E[]) new Comparable[initialSize];
            size = 0;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void add(E element) {
        // Expand array if necessary
        if (size == array.length) {
            E[] newArray = (E[]) new Comparable[array.length * 2];
            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }

        // Add element to the end of the array
        array[size++] = element;

        // Bubble up
        int i = size - 1;
        while (i > 0 && array[i].compareTo(array[parent(i)]) < 0) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    public E remove() {
        if (size == 0) {
            throw new IllegalStateException();
        }

        E element = array[0];

        // Move last element to the front
        array[0] = array[--size];
        array[size] = null;

        // Bubble down
        int i = 0;
        while (hasLeftChild(i)) {
            int smallerChildIndex = leftChild(i);
            if (hasRightChild(i) && array[leftChild(i)].compareTo(array[rightChild(i)]) > 0) {
                smallerChildIndex = rightChild(i);
            }

            if (array[i].compareTo(array[smallerChildIndex]) > 0) {
                swap(i, smallerChildIndex);
            } else {
                break;
            }

            i = smallerChildIndex;
        }
        return element;
    }

    public int size() {
        return size;
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int leftChild(int i) {
        return i * 2 + 1;
    }

    private int rightChild(int i) {
        return i * 2 + 2;
    }

    private boolean hasLeftChild(int i) {
        return leftChild(i) < size;
    }

    private boolean hasRightChild(int i) {
        return rightChild(i) < size;
    }

    private void swap(int i, int j) {
        E temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
