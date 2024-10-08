package exercises.translate_number_to_word;

import java.util.HashMap;

/**
 * Given a non-negative integer n, print the number in words.
 * Example1:
 * Input: 10245
 * Output: "ten thousand two hundred forty five"
 * Example2:
 * Input: 125
 * Output: "one hundred twenty five"
 **/

public class TranslateNumberToWord {

    public static void main(String[] args){
       System.out.println(translateNumberToWord(10245));
       System.out.println(translateNumberToWord(10));
       System.out.println(translateNumberToWord(125));
       System.out.println(translateNumberToWord(1234567));
       System.out.println(translateNumberToWord(123534093));
    }
    public static String translateNumberToWord(int number) {
        if (Integer.signum(number) == -1)
            return "";
        String[] words = new String[]{"one",
                "two", "three", "four", "five",
                "six", "seven", "eight", "nine",
                "ten", "eleven", "twelve", "thirteen",
                "fourteen", "fifteen", "sixteen", "seventeen",
                "eighteen", "nineteen",
                "twenty", "thirty", "fourty",
                "fifty", "sixty", "seventy", "eighty",
                "ninety", "hundred", "thousand", "million"};
        HashMap<Integer, String> num2Word = new HashMap<>();
        int key = 1;
        for (int i = 0; i < words.length; i++) {
            if (key < 20) {
                num2Word.put(key, words[i]);
                key += 1;
                if(key == 20) continue;
            }
            if (key >= 20 && key < 100) {
                num2Word.put(key, words[i]);
                key += 10;
                if(key == 100) continue;
            }
            if (key >= 100) {
                num2Word.put(key, words[i]);
                key = key == 100 ? 1000 : (int) Math.pow(1000, (double) i-26);
            }
        }
        return wordBuilder(num2Word, number);

    }

    public static String wordBuilder(HashMap<Integer, String> dict, int target) {
        char[] numTokens = Integer.toString(target).toCharArray();
        int placeValue = (int) Math.pow(10, numTokens.length - 1);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numTokens.length; i++) {
            int num = Integer.parseInt(
                    Character.toString(numTokens[i])
            );
            if(num == 0){
                placeValue /= 10;
                continue;
            }
            if (placeValue >= 1000) {
                int[] k = coeffSplit(target);
                placeValue = (int) Math.pow(1000, k[1]);
                String subString = wordBuilder(dict, k[0]) + " " + dict.get(placeValue) + " ";
                target -= k[0]*placeValue;
                i += Integer.toString(k[0]).length()-1;
                result.append(subString);
            }

            if (placeValue == 100) {
                String subString = dict.get(num) + " " + dict.get(placeValue) + " ";
                result.append(subString);
            }
            if (placeValue == 10) {
                if (num == 1) {
                    String numToken = Character.toString(numTokens[numTokens.length - 2]) +
                            Character.toString(numTokens[numTokens.length - 1]);
                    num = Integer.parseInt(numToken);
                    result.append(dict.get(num));
                    break;
                } else {
                    String value = dict.get(num * placeValue) + " ";
                    result.append(value);
                }

            }
            if (placeValue == 1)
                result.append(dict.get(num));
            placeValue /= 10;
        }
        return result.toString();
    }
    public static int[] coeffSplit(int input){
        int index = 0;
        while(Integer.toString(input).length() >= 4){
           input /= 1000;
           index++;
       }
        return new int[]{input, index};
    }
}