package com.example.algo_0.f1;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * * En algoritm är ett begränsat antal instruktioner/steg för att lösa en uppgift, som från givna
 *   indata med säkerhet leder till korrekta utdata.
 * * En datastruktur är en struktur som organiserar data.
 * * Ett elementärt exempel är en array.
 * * Val av datastruktur ska göras så att vi effektivt kan lagra, organisera och processa data.
 * * För vissa problem är val av rätt datastruktur mer än halva läsningen!
 *
 * * En abstrakt datatyp definierar operationerna vi kan utföra på de data den skall lagra.
 * * Den definierar inte implementationen.
 * * I ett objektorienterat språk implementerar man gärna en ADT som en klass men det
 *   går också att implementera en ADT i exempelvis C.
 * * Ex på ADT: lista, stack, kö.
 * * Kan implementeras med en array eller en länkad lista som intern datastruktur.
 */
public class Main {
    public static void main(String[] args) {
        /*********************************** NB 0
        ArrayList_2023<String> list = new ArrayList_2023<>();
        for (int i = 0; i < 12; i++){
            System.out.println("Adds, size before is: " + list.size());
            list.add("N " + (i+1));
        }
        System.out.println("The size now is "+ list.size());

        System.out.println("*************Get**********");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));;
        }

        System.out.println("***Remove index 7****");
        list.remove(7);
        System.out.println("The size now is "+ list.size());
        System.out.println("*************Get**********");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));;
        }

        /************************************************************ NB 1
        List<DirectoryEntry_2023> phoneList = new ArrayList<DirectoryEntry_2023>();
        while(true){
            String name = JOptionPane.showInputDialog("Vänligen ange namn eller enter för att avsluta");
            if(name.equals(""))
                break;
            String number = JOptionPane.showInputDialog("Vänligen ange nummer");
            phoneList.add(new DirectoryEntry_2023(name,number));
        }
        while(true){
            String name = JOptionPane.showInputDialog("Vem vill du söka efter?");
            if(name.equals(""))
                break;
            int index = phoneList.indexOf(new DirectoryEntry_2023(name,""));
            if(index!=-1)
                System.out.println("Nummer: "+phoneList.get(index).number);
            else
                System.out.println("Saknas");
        }
        System.out.println("Hej då");
         */

    }
}
