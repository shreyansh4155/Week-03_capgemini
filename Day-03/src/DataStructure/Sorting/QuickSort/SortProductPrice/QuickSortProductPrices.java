package DataStructure.Sorting.QuickSort.SortProductPrice;

import java.util.Arrays;

public class QuickSortProductPrices {

    public static void quickSort(double[] prices, int low, int high) {
        if (low < high) {
            int pi = partition(prices, low, high);

            quickSort(prices, low, pi - 1);
            quickSort(prices, pi + 1, high);
        }
    }

    private static int partition(double[] prices, int low, int high) {
        double pivot = prices[high];  // You can choose other pivot strategies (first, random)
        int i = (low - 1); // Index of smaller element and indicates

        for (int j = low; j <= high - 1; j++) {
            // If current element is smaller than or equal to pivot
            if (prices[j] <= pivot) {
                i++;

                // swap prices[i] and prices[j]
                double temp = prices[i];
                prices[i] = prices[j];
                prices[j] = temp;
            }
        }
        double temp = prices[i + 1];
        prices[i + 1] = prices[high];
        prices[high] = temp;
        return (i + 1);
    }

    public static void main(String[] args) {
        double[] prices = {25.99, 12.50, 35.75, 8.99, 19.25, 42.00, 5.99, 15.50};
        System.out.println("Original prices: " + Arrays.toString(prices));

        quickSort(prices, 0, prices.length - 1); // Sort the entire array

        System.out.println("Sorted prices: " + Arrays.toString(prices));
    }
}
