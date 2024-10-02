package exercises.binary_search_target_search; /**
 * Binary Search Coding Exercise
 *
 * Task Description:
 * Please complete the coding questions using binary search.
 *
 * Search for the target in a sorted array, and return the index. If the target is not in this array, return -1.
 *
 * Example:
 *
 * Input: [1, 5, 7, 8, 9, 11, 18, 19, 20, 25], target=11, output=5.
 *
 * Input: [1, 2, 3, 4, 5], target=10, output=-1
 */
import java.util.Arrays;
import java.util.HashMap;

public class FindTarget {
    public static void main (){
        System.out.println(findTarget(new int[]{1,2,3,4,5,6,7,9}, 2));
    }
    static int findTarget(int[] arr, int target){
        //copy the array with index into a map
        HashMap<Integer, Integer> idxMap = new HashMap<>();
        for(int i = 0; i < arr.length; i++) idxMap.put(arr[i], i);

        //sort the array
        Arrays.sort(arr);

        int left = 0;
        int right = arr.length-1;
        int center = (right- left)/2;
        while(right > left) {
            if((right - left) == 1){
                if(center == left) {
                    return arr[center + 1] == target ? idxMap.get(target) : -1;
                }else{
                    return arr[center - 1] == target ? idxMap.get(target) : -1;
                }
            }
            if(arr[center] == target) return idxMap.get(target);
            if(target < arr[center]){
                right = center;
                center -= (right - left) / 2;
            }else{
                left = center;
                center += (right - left) / 2;
            }
        }
        return -1;
    }
}
