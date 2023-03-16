package com.example.algo_0.f7;

import javax.swing.*;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        // A key of string and a value of DirectoryEntry class
        Map<String, DirectoryEntry> phoneList = new TreeMap<>();
        while (true) {
            String name = JOptionPane.showInputDialog("Name eller enter:");
            if (name.equals(""))
                break;
            String number = JOptionPane.showInputDialog("Number");
            DirectoryEntry d = new DirectoryEntry(name, number);
            phoneList.put(d.name, d);
        }
        while (true) {
            String name = JOptionPane.showInputDialog("Vem vill du söka efter?");
            if (name.equals(""))
                break;
            DirectoryEntry found = phoneList.get(name);
            if (found != null)
                System.out.println("Nummer: " + found.number);
            else System.out.println("Saknas");
        }
        System.out.println("Hej då!");
    }

    public static class DirectoryEntry implements Comparable<DirectoryEntry>{
        public String name;
        public String number;

        public DirectoryEntry(String name, String number) {
            this.name = name;
            this.number = number;
        }

        @Override
        public int compareTo(DirectoryEntry e) {
            return name.compareTo(e.name);
        }
    }
}
