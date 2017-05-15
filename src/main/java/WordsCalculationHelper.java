package main.java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class WordsCalculationHelper {

    private Map<String, Integer> wordsCount = new TreeMap<>();
    private String filePath;
    private int limitNumberOfPair;

    public WordsCalculationHelper(String filePath, int limitNumberOfPair) {
        this.filePath = filePath;
        this.limitNumberOfPair = limitNumberOfPair;
    }

    public WordsCalculationHelper() {
    }

    public Map<String, Integer> getWordsCount() {
        return wordsCount;
    }

    public String[] readFileToSepareteWords() throws IOException {
        //Read file and splits to separate words
        String[] everything;
        String regexSplit = "[ ,.]+";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
                sb.append(line.toLowerCase());
                sb.append(" ");
                line = br.readLine();
            }
            everything = sb.toString().split(regexSplit);
        }
        return everything;
    }

    public void addUniqueWords(String[] text) {
        //Add unique words to collection
        for (String s : text) {
            if (wordsCount.containsKey(s)) {
                wordsCount.put(s, wordsCount.get(s) + 1);
            } else {
                wordsCount.put(s, 1);
            }
        }
    }

    public List<Map.Entry<String, Integer>> sortPairsByValue() {
        //Sort by value
        Set<Map.Entry<String, Integer>> set = wordsCount.entrySet();
        List<Map.Entry<String, Integer>> list = new ArrayList<>(set);
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });
        return list;
    }

    public void printPairs(List<Map.Entry<String, Integer>> list) {
        //Print out an amount of unique words which greater or equal to N
        int count = 0;
        for (Map.Entry<String, Integer> entry : list) {
            if (entry.getValue() >= limitNumberOfPair) {
                System.out.println(entry.getKey() + "=" + entry.getValue());
                count++;
            }
            if (limitNumberOfPair != 0)
                if (count >= limitNumberOfPair) break;
        }
    }
}
