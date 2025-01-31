package DataStructure.Sorting.InsertionSort.SortEmployeeID;

public class SortingEmpId {
    public static void main(String[] args) {
        int empId [] = {14,10,19,15,20,13,18};
        int n = empId.length;
        insertionSort(empId,n);
        for(int x : empId) {
            System.out.print(x + " ");
        }
    }

    private static void insertionSort(int[] empId,int n) {
        for(int i = 1; i < n; i++) {
            int key = empId[i];
            int j = i-1;

            while(j >= 0 && empId[j] > key) {
                empId[j+1] = empId[j];
                j = j-1;
            }
            empId[j+1] = key;
        }
    }

}
