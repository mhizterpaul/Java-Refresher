package exercises.top_k_largest_list;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Given an unsorted integer array, return the top k larger number in a sorted list. The k is always less than array size. Make sure the time complexity is less than O(nlogn).
 * Example 1: [-1, 15, 59, 22, 6, 42, 45, 0], k=4, return {22, 42, 45, 59}
 * Example 2: [5, 10, 22, 100, 8], k=2, return {22, 100}
 **/

public class KLargestNumber {
    public static void main(String[] args){
        System.out.println(Arrays.toString(kLargestNumber(
                new int[]{-1, 15, 59, 22, 6, 42, 45, 0}, 4)));
        System.out.println(Arrays.toString(kLargestNumber(
                new int[]{5, 10, 22, 100, 8}, 2)));
    }
    public static int[] kLargestNumber(int[] numbers, int k){
        if(k > numbers.length)
            return numbers;
        PriorityQueue<Integer> nums = new PriorityQueue<>(Collections.reverseOrder());
        for (int number : numbers){
            nums.add(number);
        }
        int[] result = new int[k];
        int idx = 0;
        while(k != 0 && !nums.isEmpty()){
            result[idx] = nums.poll();
            idx++;
            k--;
        }
        return result;
    }
}
