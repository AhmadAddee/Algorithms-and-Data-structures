package com.example.algo_0.f2;

public class IntList_2023 {

    private int[] data;
    private int nrElement;
    private int maxSize;

    public IntList_2023(int initialCapacity) {
        maxSize = initialCapacity;
        nrElement = 0;
        data = new int[maxSize];
    }

    public IntList_2023() {
        this(10);
    }

    public boolean add(int element) {
        if (nrElement == maxSize)
            reallocate();
        data[nrElement++] = element;
        return true;
    }

    public boolean add(int index, int element) {
        if (index < 0 || index > nrElement) throw new ArrayIndexOutOfBoundsException(index);
        if (nrElement == maxSize) reallocate();
        for (int i = nrElement; i > index; i--)
            data[i] = data[i - 1];
        data[index] = element;
        nrElement++;
        return true;
    }

    public int get(int index) {
        if (index < 0 || index >= nrElement) throw new ArrayIndexOutOfBoundsException(index);
        return data[index];
    }

    public int indexOf(int element) {
        for (int i = 0; i < nrElement; i++)
            if (data[i] == element)
                return i;
        return -1;
    }

    public int remove(int index) {
        if (index < 0 || index >= nrElement) throw new ArrayIndexOutOfBoundsException(index);
        int element = data[index];
        for (int i = index; i < nrElement-1; i++)
            data[i] = data[i+1];
        nrElement--;
        return element;
    }

    public void set(int index, int element) {
        if (index < 0 || index >= nrElement) throw new ArrayIndexOutOfBoundsException(index);
        data[index] = element;
    }

    public int size() {
        return nrElement;
    }

    private void reallocate(){
        maxSize *= 2;
        int[] newData = new int[maxSize];
        //if (nrElement >= 0) System.arraycopy(data, 0, newData, 0, nrElement);
        for (int i = 0; i < nrElement; i++)
            newData[i] = data[i];
        data = newData;
    }

    @Override
    public String toString(){
        StringBuilder aList = new StringBuilder("[");
        for (int i = 0; i < nrElement - 1; i++){
            aList.append(data[i] + ", ");
        }
        aList.append(data[nrElement - 1]).append("]");
        return aList.toString();
    }
}
