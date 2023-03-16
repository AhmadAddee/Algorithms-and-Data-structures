package com.example.algo_0.labb2;

import java.util.LinkedList;
import java.util.Queue;

public class upp_6 {

    private static class State {
        public String str;
        public String currentWord;

        public State(String str, String s){
            this.str = str;
            this.currentWord = s;
        }
    }

    public static String findLeastMoves(String str){
        String returnWord = findLeastMoves(str,"");
        return "The word '" + str + "' takes at least " +returnWord.length() + " steps, solution: " + returnWord;
    }
    private static String findLeastMoves(String str, String currentWord){
        Queue<State> queue = new LinkedList<>();
        State state = new State(str, currentWord);

        while (!isSorted(state.str)){
            String str1 = BMove(state.str);
            String str2 = SMove(state.str, 1);
            queue.offer(new State(str1, state.currentWord + "b"));
            queue.offer(new State(str2, state.currentWord + "s"));
            state = queue.poll();
        }
        return state.currentWord;
    }

    private static String subMove(String str, int b) {
        String newStr = str.substring(b) + str.substring(0, b);
        return newStr;
    }

    private static String SMove(String str, int s) {
        return subMove(str, str.length() - s);
    }

    private static String BMove(String str) {
        String answer = str.substring(1, 2) + str.substring(0, 1) + str.substring(2);
        return answer;
    }

    private static boolean isSorted(String str){
        return str.equals("ABCDE");
    }

    public static void main(String[] args) {

        String str1 = "ADCBE";
        System.out.println("ADCBE" + "\n" + findLeastMoves(str1));

        String str2 = "EDCBA";
        System.out.println("EDCBA" + "\n" + findLeastMoves(str2));
    }

}
