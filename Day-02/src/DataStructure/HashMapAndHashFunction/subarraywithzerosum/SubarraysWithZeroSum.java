package DataStructure.HashMapAndHashFunction.subarraywithzerosum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubarraysWithZeroSum {

    public static List<List<Integer>> findSubarraysWithZeroSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, Integer> sumFrequencyMap = new HashMap<>(); // Cumulative sum -> frequency
        sumFrequencyMap.put(0, 1); // Initialize with a sum of 0 and frequency 1 (for prefix sums)

        int currentSum = 0;

        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];

            if (sumFrequencyMap.containsKey(currentSum)) {
                int frequency = sumFrequencyMap.get(currentSum);
                for (int j = 0; j < frequency; j++) {
                    List<Integer> subarray = new ArrayList<>();
                    int startIndex = 0;
                    int sumAtIndex = 0;
                    for(int k = 0; k <= i; k++){
                        sumAtIndex += nums[k];
                        if(sumAtIndex == currentSum){
                            startIndex = k;
                            break;
                        }
                    }
                    for (int k = startIndex + 1; k <= i; k++) {
                        subarray.add(nums[k]);
                    }
                    result.add(subarray);
                }
                sumFrequencyMap.put(currentSum, frequency + 1);
            } else {
                sumFrequencyMap.put(currentSum, 1);
            }
        }

        return result;
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, -2, 4, -4, 1};
        List<List<Integer>> subarrays = findSubarraysWithZeroSum(nums);

        System.out.println("Subarrays with zero sum:");
        for (List<Integer> subarray : subarrays) {
            System.out.println(subarray);
        }

        int[] nums2 = {0, 0, 0};
        List<List<Integer>> subarrays2 = findSubarraysWithZeroSum(nums2);
        System.out.println("Subarrays with zero sum:");
        for (List<Integer> subarray : subarrays2) {
            System.out.println(subarray);
        }

        int[] nums3 = {-1, 1, 0};
        List<List<Integer>> subarrays3 = findSubarraysWithZeroSum(nums3);
        System.out.println("Subarrays with zero sum:");
        for (List<Integer> subarray : subarrays3) {
            System.out.println(subarray);
        }

        int[] nums4 = {1, 2, 3, -3, 1, 2, -2};
        List<List<Integer>> subarrays4 = findSubarraysWithZeroSum(nums4);
        System.out.println("Subarrays with zero sum:");
        for (List<Integer> subarray : subarrays4) {
            System.out.println(subarray);
        }

    }
}