package DataStructure.Sorting.Countingsort.SortStudentAges;

import java.util.Arrays;

public class CountingSortAges {

    public static void countingSort(int[] ages) {
        int n = ages.length;

                int[] count = new int[9];


        for (int age : ages) {
            count[age - 10]++; // Adjust index to 0-based
        }


        for (int i = 1; i < 9; i++) {
            count[i] += count[i - 1];
        }


        int[] sortedAges = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            int age = ages[i];
            int position = count[age - 10] - 1;
            sortedAges[position] = age;
            count[age - 10]--;
        }

        System.arraycopy(sortedAges, 0, ages, 0, n);


        System.out.println("Sorted Ages:"+Arrays.toString(ages));
    }

    public static void main(String[] args) {
        int[] ages = {15, 12, 18, 10, 14, 12, 16, 15, 13};
        System.out.println("Original Ages:"+Arrays.toString(ages));
        countingSort(ages);

    }
}
