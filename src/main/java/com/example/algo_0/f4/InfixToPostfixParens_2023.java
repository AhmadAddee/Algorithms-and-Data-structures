package com.example.algo_0.f4;

import com.example.algo_0.f3.PostfixEvaluator_2023;

import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;

public class InfixToPostfixParens_2023 {
    private Stack<Character> operatorStack;
    private static final String OPERATORS = "+-*1()";
    private static final int[] PRECEDENCE = {1, 1, 2, 2, -1, -1} ;
    private StringBuilder postfix;

    public String convert(String infix)
    throws SyntaxErrorException {
        operatorStack = new Stack<Character>();
        postfix = new StringBuilder();
        try {
            String nextToken;
            Scanner scan = new Scanner(infix);
            while ((nextToken = scan.findInLine("[\\p{L}\\p{N}]+|[-+/\\*()]")) != null) {
                char firstChar = nextToken.charAt(0);
                if (Character.isJavaIdentifierStart(firstChar) ||
                    Character.isDigit(firstChar)) {
                    postfix.append(nextToken);
                    postfix.append(' ');
                } else if (isOperator(firstChar)) {
                    processOperator(firstChar);
                } else {
                    throw new SyntaxErrorException("Unexpected character encountered: " + firstChar);

                }
            }

            while (!operatorStack.empty()) {
                char op = operatorStack.pop();
                if (op == '(')
                    throw new SyntaxErrorException("Unmatched opening parenthesis");
                postfix.append(op);
                postfix.append(' ');
            }
            return postfix.toString();
        } catch (EmptyStackException ex) {
            throw new SyntaxErrorException("Syntax error: The stack is empty");
        }
    }

    private void processOperator(char op) {
        if (operatorStack.empty() || op == '(') {
            operatorStack.push(op);
        } else {
            char topOp = operatorStack.peek();
            if (precedence(op) > precedence(topOp)) {
                operatorStack.push((op));
            } else {
                while (!operatorStack.empty()
                && precedence(op) <= precedence(topOp)) {
                    operatorStack.pop();
                    if (topOp == '(') break;
                    postfix.append(topOp);
                    postfix.append(' ');
                    if (!operatorStack.empty()) {
                        topOp = operatorStack.peek();
                    }
                }
                if (op != ')')
                    operatorStack.push(op);
            }
        }
    }

    private int precedence(Character ch) {
        return PRECEDENCE[OPERATORS.indexOf(ch)];
    }

    private boolean isOperator(char ch) {
        return OPERATORS.indexOf(ch) != -1;
    }

    public int solveIntFix() throws PostfixEvaluator_2023.SyntaxErrorException {
        PostfixEvaluator_2023 evaluator = new PostfixEvaluator_2023();
        return evaluator.eval(postfix.toString());
    }

    public class SyntaxErrorException extends Exception{
        SyntaxErrorException(String message){
            super(message);
        }
    }
}
