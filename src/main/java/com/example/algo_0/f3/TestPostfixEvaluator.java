package com.example.algo_0.f3;

import java.util.Scanner;

public class TestPostfixEvaluator {
    public static void main(String[] args) {
        PostfixEvaluator_2023 evaluator = new PostfixEvaluator_2023();

        String line;
        Scanner in = new Scanner(System.in);
        while (true){
            System.out.println("Enter a postfix expression to evaluate");
            line = in.nextLine();
            if (!line.equals("")){
                try {
                    int result = evaluator.eval(line);
                    System.out.println("Value is " + result);
                } catch (PostfixEvaluator_2023.SyntaxErrorException ex) {
                    System.out.println("Syntax error " + ex.getMessage());
                }
            } else {
                break;
            }
        }
    }
}
