package DataStructure.Sorting.MergeSort.SortAnArrayOfBookPrice;

import java.util.Arrays;

public class MergeSortBookPrice {

    public static void mergeSort(double[] prices) {
        if (prices.length <= 1) {
            return; // Base case: already sorted
        }

        int mid = prices.length / 2;
        double[] left = Arrays.copyOfRange(prices, 0, mid);
        double[] right = Arrays.copyOfRange(prices, mid, prices.length);

        mergeSort(left);
        mergeSort(right);

        merge(prices, left, right); // Merge the sorted halves
    }

    private static void merge(double[] prices, double[] left, double[] right) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                prices[k++] = left[i++];
            } else {
                prices[k++] = right[j++];
            }
        }

        while (i < left.length) {
            prices[k++] = left[i++];
        }

        while (j < right.length) {
            prices[k++] = right[j++];
        }
    }

    public static void main(String[] args) {
        double[] prices = {25.99, 12.50, 35.75, 8.99, 19.25, 42.00};
        System.out.println("Original prices: " + Arrays.toString(prices));

        mergeSort(prices);

        System.out.println("Sorted prices: " + Arrays.toString(prices));
    }
}
