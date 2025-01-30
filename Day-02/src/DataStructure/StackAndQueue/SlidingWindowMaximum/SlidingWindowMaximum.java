package DataStructure.StackAndQueue.SlidingWindowMaximum;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SlidingWindowMaximum {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n == 0 || k <= 0) {
            return new int[0]; // Handle edge cases: empty array or invalid k
        }

        int[] result = new int[n - k + 1]; // Number of windows
        Deque<Integer> deque = new ArrayDeque<>(); // Deque to store indices

        for (int i = 0; i < n; i++) {
            // 1. Remove elements from the front of the deque that are out of the current window
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            // 2. Remove elements from the back of the deque that are smaller than the current element
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }

            // 3. Add the current element's index to the deque
            deque.offerLast(i);

            // 4. The maximum element in the current window is at the front of the deque
            if (i >= k - 1) { // Start adding to result after the first window is formed
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }

        return result;
    }

    public static void main(String[] args) { // Corrected main method signature
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] result = maxSlidingWindow(nums, k); // Corrected variable type
        System.out.println("Nums: " + Arrays.toString(nums));
        System.out.println("Window size: " + k);
        System.out.println("Max Sliding Window: " + Arrays.toString(result));

        int[] nums2 = {1, -1};
        int k2 = 1;
        int[] result2 = maxSlidingWindow(nums2, k2);
        System.out.println("Nums: " + Arrays.toString(nums2));
        System.out.println("Window size: " + k2);
        System.out.println("Max Sliding Window: " + Arrays.toString(result2));

        int[] nums3 = {1, 3, 1, -3, 5, 3, 6, 7};
        int k3 = 2;
        int[] result3 = maxSlidingWindow(nums3, k3);
        System.out.println("Nums: " + Arrays.toString(nums3));
        System.out.println("Window size: " + k3);
        System.out.println("Max Sliding Window: " + Arrays.toString(result3));

        int[] nums4 = {7, 2, 4};
        int k4 = 2;
        int[] result4 = maxSlidingWindow(nums4, k4);
        System.out.println("Nums: " + Arrays.toString(nums4));
        System.out.println("Window size: " + k4);
        System.out.println("Max Sliding Window: " + Arrays.toString(result4));

    }
}