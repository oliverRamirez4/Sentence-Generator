import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;
import java.lang.Object;

public class textGenerator extends JTextArea {
    static HashMap<String, HashMap<String, Integer>> data;

    static WordCounter counter;

    static File dir;


    public textGenerator() {
        dir = new File("WordCounterData");
        this.counter = new WordCounter(dir);
        this.data = counter.getData();


    }

    public String generateNextWord(String input) {
        if (!data.containsKey(input)) {
            return " this input is not accepted.";
        } else {
            HashMap options = data.get(input);

            //get a list of all of the keys that go into this
            Set innerKeys = options.keySet();
            Object[] keyArray = innerKeys.toArray();
            String[] nextWord = new String[keyArray.length];
            for (int i = 0; i < keyArray.length; i++) {
                nextWord[i] = (String) keyArray[i];
            }
            //use this static method to change the randomization algorithm
            int idx = randomizationMethod(nextWord, input);

            return (" " + nextWord[idx]);
        }
    }

    public String generateSentence(JTextArea inputBox) {

        String sentence = inputBox.getText();

        while (!sentence.endsWith(".")) {

            String[] allWords = sentence.split(" ");
            if(allWords.length<2){
                return "please insert at least two words to start.";
            }
            String key = (allWords[allWords.length - 2] + " " + allWords[allWords.length - 1]);
            sentence += generateNextWord(key);

        }

        return sentence;
    }


    //Utility for this class
    public static int randomizationMethod(String[] source, String key) {
        int total = 0;
        HashMap candidates = data.get(key);
        for (int i = 0; i < source.length; i++) {
            total += data.get(key).get(source[i]);
        }
        int r = (int) (Math.random() * total) + 1;
        for (int i = 0; i < source.length; i++) {
            candidates.get(source[i]);
            r -= data.get(key).get(source[i]);
            if (r <= 0) {
                return i;


            }
        }
        return 0;
    }
}