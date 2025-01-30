package DataStructure.StackAndQueue.stockspan;

import java.util.Arrays;
import java.util.Stack;

public class StockSpan {

    public static int[] calculateSpan(int[] prices) {
        int n = prices.length;
        int[] spans = new int[n];
        Stack<Integer> stack = new Stack<>(); // Stack to store indices

        for (int i = 0; i < n; i++) {
            int currentPrice = prices[i];

            // Pop indices of prices greater than the current price
            while (!stack.isEmpty() && prices[stack.peek()] <= currentPrice) {
                stack.pop();
            }

            // Calculate span:
            if (stack.isEmpty()) {
                spans[i] = i + 1; // No previous greater element, span is i+1
            } else {
                spans[i] = i - stack.peek(); // Span is the difference between current index and previous greater element's index
            }

            stack.push(i); // Push the current index onto the stack
        }

        return spans;
    }

    public static void main(String[] args) {
        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        int[] spans = calculateSpan(prices);
        System.out.println("Prices: " + Arrays.toString(prices));
        System.out.println("Spans: " + Arrays.toString(spans));

        int[] prices2 = {10, 4, 5, 90, 120, 80};
        int[] spans2 = calculateSpan(prices2);
        System.out.println("Prices: " + Arrays.toString(prices2));
        System.out.println("Spans: " + Arrays.toString(spans2));


        int[] prices3 = {10, 20, 30, 40, 50};
        int[] spans3 = calculateSpan(prices3);
        System.out.println("Prices: " + Arrays.toString(prices3));
        System.out.println("Spans: " + Arrays.toString(spans3));

        int[] prices4 = {50, 40, 30, 20, 10};
        int[] spans4 = calculateSpan(prices4);
        System.out.println("Prices: " + Arrays.toString(prices4));
        System.out.println("Spans: " + Arrays.toString(spans4));

    }
}