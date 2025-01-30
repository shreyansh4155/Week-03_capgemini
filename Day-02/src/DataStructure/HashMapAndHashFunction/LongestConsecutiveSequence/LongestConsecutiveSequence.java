package DataStructure.HashMapAndHashFunction.LongestConsecutiveSequence;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    public static int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longestStreak = 0;

        for (int num : nums) {
            // Check if this number is the start of a sequence
            if (!numSet.contains(num - 1)) { // If num-1 doesn't exist, num is the start
                int currentNum = num;
                int currentStreak = 1;

                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        int longest = longestConsecutive(nums);
        System.out.println("Longest consecutive sequence: " + longest); // Output: 4

        int[] nums2 = {0,3,7,2,5,8,4,6,0,1};
        int longest2 = longestConsecutive(nums2);
        System.out.println("Longest consecutive sequence: " + longest2); // Output: 9

        int[] nums3 = {1,2,3,4,5};
        int longest3 = longestConsecutive(nums3);
        System.out.println("Longest consecutive sequence: " + longest3); // Output: 5

        int[] nums4 = {1,2,1,2,1,2};
        int longest4 = longestConsecutive(nums4);
        System.out.println("Longest consecutive sequence: " + longest4); // Output: 2

        int[] nums5 = {};
        int longest5 = longestConsecutive(nums5);
        System.out.println("Longest consecutive sequence: " + longest5); // Output: 0


    }
}
