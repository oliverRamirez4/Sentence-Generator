import java.util.*;
import java.io.*;

public class WordCounter {
    HashMap<String, HashMap<String, Integer>> data;
    File dir;

    public WordCounter(File dir) {
        this.dir = dir;
        data = new HashMap<String, HashMap<String, Integer>>();
        readDir(dir);
    }

    public HashMap<String, HashMap<String, Integer>> getData() {
        return data;
    }

    public File getDir() {
        return dir;
    }

    public void readDir(File dir){
        if (dir.isDirectory()){
            for(File f: dir.listFiles()){
                readDir(f);
            }
        }
        else {
            readFile(dir);
        }
    }

    public void readFile(File file){
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            StringTokenizer st = new StringTokenizer(reader.readLine());
            if (st.hasMoreTokens()) {
                st.nextToken();
            }
            else {
                return;
            }
            String word1 = "", word2 = "", word3 = "";
            while (st.hasMoreTokens()){
                String temp = st.nextToken();
//                System.out.println(word1 + ", " + word2 + ", " + word3 + ", " + temp);
                if (isAWord(temp)) {
                    word1 = word2;
                    word2 = word3;
                    word3 = temp;
                    addValue(word1, word2, word3);
                }
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void addValue(String word1, String word2, String word3){
        if (word1.length() > 0 && word2.length() > 0 && !word1.equals("<p>") && !word2.equals("<p>")){
            String key = word1 + " " + word2;
            if (data.containsKey(key)){
                HashMap<String, Integer> candidates = data.get(key);
                if (candidates.containsKey(word3)){
                    candidates.put(word3, candidates.get(word3) + 1);
                }
                else {
                    candidates.put(word3, 1);
                }
            }
            else {
                HashMap<String, Integer> candidates = new HashMap<String, Integer>();
                candidates.put(word3, 1);
                data.put(key, candidates);
            }
        }
    }

    public String toString(){
        return "The result of parsing dir "+ dir + " is \n" + data;
    }

    public static boolean isAWord(String s){
        return s.matches(".*\\w.*");
    }
    public static void main(String[] args){
        WordCounter wc = new WordCounter(new File("WordCounterData/acad"));
        System.out.println(wc);

    }
}
