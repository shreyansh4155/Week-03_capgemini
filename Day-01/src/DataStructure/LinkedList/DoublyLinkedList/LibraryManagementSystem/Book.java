package DataStructure.LinkedList.DoublyLinkedList.LibraryManagementSystem;

class Book {
    String title;
    String author;
    String genre;
    int bookId;
    String availabilityStatus;
    Book next;
    Book prev;

    // Constructor
    public Book(String title, String author, String genre, int bookId, String availabilityStatus) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookId = bookId;
        this.availabilityStatus = availabilityStatus;
        this.next = null;
        this.prev = null;
    }
}

