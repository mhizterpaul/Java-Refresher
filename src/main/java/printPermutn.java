import java.util.List;
import java.util.ArrayList;


public class printPermutn {
     private static void backtrack(List<Integer> state, int[] choices, boolean[] selected, List<List<Integer>> res){
         if(state.size() == choices.length){
             res.add(List.copyOf(state));
             return;
         }
         for(int i=0; i < choices.length; i++){
             int choice = choices[i];
             if(!selected[i]){
                 state.add(choice);
                 selected[i] = true;
                 //move to the next choice in this round of selection
                 backtrack(state, choices, selected, res);
                 //undo the choice and restore the previous state
                 selected[i] = false;
                 state.remove(state.size()-1);
             }
         }
    }
    public static List<List<Integer>> printPermutatn(int[] arr){
         List<List<Integer>> res = new ArrayList<List<Integer>>();
         backtrack(new ArrayList<Integer>(), arr, new boolean[arr.length],res );
         return res;
    }
    public static void main(String[] args){
         List<List<Integer>> res = printPermutatn(new int[]{1,2,3});
         System.out.println(res);
    }
}
