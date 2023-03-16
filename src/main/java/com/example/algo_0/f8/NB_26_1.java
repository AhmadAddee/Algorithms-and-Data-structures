package com.example.algo_0.f8;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class NB_26_1 {
    static int count = 0;
    // @TODO: NB 26.1
    public static int countMostFrequent(String[] words) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        int maxCount = 0;
        for (String word : words) {
            count++;
            int count = 0;
            if (map.containsKey(word)) {
                count = map.get(word);
            }
            map.put(word, count + 1);
            maxCount = Math.max(maxCount, count + 1);
        }
        System.out.println("O(n)?: " + count);
        count = 0;
        return maxCount;
    }

    // @TODO: NB 26.2
    public static int getUniqueStringsCount(String[] strings) {
        Set<String> uniqueStrings = new HashSet<String>();
        for (String string : strings) {
            count++;
            uniqueStrings.add(string);
        }
        System.out.println("O(n)?: " + count);
        count = 0;
        return uniqueStrings.size();
    }

    public static void main(String[] args) {
        String[] words = {"hello", "world", "how", "hello", "are", "you", "doing", "today"};
        System.out.println(countMostFrequent(words));
        System.out.println(getUniqueStringsCount(words));
    }
}
