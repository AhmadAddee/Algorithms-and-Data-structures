package com.example.algo_0.f8;

public class Main {

    public static void main(String[] args) {
        HashTableBucket bucket = new HashTableBucket(10);
        bucket.put("key1", "value1");
        bucket.put("key2", "value2");
        bucket.put("key3", "value3");

        /****
         * @TEST: NB 24
         * **/
        System.out.println("Removing key2, " + bucket.remove("key2"));
        System.out.println(bucket);
        bucket.put("A", 1);
        bucket.put("B", 2);
        bucket.put("C", 3);
        bucket.put("D", 4);
        bucket.put("E", 5);
        System.out.println(bucket);

        /****
         * @TEST: NB 25
         * **/
        bucket.put("F", 6);
        bucket.put("G", 7);
        bucket.put("H", 8);
        bucket.put("I", 9);
        System.out.println(bucket);
    }
}
