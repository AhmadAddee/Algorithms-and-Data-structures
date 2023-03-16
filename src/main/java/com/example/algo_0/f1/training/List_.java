package com.example.algo_0.f1.training;

import java.util.Arrays;

/**
 * Grundprinciper:
 * I en lista har varje element en position eller ett index.
 * Vi kan nå elementen i godtycklig ordning och sätta inn eller ta bort element på godtycklig plats.
 *
 * Precis som för alla ADT varierar det exakt vilka operationer man har med i definitionen. Nedan är ett minimum av operationerna:
 *
 * @create()
 *
 * @add(index)
 * @add(index, element)
 * @get(index)
 * @remove()
 * @size()
 *
 * @indexOf(element)
 * @set(index, element)
 *
 * Använd en array för att lagra elementen i listan:
 * + enkelt och effektivt att nå godtyckligt element via index
 * - tar upp onödigt minne då array:en inte är full
 * - kostsamt när en ny array måste allokeras och alla element flyttas över då den gamla array:en blivit full
 * - kostsamt då många element måste flyttas när man sätter in eller tar bort ett element mitt i listan
 *
 *
 */
public class List_<T> {

        private T[] data;
        private int maxSize;
        private int nrOfElement;

        public List_(int maxSize) {
            this.maxSize = maxSize;
            this.data = (T[]) new Object[maxSize];
            nrOfElement = 0;
        }

        public List_() {
            this(10);
        }

        public boolean add(T element) {
            if (nrOfElement == maxSize)
                reallocate();
            this.data[nrOfElement++] = element;
            return true;
        }

        public void add(int index, T element) {
            if (nrOfElement == maxSize)
                reallocate();
            validIndexCheck(index);
            for (int i = nrOfElement; i > index; i--)
                this.data[i] = this.data[i-1];
            this.data[index] = element;
            nrOfElement++;
        }

        public T get(int index) {
            validIndexCheck(index);
            return data[index];
        }

        public T remove(int index) {
            validIndexCheck(index);
            T deleted = data[index];
            for (int i = index; i < nrOfElement-1; i++) {
                data[index] = data[index+1];
            }
            nrOfElement--;
            return deleted;
        }

        public int size() {
            return nrOfElement;
        }

        public int indexOf(T element) {
            for (int i = 0; i < nrOfElement; i++) {
                if (this.data[i].equals(element))
                    return i;
            }
            return -1;
        }

        public T set(int index, T element) {
            validIndexCheck(index);
            T temp = this.data[index];
            this.data[index] = element;
            return temp;
        }


        //Att vi just dubblar storleken på array:en gör att add() blir i genomsnitt O(1)
        private void reallocate() {
            maxSize *= 2;
            data = Arrays.copyOf(data, maxSize);
        }

        private void validIndexCheck(int index) {
            if (index < 0 || index >= nrOfElement)
                throw new ArrayIndexOutOfBoundsException(index);
        }

        @Override
        public String toString() {
            return  Arrays.toString(data);
        }


    public static void main(String[] args) {

    }
}
