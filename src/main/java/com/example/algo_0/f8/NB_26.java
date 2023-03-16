package com.example.algo_0.f8;

import org.junit.Test;

import static org.testng.Assert.*;

public class NB_26 {
    public static void main(String[] args) {
        HashTableBucket<String, Integer> table = new HashTableBucket<>(5);
        table.put("A", 1);
        table.put("B", 2);
        table.put("C", 3);
        table.put("D", 4);
        table.put("E", 5);
        table.put("F", 6);
        table.put("G", 7);
        table.put("H", 8);
        table.put("I", 9);
        System.out.println(table.get("A") == 1);
        System.out.println(table.get("B") == 2);
        System.out.println(table.get("C") == 3);
        System.out.println(table.get("D") == 4);
        System.out.println(table.get("E") == 5);
        System.out.println(table.get("F") == 6);
        System.out.println(table.get("G") == 7);
        System.out.println(table.get("H") == 8);
        System.out.println(table.get("I") == 9);
        table.put("A", 10);
        System.out.println(table.get("A") == 10);
        table.put("J", 10);
        System.out.println(table.get("J") == 10);
    }

}
