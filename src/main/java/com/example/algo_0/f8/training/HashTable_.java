package com.example.algo_0.f8.training;

import com.example.algo_0.f2.SingleLinkedList;

public class HashTable_<K, V>{

    private static class Entry<K, V> {
        public K key;
        public V value;

        public Entry(K k, V v) {
            this.key = k;
            this.value = v;
        }
    }

    private SingleLinkedList<Entry<K, V>>[] table;

    //TODO: CONSTRUCTOR
    @SuppressWarnings("unchecked")
    public HashTable_(int size) {
        this.table = new SingleLinkedList[size];
    }

    //TODO: put(key, value)
    /**
    sätter in key, value på rätt index enligt key's hashcode
     och returnerar det gamla value som key hittas och null om det inte hittas
     */
    public V put(K key, V value){
        int index = key.hashCode() % table.length;
        if (index < 0)
            index += table.length;
        if (table[index] == null) {
            table[index] = new SingleLinkedList<>();
            table[index].add(new Entry<>(key, value));
            return null;
        } else {
            V oldValue;
            for (Entry<K, V> e : table[index]) {
                if (e.key.equals(key)) {
                    oldValue = e.value;
                    e.value = value;
                    return oldValue;
                }
            }
            table[index].add(0, new Entry<K, V>(key, value));
            return null;
        }
    }

    //TODO: get(key)
    public V get(K key) {
        int index = key.hashCode() % table.length;
        if (index < 0) index += table.length;
        if (table[index] == null) return null;
        for (Entry<K, V> e : table[index]) {
            if (e.key.equals(key)) return e.value;
        }
        return null;
    }

    //TODO: remove(key)
    /**
     Tar bort key, value elementet om det finns och returnerar value
     annars returneras null
     */
}
