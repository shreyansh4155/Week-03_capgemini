package DataStructure.Sorting.SelectionSort.SortExamScore;

public class ExamScore {
    public static void main(String[] args) {
        int[] marks = {50, 70, 45, 90, 47, 96, 78, 87, 75};
        int n = marks.length;
        selectionSort(marks, n);
            for (int x : marks) {
                System.out.print(x + " ");
            }

    }


    public static void selectionSort(int [] marks, int n){
        for(int i=0; i<n-1; i++){
            int minIndex = i;
            for(int j=i+1; j<n; j++){
                if(marks[j] < marks[minIndex]){
                    minIndex = j;
                }
            }
            int temp = marks[i];
            marks[i] = marks[minIndex];
            marks[minIndex] = temp;
        }
    }

}