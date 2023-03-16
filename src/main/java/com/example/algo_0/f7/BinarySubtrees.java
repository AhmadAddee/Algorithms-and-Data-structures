package com.example.algo_0.f7;

public class BinarySubtrees {

    static class Node{
        int data;
        Node left;
        Node right;
        public Node(int[] array){

            left = right = null;
        }

    }

    public static int binaryTree(int[] a, int t){
        Node node = new Node(a);
        return node.data;
    }

    public static void main(String arg[]) {
        int[] b = {10, 5, 7, 15, 12, 1, 20};
        System.out.println(binaryTree(b, 0));
    }
}
