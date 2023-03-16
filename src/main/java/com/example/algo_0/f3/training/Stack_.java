package com.example.algo_0.f3.training;

import java.util.*;

public class Stack_<E> {

    private static class Node_<E> {
        private E data;
        private Node_<E> next;

        public Node_(E data, Node_<E> next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node_<E> head;

    public Stack_() {
        head = null;
    }

    public E push(E element) {
        head = new Node_<>(element, head);
        return element;
    }

    public E pop() {
        if (isEmpty())
            throw new EmptyStackException();
        E returnValue = head.data;
        head = head.next;
        return returnValue;
    }

    public E peek() {
        if (isEmpty())
            throw new EmptyStackException();
        return head.data;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public static class PostFixEvaluator_ {

        public static int evaluate(String input) {
            Stack_<Integer> stack = new Stack_<>();
            String[] array = input.trim().split(" +");

            for (int i = 0; i < array.length; i++) {
                if (Character.isDigit(array[i].charAt(0))) {
                    System.out.println(array[i] + " is digit");
                    stack.push(Integer.parseInt(array[i]));
                }
                else {
                    System.out.println(array[i] + " is operator " + isOperator(array[i].charAt(0)));
                    char operator = array[i].charAt(0);
                    int right, left = 0;
                    switch (operator) {
                        case '+' -> {
                            right = stack.pop();
                            left = stack.pop();
                            stack.push(left + right);
                        }
                        case '-' -> {
                            right = stack.pop();
                            left = stack.pop();
                            stack.push(left - right);
                        }
                        case '*' -> {
                            right = stack.pop();
                            left = stack.pop();
                            stack.push(left * right);
                        }
                        case '/' -> {
                            right = stack.pop();
                            left = stack.pop();
                            stack.push(left / right);
                        }
                    }
                }
            }
            return stack.pop();
        }

        public static boolean isOperator(char ch) {
            return "+-'/".indexOf(ch) != -1;
        }
    }

    public static void main(String[] args) {
        PostFixEvaluator_ postFixEvaluator = new PostFixEvaluator_();
        Scanner line = new Scanner(System.in);
        String input = line.nextLine();

        System.out.println(postFixEvaluator.evaluate(input));
    }
}
