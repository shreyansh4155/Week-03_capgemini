package DataStructure.LinkedList.SinglyLinkedList.StudentRecordManagement;

public class StudentManagementSystem {
    public static void main(String[] args) {
        StudentLinkedList studentList = new StudentLinkedList();

        // Add students
        studentList.addAtEnd(new Student(1, "Alice", 20, 'A'));
        studentList.addAtEnd(new Student(2, "Bob", 21, 'B'));
        studentList.addAtBeginning(new Student(3, "Charlie", 19, 'C'));
        studentList.addAtPosition(new Student(4, "David", 22, 'B'), 2);

        System.out.println("All students:");
        studentList.displayAllRecords();

        // Search for a student
        Student foundStudent = studentList.searchByRollNumber(2);
        System.out.println("Found student: " + (foundStudent != null ? foundStudent : "Not found"));

        // Update a student's grade
        studentList.updateGrade(3, 'A');

        // Delete a student
        studentList.deleteByRollNumber(1);

        System.out.println("After updates:");
        studentList.displayAllRecords();
    }
}
