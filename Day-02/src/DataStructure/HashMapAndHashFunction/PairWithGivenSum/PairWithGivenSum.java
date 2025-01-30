package DataStructure.HashMapAndHashFunction.PairWithGivenSum;

import java.util.HashSet;
import java.util.Set;

public class PairWithGivenSum {

    public static boolean hasPairWithSum(int[] arr, int target) {
        Set<Integer> seen = new HashSet<>(); // Use a Set for efficient lookup

        for (int num : arr) {
            int complement = target - num;
            if (seen.contains(complement)) {
                return true; // Found a pair
            }
            seen.add(num); // Add the current number to the set
        }

        return false; // No pair found
    }

    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        int target = 9;
        boolean found = hasPairWithSum(arr, target);
        System.out.println("Pair found: " + found); // Output: true

        int[] arr2 = {2, 7, 11, 15};
        int target2 = 10;
        boolean found2 = hasPairWithSum(arr2, target2);
        System.out.println("Pair found: " + found2); // Output: false

        int[] arr3 = {1, 2, 3, 4, 5};
        int target3 = 7;
        boolean found3 = hasPairWithSum(arr3, target3);
        System.out.println("Pair found: " + found3); // Output: true

        int[] arr4 = {1, 2, 3, 4, 5};
        int target4 = 10;
        boolean found4 = hasPairWithSum(arr4, target4);
        System.out.println("Pair found: " + found4); // Output: false

        int[] arr5 = {-1, -2, 3, 4, 5};
        int target5 = 2;
        boolean found5 = hasPairWithSum(arr5, target5);
        System.out.println("Pair found: " + found5); // Output: true

        int[] arr6 = {-1, -2, 3, 4, 5};
        int target6 = -3;
        boolean found6 = hasPairWithSum(arr6, target6);
        System.out.println("Pair found: " + found6); // Output: true

    }
}
