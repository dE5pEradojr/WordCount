package test.java;

import main.java.WordsCalculationHelper;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

public class TestWordsCalculationHelper {
    @Test
    public void addUniqueWordsTesting() {
        WordsCalculationHelper wch = new WordsCalculationHelper();
        String[] text = {"Hark.", "How ", "the", " bells,"};
        wch.addUniqueWords(text);
        int wordsCount = wch.getWordsCount().size();
        assertEquals("expected words must be 4", 4, wordsCount);
    }

    @Test
    public void printWordsPairsTesting() {
        WordsCalculationHelper wch = new WordsCalculationHelper();
        String[] text = {"All", "Ding", "Ding", "Songs", "Songs", "Songs"};
        wch.addUniqueWords(text);
        List<Map.Entry<String, Integer>> list = wch.sortPairsByValue();

        assertEquals("expected count must be '3'", 3, (int) list.get(0).getValue());
        assertEquals("expected word must be 'Song'", "Songs", list.get(0).getKey());

        assertEquals("expected count must be '2'", 2, (int) list.get(1).getValue());
        assertEquals("expected word must be 'Ding'", "Ding", list.get(1).getKey());

        assertEquals("expected count must be '1'", 1, (int) list.get(2).getValue());
        assertEquals("expected word must be 'All'", "All", list.get(2).getKey());
    }
}
