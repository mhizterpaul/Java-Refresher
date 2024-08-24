import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class ListCoding {
    private static List<String>[] groupString(List<String> input){
        List<String>[] ans = new List[input.size()];
        quickSort(input, 0, -1);
        Map<java.lang.Character, List<String>> chars = new HashMap<>();
        for(String string : input){
            char initial = string.charAt(0);
            if(chars.get(initial) != null){
                chars.get(initial).add(string);
            }else{
                List<String> arrayStrings = new ArrayList<>(List.of(string));
                chars.put(initial, arrayStrings);
            }
        }
        int i = 0;
        for(char key: chars.keySet()){
            ans[i] = chars.get(key);
            i++;
        }
        return Arrays.copyOf(ans, i);
    }
    public static void main(String[] args){
        List<String> input1 = List.of("bcd", "abc", "cde");
        List<String> input2 = List.of("abc", "bcd", "bbb", "ace", "snb", "aaaa", "bbbbb", "eeee");

        for(List<String> list : groupString(input1)){
            System.out.println(list.toString());
        }
        for(List<String> list : groupString(input2)){
            System.out.println(list.toString());
        }
    }
    private static void swap(List<String> strings, int i, int j){
        String tmp = strings.get(i);
        strings.set(i, strings.get(j));
        strings.set(j, tmp);
    }
    private static int partition(List<String> strings, int left, int right){
        int i = left;
        int j = right;
        while (i < j){
            while(i < j && strings.get(j).compareTo(strings.get(left)) >= 0)
                j--;
            while(i < j && strings.get(i).compareTo(strings.get(left)) <= 0)
                i++;
            swap(strings, i, j);
        }
        swap(strings, i, left);
        return i;
    }
    public static void quickSort(List<String> strings, int left, int right){
        if(left >= right)
            return;
        int pivot = partition(strings, left, right);
        quickSort(strings, left, pivot-1);
        quickSort(strings, pivot+1, right);
    }
}
