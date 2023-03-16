package com.example.algo_0.f7.training;

import java.util.Base64;
import java.util.Set;
import java.util.TreeSet;
import org.json.JSONObject;

public class BST <E extends Comparable<E>>{

    private static class Node_<E> {
        private E data;
        private Node_<E> left, right;

        public Node_(E data) {
            this.data = data;
            this.left = this.right = null;
        }

        @Override
        public String toString() {
            return data.toString();
        }

    }

    private Node_<E> root;
    private E deletedData;

    public BST() {
        this.root = null;
        this.deletedData = null;
    }

    public boolean add(E element) {
        if (root == null) {
            root = new Node_<>(element);
            return true;
        } else
            return add(element, root);
    }

    private boolean add(E element, Node_<E> node) {
        if (node.data.compareTo(element) == 0)
            return false;
        else if (element.compareTo(node.data) < 0) {
            if (node.left == null) {
                node.left = new Node_<>(element);
                return true;
            }else
                return add(element, node.right);
        } else {
            if (node.right == null) {
                node.right = new Node_<>(element);
                return true;
            }else
                return add(element, node.left);
        }
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

    private void inOrder(Node_<E> node, StringBuilder sb) {
        if (node != null) {
            inOrder(node.left, sb);
            sb.append(": " + node.data);
            inOrder(node.right, sb);
        }
    }

    public E delete(E target) {
        root = delete(target, root);
        return deletedData;
    }

    private Node_<E> delete(E target, Node_<E> node) {
        if (node == null) {
            deletedData = null;
            return null;
        } else {
            if (target.compareTo(node.data) < 0) {
                node.left = delete(target, node.left);
                return node;
            } else if (target.compareTo(node.data) > 0) {
                node.right = delete(target, node.right);
                return node;
            } else {
                deletedData = node.data;
                if (node.left == null)
                    return node.right;
                else if (node.right == null)
                    return node.left;
                else {
                    Node_<E> nodeToMove = node.right, parentToMove = node;
                    if (nodeToMove.left == null) {
                        nodeToMove.left = node.left;
                        return nodeToMove;
                    }
                    else {
                        while (nodeToMove.left != null) {
                            parentToMove = nodeToMove;
                            nodeToMove = nodeToMove.left;
                        }
                        parentToMove.left = nodeToMove.right;
                        node.data = nodeToMove.data;
                        return node;
                    }
                }
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        inOrder(root, sb);
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        String string = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJpZCI6NCwic3ViIjoicG9zdG1hbnVzZXJAcG9zdG1hbi5jb20iLCJpYXQiOjE2NzgxNzYwNzh9.x4H-4n64ppcRvd4JaqF6wn65vEFcOhwoHZuhpM1IasU";
        System.out.println(string.split(" ")[1]);
        /*
        String jwtPayload = string.trim().split("\\.")[1];
        Base64.Decoder decoder = Base64.getUrlDecoder();
        String body = new String(decoder.decode(jwtPayload));
        JSONObject jsonObject = new JSONObject(body);
        System.out.println(jsonObject.getLong("id"));

         */
    }
}
