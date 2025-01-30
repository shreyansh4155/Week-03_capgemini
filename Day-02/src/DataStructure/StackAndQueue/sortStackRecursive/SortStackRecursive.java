package DataStructure.StackAndQueue.sortStackRecursive;

import java.util.Stack;

public class SortStackRecursive {

    public static void sortStack(Stack<Integer> stack) {
        if (stack.isEmpty() || stack.size() == 1) {
            return; // Base case: Empty or single-element stack is already sorted
        }

        int temp = stack.pop(); // Pop the top element
        sortStack(stack);       // Recursively sort the remaining stack

        insertInSortedOrder(stack, temp); // Insert the popped element back in sorted order
    }

    private static void insertInSortedOrder(Stack<Integer> stack, int element) {
        if (stack.isEmpty() || element > stack.peek()) {
            stack.push(element); // Base case: Insert at the bottom or if element is greater than top
            return;
        }

        int temp = stack.pop(); // Pop elements greater than 'element'
        insertInSortedOrder(stack, element); // Recursively find the correct position
        stack.push(temp); // Push back the temporarily popped elements
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(1);
        stack.push(8);
        stack.push(2);
        stack.push(9);
        stack.push(3);

        System.out.println("Unsorted stack: " + stack);
        sortStack(stack);
        System.out.println("Sorted stack: " + stack);

        Stack<Integer> emptyStack = new Stack<>();
        System.out.println("Unsorted empty stack: " + emptyStack);
        sortStack(emptyStack);
        System.out.println("Sorted empty stack: " + emptyStack);

        Stack<Integer> singleElementStack = new Stack<>();
        singleElementStack.push(7);
        System.out.println("Unsorted single element stack: " + singleElementStack);
        sortStack(singleElementStack);
        System.out.println("Sorted single element stack: " + singleElementStack);
    }
}