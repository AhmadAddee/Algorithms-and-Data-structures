package com.example.algo_0.f5;

import java.util.Scanner;

public class CoinCalculator {
    static int coinsRequired;

    public static int findSolution(int coins, int crowns) {
        // Kolla om målpoängen har nåtts
        if (coins == coinsRequired) {
            // Om poängen är samma som målpoängen, är antalet crowns lösningen
            return crowns;
        }

        if (coins > coinsRequired) {
            return -1;
        }

        // Kollar om poängen är mindre än målpoängen
        if (coins < coinsRequired) {
            // Om poängen är mindre än målpoängen, anropa funktionen med olika mynt
            int solution5 = findSolution(coins + 4, crowns + 5);
            int solution10 = findSolution(coins * 3, crowns + 10);

            // Om båda lösningarna är större än 0, returnera det minsta värdet
            if (solution5 > 0 && solution10 > 0) {
                return Math.min(solution5, solution10);
            }
            // Om en av lösningarna är större än 0, returnera den
            else if (solution5 > 0) {
                return solution5;
            } else if (solution10 > 0) {
                return solution10;
            }

            // Om ingen lösning är större än 0, returnera -1
            else {
                return -1;
            }
        }
        // Returnera -1 om ingen lösning hittas
        return -1;
    }



    public static void main(String[] args) {

        System.out.println("Vilken poäng ska uppnås: ");
        Scanner sc = new Scanner(System.in);
        coinsRequired = sc.nextInt();

        int lösning = findSolution(1, 0);

        System.out.println("Poängen kan nås med " + lösning + " kronor.");
    }
}