package DataStructure.Sorting.HeapSort.SortJobApplicantBySalary;

import java.util.Arrays;

public class HeapSortSalary {

    public static void heapSort(double[] salaries) {
        int n = salaries.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(salaries, n, i);
        }

        for (int i = n - 1; i >= 0; i--) {
            // Move current root to end
            double temp = salaries[0];
            salaries[0] = salaries[i];
            salaries[i] = temp;

            heapify(salaries, i, 0);
        }
    }


    static void heapify(double[] salaries, int n, int i) {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        if (l < n && salaries[l] > salaries[largest])
            largest = l;

        if (r < n && salaries[r] > salaries[largest])
            largest = r;

        if (largest != i) {
            double swap = salaries[i];
            salaries[i] = salaries[largest];
            salaries[largest] = swap;

            heapify(salaries, n, largest);
        }
    }


    public static void main(String[] args) {
        double[] salaries = {75000, 60000, 90000, 55000, 80000, 70000};
        System.out.println("Original salaries: " + Arrays.toString(salaries));

        heapSort(salaries);

        System.out.println("Sorted salaries: " + Arrays.toString(salaries));
    }
}
