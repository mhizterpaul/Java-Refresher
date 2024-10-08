package exercises.calculateWordsFrequency;
import java.util.*;

/**
 * Please complete the “words frequency” coding problem.
 * Give a list of strings, calculate and print the frequency of each string based on descending order of the frequency.
 * Example1: input {“abc”, “bcd”, “abc”}, output “abc”|2, “bcd”|1
 * */
public class WordFrequency {

    public static void main(String[] args){
        String[] words = {"abc", "bcd", "abc"};
        wordFrequency(words);
    }
    public static void wordFrequency(String[] input) {
        HashMap<String, Integer> words = new HashMap<>();
        for (String string : input) {
            if (words.get(string) == null) {
                words.put(string, 1);
                continue;
            }
            words.put(string, words.get(string) + 1);
        }
        PriorityQueue<Map.Entry<String, Integer>> sortedMap = sort(words);
        StringBuilder result = new StringBuilder();

        while(!sortedMap.isEmpty()){
            Map.Entry<String, Integer> entry = sortedMap.poll();
            String entryString = "\"" + entry.getKey() + "\""
                    + "|" + entry.getValue();
            if(!sortedMap.isEmpty())
                entryString += ", ";
            result.append(entryString);
        }
        System.out.println(result);
    }
    static Comparator<Map.Entry<String, Integer>>  comparator = new Comparator<>() {
        @Override
        public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
           return o2.getValue().compareTo(o1.getValue());
        }
    };
    public static PriorityQueue<Map.Entry<String, Integer>> sort(HashMap<String, Integer> input){
        PriorityQueue<Map.Entry<String, Integer>> result = new PriorityQueue<>(input.size(), comparator);
        result.addAll(input.entrySet());
        return result;
    }
}
