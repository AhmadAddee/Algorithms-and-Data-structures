package com.example.algo_0.f1;

import java.util.Arrays;

/****
 ***** ArrayList *****

 + enkelt och effektivt att nå godtyckligt element via index.
 - tar upp onödigt minne då arrayen inte är full
 - kostsamt när en ny array måste allokeras och alla element flyttas över då den gamla arrayen blivit full.
 - kostsamt då många element måste flyttas när man sätter in eller tar bort ett element mitt i listan

 Implementerar e.g. Iterable<E> och List<E>
 Some methods_-_-_-_-_-
 boolean add(E e)
 void add(int index, E e)
 E get(int index)
 int indexOf(Object o) // returns -1 otherwise
 E remove(int index)
 E set(int index, E e) // replace
 int size()
 */
public class ArrayList_2023<E>{
    private E[] data;
    private int nrElement, maxSize;

    public ArrayList_2023() {
        nrElement = 0;
        maxSize = 10;
        data = (E[]) new Object[maxSize];
    }

    // O(1) without reallocate().call, O(n) with it.
    // Men i genomsnitt får vi O(1) eftersom vi dubblar storleken.
    public boolean add(E element) {
        if (nrElement == maxSize)
            reallocate();
        data[nrElement++] = element;
        return true;
    }

    // O(n)
    public void add(int index, E e) {
        if (index > nrElement || index < 0)
            throw new ArrayIndexOutOfBoundsException(index);
        if (nrElement == maxSize)
            reallocate();
        for (int i = nrElement; i > index; i--)
            data[i] = data[i-1];
        data[index] = e;
        nrElement++;
    }

    // O(1)
    public E get(int index) {
        if (index >= nrElement || index < 0)
            throw new ArrayIndexOutOfBoundsException(index);
        return data[index];
    }

    public int indexOf(E e) {  // returns -1 otherwise
        int index = -1;
        for (int i = 0; i < nrElement; i++){
            if (data[i].equals(e))
                return i;
        }
        return index;
    }

    // O(n)
    public void remove(int index){
        if (index >= nrElement || index < 0)
            throw new ArrayIndexOutOfBoundsException();
        for (int i = index; i < nrElement - 1; i++)
            data[i] = data[i + 1];
        nrElement--;
    }

    // O(1)
    public E set(int index, E e) { // replace
        if (index >= nrElement || index < 0)
            throw new ArrayIndexOutOfBoundsException();
        E object = data[index];
        data[index] = e;
        return object;
    }

    public int size() {
        return nrElement;
    }

    // O(n)
    private void reallocate(){
        maxSize *= 2;
        data = Arrays.copyOf(data, maxSize);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < nrElement - 1; i++)
            stringBuilder.append(data[i]).append(", ");
        stringBuilder.append(data[nrElement - 1]).append("]");
        return stringBuilder.toString();
    }
}
