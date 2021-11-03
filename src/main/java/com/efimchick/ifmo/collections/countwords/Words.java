package com.efimchick.ifmo.collections.countwords;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Words {
    public String countWords(List<String> lines) {
        StringBuilder sumStr = new StringBuilder();
        HashMap<String, Integer> resultMap = new HashMap<>();

        for (String s : lines) {
            String[] arr = s.split("[^а-яА-Яa-zA-Z]");
            for (String i : arr) {
                i = i.toLowerCase();
                if (i.length() >= 4) {
                    if (resultMap.containsKey(i)) {
                        resultMap.put(i, resultMap.get(i) + 1);
                    } else {
                        resultMap.put(i, 1);
                    }
                }
            }
        }
        Comparator myComp = new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                                        int comparator = o2.getValue().compareTo(o1.getValue());
                                        if (comparator == 0) {
                                            comparator = o1.getKey().compareTo(o2.getKey());
                                        }
                                        return comparator;
                                    }
                                };

        List<Map.Entry<String, Integer>> valueList = new ArrayList(resultMap.entrySet());
        Collections.sort(valueList, myComp);

        for (Map.Entry<String, Integer> entry : valueList){
            if(entry.getValue() >= 10) {
                sumStr.append(entry.getKey() + " - " + entry.getValue() + "\n");
            }
        }
        return sumStr.toString().trim();
    }
}

//"[^A-Za-zА-Яа-яЁё]+", "" -net
//"\\p{P}" - ne vse chitaet
