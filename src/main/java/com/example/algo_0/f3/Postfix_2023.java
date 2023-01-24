package com.example.algo_0.f3;

import java.util.Stack;

public class Postfix_2023{
    private static class Node_<E> {
        E data;
        Node_ next;
    }
    public static void main(String[] args) {
        Node_<Integer> head = new Node_();
        Node_<Integer> first = new Node_();
        Node_<Integer> second = new Node_();
        Node_<Character> third = new Node_();
        Node_<Integer> fourth = new Node_();
        Node_<Character> fifth = new Node_();
        head.next = first;
        first.data = 12;
        first.next = second;
        second.data = 6;
        second.next = third;
        third.data = '+';
        third.next = fourth;
        fourth.data = 3;
        fourth.next = fifth;
        fifth.data = '/';
        fifth.next = null;


        // Create an empty Stack of integers
        Stack<Integer> stack = new Stack<>();
        // While there are more tokens, get the next token.
        Node_ node = head;
        while (true) {
            node = node.next;
            if (node == null) break;
            Object object = node.data;
            System.out.println("Row 37, the object value is: " + object.toString());
            // If the first character of the token is a digit ==> push the token on the stack
            if (object instanceof Integer) {
                stack.push((Integer) object);
                System.out.println("Just pushed an integer, the new stack is: " + stack.peek());
            }
            // Else if the first character of the token is an operator ==>
            else if (object instanceof Character){
                System.out.print("In switch to do the operation, the operation is: ");
                // Evaluate the operation
                switch ((Character) object){
                    case '+': {
                        // Pop the right operand off the stack
                        int rightValue = stack.pop();
                        // Pop the left operand off the stack, do the operation
                        int result = stack.pop() + rightValue;
                        // Push the result on the stack.
                        stack.push(result);
                        System.out.println("addition, the result is: " + stack.peek() + " = " + result);
                        break;
                    }
                    case '-': {
                        int rightValue = stack.pop();
                        int result = stack.pop() - rightValue;
                        stack.push(result);
                        System.out.println("subtraction, the result is: " + stack.peek() + " = " + result);
                        break;
                    }
                    case '*': {
                        int rightValue = stack.pop();
                        int result = stack.pop() * rightValue;
                        stack.push(result);
                        System.out.println("time, the result is: " + stack.peek() + " = " + result);
                        break;
                    }
                    case '/': {
                        int rightValue = stack.pop();
                        int result = stack.pop() / rightValue;
                        stack.push(result);
                        System.out.println("division, the result is: " + stack.peek() + " = " + result);
                        break;
                    }
                    default: {
                        System.out.println(" Here in default");
                    }
                }
            }
        }
        System.out.println(stack.pop());
    }
}
