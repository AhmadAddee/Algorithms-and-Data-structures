package com.example.algo_0.labb2;

public class upp_5 {

    private static String subMove(String str, int s)
    {
        String newStr = str.substring(s) + str.substring(0,s);
        return newStr;
    }

    private static String BMove(String str)
    {
        String newStr = str.substring(1,2) + str.substring(0,1) + str.substring(2);
        return newStr;
    }
    private static String SMove(String str)
    {
        return subMove(str, str.length() - 1);
    }

    public static String findLeastMoves(String str)
    {
        String returnWord = findLeastMoves(str,"");
        return "The word '" + str + "' takes at least " + returnWord.length()+ " steps, solution: " + returnWord;
    }

    public static String findLeastMoves(String str, String currentWord)
    {
        if (str.equals("ABCDE")) {
            return currentWord;
        }
        if (currentWord.length() >= 15) {
            return null;
        }

        String str1 = BMove(str);
        String str2 = SMove(str);
        String bSolution = findLeastMoves(str1, currentWord + "b");
        String sSolution = findLeastMoves(str2, currentWord + "s");

        if(bSolution == null){
            return sSolution;
        }

        else if (sSolution == null){
            return bSolution;
        }

        else if(bSolution.length() > sSolution.length()){
            return sSolution;
        }

        else{
            return bSolution;
        }
    }

    public static void main(String[] args){

        String str1 = "ADCBE";
        System.out.println("ADCBE" + "\n" + findLeastMoves(str1));

        String str2 = "EDCBA";
        System.out.println("EDCBA" + "\n" + findLeastMoves(str2));
    }
}
