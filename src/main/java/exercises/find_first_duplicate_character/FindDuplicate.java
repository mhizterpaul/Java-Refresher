package exercises.find_first_duplicate_character;
import java.util.HashSet;

/**
 * Complete the following method so given a string it returns the index of the first duplicated character or -1 if there are no duplicated characters.
 * Example1: input: abcabc, return: 3
 * Example2: input: abcd, return: -1
 **/

public class FindDuplicate {
    public static void main(String[] args){
        System.out.println(findDuplicate("abc"));
        System.out.println(findDuplicate("babdk"));
    }
    public static int findDuplicate(String input){
       HashSet<Character> inputSet = new HashSet<>();
       for(char x: input.toCharArray()){
          int currSize = inputSet.size();
          inputSet.add(x);
          if(currSize == inputSet.size())
              return x-96;
       }
       return -1;
    }

}
