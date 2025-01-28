package DataStructure.LinkedList.SinglyLinkedList.StudentRecordManagement;

public class StudentLinkedList {
    private Student head;

    public StudentLinkedList() {
        this.head = null;
    }

    // Add a new student at the beginning
    public void addAtBeginning(Student student) {
        student.setNext(head);
        head = student;
    }

    // Add a new student at the end
    public void addAtEnd(Student student) {
        if (head == null) {
            head = student;
            return;
        }
        Student current = head;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(student);
    }

    // Add a new student at a specific position
    public void addAtPosition(Student student, int position) {
        if (position <= 0) {
            addAtBeginning(student);
            return;
        }
        Student current = head;
        for (int i = 1; i < position && current != null; i++) {
            current = current.getNext();
        }
        if (current == null) {
            addAtEnd(student);
        } else {
            student.setNext(current.getNext());
            current.setNext(student);
        }
    }

    // Delete a student record by Roll Number
    public void deleteByRollNumber(int rollNumber) {
        if (head == null) return;
        if (head.getRollNumber() == rollNumber) {
            head = head.getNext();
            return;
        }
        Student current = head;
        Student prev = null;
        while (current != null && current.getRollNumber() != rollNumber) {
            prev = current;
            current = current.getNext();
        }
        if (current != null) {
            prev.setNext(current.getNext());
        }
    }

    // Search for a student record by Roll Number
    public Student searchByRollNumber(int rollNumber) {
        Student current = head;
        while (current != null) {
            if (current.getRollNumber() == rollNumber) {
                return current;
            }
            current = current.getNext();
        }
        return null;
    }

    // Display all student records
    public void displayAllRecords() {
        Student current = head;
        while (current != null) {
            System.out.println(current);
            current = current.getNext();
        }
    }

    // Update a student's grade based on their Roll Number
    public void updateGrade(int rollNumber, char newGrade) {
        Student student = searchByRollNumber(rollNumber);
        if (student != null) {
            student.setGrade(newGrade);
            System.out.println("Grade updated successfully for Roll Number: " + rollNumber);
        } else {
            System.out.println("Student with Roll Number " + rollNumber + " not found.");
        }
    }
}
