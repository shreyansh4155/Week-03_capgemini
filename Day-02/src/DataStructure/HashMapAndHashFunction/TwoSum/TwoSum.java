package DataStructure.HashMapAndHashFunction.TwoSum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>(); // Value -> Index

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (numMap.containsKey(complement)) {
                return new int[] {numMap.get(complement), i}; // Return indices
            }
            numMap.put(nums[i], i); // Store value and its index
        }

        return new int[0]; // No solution found (or throw an exception)
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(nums, target);
        System.out.println("Indices: " + Arrays.toString(result)); // Output: [0, 1]

        int[] nums2 = {3,2,4};
        int target2 = 6;
        int[] result2 = twoSum(nums2, target2);
        System.out.println("Indices: " + Arrays.toString(result2)); // Output: [1, 2]

        int[] nums3 = {3,3};
        int target3 = 6;
        int[] result3 = twoSum(nums3, target3);
        System.out.println("Indices: " + Arrays.toString(result3)); // Output: [0, 1]

        int[] nums4 = {1,2,3,4,5};
        int target4 = 7;
        int[] result4 = twoSum(nums4, target4);
        System.out.println("Indices: " + Arrays.toString(result4)); // Output: [2, 3]

        int[] nums5 = {1,2,3,4,5};
        int target5 = 10;
        int[] result5 = twoSum(nums5, target5);
        System.out.println("Indices: " + Arrays.toString(result5)); // Output: [] (empty array)


    }
}
