package main.java;
import java.io.IOException;

public class WordCount {

    public static void main(String[] args) throws IOException {

        checkInputs(args);

        String filePath = args[0];
        int limitNumberOfPair = Integer.parseInt(args[1]);

        WordsCalculationHelper wc = new WordsCalculationHelper(filePath, limitNumberOfPair);
        wc.addUniqueWords(wc.readFileToSepareteWords());
        wc.printPairs(wc.sortPairsByValue());
    }

    private static void checkInputs(String[] args) {

        if (args == null
                || args.length != 2) {
            System.out.println("Wrong inputs!");
            System.exit(0);
        }

        try {
            String filePath = args[0];
            int limitNumberOfPair = Integer.parseInt(args[1]);
        } catch (NumberFormatException ex) {
            System.out.println("Second value not a number");
            System.exit(0);
        }
    }
}

