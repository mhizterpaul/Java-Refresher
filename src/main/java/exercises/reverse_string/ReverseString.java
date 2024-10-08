package exercises.reverse_string;

import java.util.Stack;

/**
 * Write a function that takes a string as input and returns the string reversed.
 * Example1: input: "Hello World!", return "!dlroW olleH"
 * Example2: input: “abcde”, return “edcba”
 **/
public class ReverseString {
    public static void main(String[] args){
        System.out.println(reverseString("Hellow World!"));
        System.out.println(reverseString("abcde"));
    }
    public static String reverseString(String s){
        Stack<Character> chars = new Stack<>();
        for(char x : s.toCharArray()){
            chars.add(x);
        }
        StringBuilder result = new StringBuilder();
        while(!chars.isEmpty()){
            result.append(chars.pop());
        }
        return result.toString();
    }
}
