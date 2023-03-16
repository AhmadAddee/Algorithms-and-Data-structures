package com.example.algo_0.f7;

public class NB23_1 {

    public static void main(String[] args) {
        BinarySearchTree<Character> list = new BinarySearchTree<>();
        list.add('J');
        list.add('A');
        list.add('L');
        list.add('K');
        list.add('S');
        list.add('D');
        list.add('C');
        list.add('B');
        System.out.println(list.toString());
        System.out.println(list.find('A'));
        System.out.println(list.findIt('C'));
        System.out.println(list.maxRec());
        System.out.println(list.maxIt());
    }
}

