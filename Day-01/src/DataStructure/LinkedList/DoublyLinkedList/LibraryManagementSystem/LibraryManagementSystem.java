package DataStructure.LinkedList.DoublyLinkedList.LibraryManagementSystem;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();

        // Adding books
        library.addBookAtEnd("The Great Gatsby", "F. Scott Fitzgerald", "Fiction", 1, "Available");
        library.addBookAtEnd("1984", "George Orwell", "Dystopian", 2, "Checked Out");
        library.addBookAtBeginning("To Kill a Mockingbird", "Harper Lee", "Fiction", 3, "Available");
        library.addBookAtPosition(2, "Moby-Dick", "Herman Melville", "Adventure", 4, "Available");

        // Display books forward
        System.out.println("Books in library (forward):");
        library.displayBooksForward();

        // Search for a book
        library.searchByTitleOrAuthor("1984");

        // Update availability status
        library.updateAvailabilityStatus(2, "Available");

        // Remove a book by ID
        library.removeBookById(4);

        // Display books in reverse order
        System.out.println("\nBooks in library (reverse):");
        library.displayBooksReverse();

        // Count total books
        System.out.println("Total books in library: " + library.countBooks());
    }
}