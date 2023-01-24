package com.example.algo_0.f3;

import javax.swing.*;
import java.util.EmptyStackException;
import java.util.Stack;

public class ParenChecker {

    private static final String OPEN_PARENTHESIS  = "{[(";
    private static final String CLOSE_PARENTHESIS  = "}])";

    private static Stack<Character> charStack;

    public static boolean isBalanced(String expression){
        boolean balanced = true;
        charStack = new Stack<Character>();
        try {
            int index = 0;
            while (balanced && index < expression.length()) {
                char nextCh = expression.charAt(index);
                if (isOpen(nextCh)) {
                    charStack.push(nextCh);
                } else if (isClose(nextCh)){
                    char topCh = charStack.pop();
                    balanced = OPEN_PARENTHESIS.indexOf(topCh) == CLOSE_PARENTHESIS.indexOf(nextCh);
                }
                index++;
            }
        }catch (EmptyStackException ex){
            balanced = false;
        }
        return (balanced && charStack.empty());
    }

    private static boolean isOpen(char ch){
        return OPEN_PARENTHESIS.indexOf(ch) > -1;
    }

    private static boolean isClose(char ch){
        return CLOSE_PARENTHESIS.indexOf(ch) > -1;

    }

    public static void main(String[] args) {
        while (true) {
            String expression = JOptionPane.showInputDialog(
                    "Enter an expression contai ni ng parentheses");
            if (ParenChecker.isBalanced(expression)) {
                JOptionPane.showMessageDialog(null, expression + " is balanced");
            } else {
                JOptionPane.showMessageDialog(null, expression + " is not balanced");
            }
        }
    }
}
