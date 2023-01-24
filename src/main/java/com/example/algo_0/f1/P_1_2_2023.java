package com.example.algo_0.f1;

import java.util.ArrayList;

public class P_1_2_2023 {
    /*************** P1 ******/
    public static void replace(ArrayList<String> aList, String oldItem, String newItem) {
        for (int i = 0; i < aList.size(); i++) {
            if (aList.get(i).equals(oldItem))
                aList.set(i, newItem);
        }
    }

    /*************** P2 ******/
    public static void delete(ArrayList<String> aList, String target) {
        //aList.remove(target);

        for (int i = 0; i < aList.size(); i++)
            if (aList.get(i).equals(target)){
                aList.remove(i);
                return;
            }
    }
}
