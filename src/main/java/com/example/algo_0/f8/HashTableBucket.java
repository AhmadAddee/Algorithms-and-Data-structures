package com.example.algo_0.f8;

import java.util.LinkedList;

public class HashTableBucket<K, V> {
    private static class Entry<K, V> {
        public K key;
        public V value;
        public Entry(K k, V v) {
            key = k;
            value = v;
        }
    }

    //private SingleLinkedList<Entry<K, V>>[] table;
    private LinkedList<Entry<K, V>>[] table2;
    private int nrOfEntries;

    @SuppressWarnings("unchecked")
    public HashTableBucket(int initialSize) {
        //table = new SingleLinkedList[initialSize];
        table2 = new LinkedList[initialSize];
    }
    public V get(K key) {
        int index = key.hashCode() % table2.length;
        if (index < 0) {
            index += table2.length;
        }
        if (table2[index] == null) {
            return null;
        }
        for (Entry<K, V> e : table2[index]) {
            if (e.key.equals(key)) {
                return e.value;
            }
        }
        return null;
    }

    public V put(K key, V value) {
        if ((nrOfEntries/table2.length) > 0.75)
            resizeTable();
        int index = key.hashCode() % table2.length;
        if (index < 0) {
            index += table2.length;
        }
        if (table2[index] == null) {
            table2[index] = new LinkedList<>(); // SingleLinkedList<>();
        } else {
            V oldValue;
            for (Entry<K, V> e : table2[index]) {
                if (e.key.equals(key)) {
                    oldValue = e.value;
                    e.value = value;
                    return oldValue;
                }
            }
        }
        table2[index].addFirst(new Entry<>(key, value));
        nrOfEntries++;
        return null;
    }

    // @TODO: NB 24 ToString-Metod
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("HashTableBucket: {");
        for (int i = 0; i < table2.length; i++) {
            sb.append("[" + i + ": {");
            if (table2[i] != null) {
                for (Entry<K, V> e : table2[i]) {
                    sb.append("(" + e.key + ", " + e.value + ") ");
                }
            }
            sb.append("}] ");
        }
        sb.append("}");
        return sb.toString();
    }

    // @TODO: NB 24 Remove-Metod
    public V remove(K key) {
        int index = key.hashCode() % table2.length;
        if (index < 0) {
            index += table2.length;
        }
        if (table2[index] == null) {
            return null;
        }
        V oldValue = null;
        for (Entry<K, V> e : table2[index]) {
            if (e.key.equals(key)) {
                oldValue = e.value;
                table2[index].remove(e);
                break;
            }
        }
        return oldValue;
    }

    // @TODO: NB 25 Resize
    public void resizeTable() {
        int newSize = table2.length * 2;
        @SuppressWarnings("unchecked")
        LinkedList<Entry<K, V>>[] newTable = new LinkedList[newSize];
        for (int i = 0; i < table2.length; i++) {
            if (table2[i] != null) {
                for (Entry<K, V> e : table2[i]) {
                    int index = e.key.hashCode() % newTable.length;
                    if (index < 0) {
                        index += newTable.length;
                    }
                    if (newTable[index] == null) {
                        newTable[index] = new LinkedList<>();
                    }
                    newTable[index].addFirst(e);
                }
            }
        }
        table2 = newTable;
    }// @TODO: NB 25 Resize
    public void doubleSize() {
        LinkedList<Entry<K, V>>[] oldTable = table2;
        @SuppressWarnings("unchecked")
        LinkedList<Entry<K, V>>[] newTable = new LinkedList[table2.length * 2];
        table2 = newTable;
        for (int i = 0; i < oldTable.length; i++) {
            if (oldTable[i] != null) {
                for (Entry<K, V> e : oldTable[i]) {
                    put(e.key, e.value);
                }
            }
        }
    }
}
