package com.example.algo_0.f7;

public class NB23 {

    public static void main(String[] args) {
        BinarySearchTree<Character> list = new BinarySearchTree<>();
        list.add('H');
        list.add('A');
        list.add('K');
        list.add('S');
        list.add('C');
        list.add('D');
        list.add('B');
        System.out.println(list.toString());
        System.out.println(list.numberOfLeaves());
        System.out.println(list.numberOfNodes());
        System.out.println(list.height());
        System.out.println(list.getNextLarger('B'));

    }
}
