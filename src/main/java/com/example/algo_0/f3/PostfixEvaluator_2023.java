package com.example.algo_0.f3;

import java.util.EmptyStackException;
import java.util.Stack;

public class PostfixEvaluator_2023 {

    private Stack<Integer> operandStack;

    private static final String OPERATORS = "+-*/";

    public int eval(String expression) throws SyntaxErrorException{
        operandStack = new Stack<>();
        String[] tokens = expression.split(" +");
        try {
            for (String nexToken : tokens) {
                if (Character.isDigit(nexToken.charAt(0))) {
                    int value = Integer.parseInt(nexToken);
                    operandStack.push(value);
                }
                else if (isOperator(nexToken.charAt(0))) {
                    evalOp(nexToken.charAt(0));
                } else {
                    throw new SyntaxErrorException("Invalid character encountered!");
                }
            }
            int result = operandStack.pop();
            if (!operandStack.empty())
                throw new SyntaxErrorException("Syntax Error: the stack is not empty");
            return result;
        } catch (EmptyStackException ex) {
            throw new SyntaxErrorException("Syntax Error: The stack is empty!");
        }
    }

    private boolean isOperator(char ch) {
        return OPERATORS.indexOf(ch) != -1;
    }

    private int evalOp(char op) {
        int rightValue = operandStack.pop();
        int leftValue = operandStack.pop();
        int result = 0;

        switch (op) {
            case '+' -> {
                result = leftValue + rightValue;
                operandStack.push(result);
                return result;
            }
            case '-' -> {
                result = leftValue - rightValue;
                operandStack.push(result);
                return result;
            }
            case '*' -> {
                result =leftValue * rightValue;
                operandStack.push(result);
                return result;
            }
            case '/' -> {
                result = leftValue / rightValue;
                operandStack.push(result);
                return result;
            }
        }
        return result;
    }

    public static class SyntaxErrorException extends Exception {
        SyntaxErrorException(String message) {
            super(message);
        }
    }
}
