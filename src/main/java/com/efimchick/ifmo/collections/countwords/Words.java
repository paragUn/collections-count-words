package com.efimchick.ifmo.collections.countwords;


import com.sun.source.tree.Tree;

import java.util.*;

public class Words {
    public String countWords(List<String> lines) {
        String sum = "";
        ArrayList<String> allWords = new ArrayList<>(6800);
        ArrayList<String> uniqumList = new ArrayList<>(2500);
        HashMap<String, Integer> resultMap = new HashMap<>();


        for(String line : lines){
            String[] lineMass  = line.toLowerCase()
                    .replaceAll("\\p{P}", "")
                    .split("\\s");

            for (String word : lineMass) {
                if (!uniqumList.contains(word) && word.length() >=4 && word.length() <=10 ) {
                    uniqumList.add(word);
                }
                allWords.add(word);
            }
        }
        for (String currentWord : uniqumList){
            int count = 0;
            for (String wordsFromAllWords : allWords){
                if(currentWord.equals(wordsFromAllWords)) count++;
            }
            resultMap.put(currentWord, count);
           //sum += currentWord + " - " + count + "\n";
        }
        LinkedHashMap sortedMap = new LinkedHashMap();
        ArrayList<Integer> list = new ArrayList<>();
        for (Map.Entry entry : resultMap.entrySet()) {
            list.add((Integer) entry.getValue());
        }
        Collections.sort(list);
        Collections.reverse(list);
        return sum;
    }
}
