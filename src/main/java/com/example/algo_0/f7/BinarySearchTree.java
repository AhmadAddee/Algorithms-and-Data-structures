package com.example.algo_0.f7;

public class BinarySearchTree <E extends Comparable<E>>{

    private static class Node_<E> {
        private E data;
        private Node_<E> left, right;

        private Node_(E d) {
            data = d;
            left = right = null;
        }

        /*
        @Override
        public String toString() {
            return data.toString();
        }
         */
    }

    private Node_<E> root;
    private E deletedData;

    public BinarySearchTree() {
        root = null;
    }

    private void inOrder(Node_<E> node, StringBuilder sb) {
        if (node != null){
            inOrder(node.left, sb);
            sb.append(node.data + " ");
            inOrder(node.right, sb);
        }
    }

    public boolean add(E data) {
        if (root == null) {
            root = new Node_<>(data);
            return true;
        }
        else return add(data, root);
    }

    private boolean add(E data, Node_<E> node) {
        if (data.compareTo(node.data) == 0) {
            return false;
        }
        else if (data.compareTo(node.data) < 0)
            if (node.left == null) {
                node.left = new Node_<>(data);
                return true;
            }else
                return add(data, node.left);
        else if (node.right == null) {
                node.right = new Node_<E>(data);
                return true;
            } else
                return add(data, node.right);
    }

    public E find(E target) {
        return find(target, root);
    }

    private E find(E target, Node_<E> node) {
        if (node == null)
            return null;
        if (target.compareTo(node.data) == 0)
            return node.data;
        if (target.compareTo(node.data) < 0)
            return find(target, node.left);
        return find(target, node.right);
    }

    public E delete(E target) {
        root = delete(target, root);
        return deletedData;
    }

    private Node_<E> delete(E target, Node_<E> node) {
        if (node == null) {
            deletedData = null;
            return null;
        }
        if (target.compareTo(node.data) < 0) { // target exists in the left tree
            node.left = delete(target, node.left); // if it exists.
            return node;
        } else if (target.compareTo(node.data) > 0) { // target exists in the right tree
            node.right = delete(target, node.right);
            return node;
        } else { // target exists in the node.
            deletedData = node.data;
            if (node.left == null)
                return node.right;
            else if (node.right == null)
                return node.left;
            else {
                Node_<E> nodeToMove = node.right, parentNodeToMove = node;
                if (nodeToMove.left == null) {
                    nodeToMove.left = node.left;
                    return nodeToMove;
                }
                while (nodeToMove.left != null) {
                    parentNodeToMove = nodeToMove;
                    nodeToMove = nodeToMove.left;
                }
                parentNodeToMove.left = nodeToMove.right;
                node.data = nodeToMove.data;
                return node;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        inOrder(root, sb);
        return sb.toString();
    }

    // @TODO: NB 23
    public int numberOfLeaves(){
        return numberOfLeaves(root);
    }

    private int numberOfLeaves(Node_<E> node){
        if (node==null){
            return 0;
        }
        if (node.left == null && node.right == null) {
            return 1;
        }
        return numberOfLeaves(node.left)+numberOfLeaves(node.right);
    }

    public int numberOfNodes(){
        return numberOfNodes(root);
    }

    private int numberOfNodes(Node_<E> node){
        if (node==null){
            return 0;
        }
        return 1 + numberOfNodes(node.left) + numberOfNodes(node.right);
    }

    public int height(){
        return height(root);
    }

    private int height(Node_<E> node){
        if (node==null){
            return 0;
        }
        return 1 + Math.max(height(node.left),height(node.right));
    }

    public E getNextLarger(E element){
        E elementToCompare = root.data;
        return getNextLargerRec(element, root, elementToCompare);
    }

    public E getNextLargerRec(E target, Node_<E> node, E elementTC) {
        if (node == null)
            return null;
        if (node.right != null) {
            node = node.right;
            while (node.left != null){
                node = node.left;
            }
            return node.data;
        }
        return null;
    }

    // @TODO: NB 23.1
    public E findIt(E target){
        return findIt(target,root);
    }

    private E findIt(E target, Node_<E> node){
        if (node == null) return null;
        for (int diff= target.compareTo(node.data); diff != 0; diff= target.compareTo(node.data)){
            if (diff<0) node = node.left;
            if (diff>0) node = node.right;
            if (node == null) break;
        }
        return node.data;
    }

    public E maxRec(){
        return maxRec(root);
    }

    private E maxRec(Node_<E> node){
        if (node.right == null){
            return node.data;
        }
        return maxRec(node.right);
    }

    public E maxIt(){
        return maxIt(root);
    }

    private E maxIt(Node_<E> node){
        while(node.right != null){
            node = node.right;
        }
        return node.data;
    }
}
