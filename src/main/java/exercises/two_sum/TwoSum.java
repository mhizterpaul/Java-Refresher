package exercises.two_sum;
import java.util.Arrays;
import java.util.OptionalInt;

/**
 * Given an integer array, return true if two numbers in this array can be summed to target.
 * Example1: input[1, 2, 3, 4], target:5, return true
 * Example2: input[1,4,5,1,6], target 12, return false
 **/
public class TwoSum {
    public static void main(String[] args){
        System.out.println(twoSum(new int[]{1, 2, 3, 4},5));
        System.out.println(twoSum(new int[]{1,4,5,1,6},12));
    }
    public static boolean twoSum(int[] nums, int target){
        int left = 0, right = nums.length-1;
        Arrays.sort(nums);
        while ( left < right){
            int currSum = nums[left] + nums[right];
            if(currSum == target){
                return true;
            }else if(currSum < target){
                left++;
            }else{
                right--;
            }
        }
        return false;
    }
}
