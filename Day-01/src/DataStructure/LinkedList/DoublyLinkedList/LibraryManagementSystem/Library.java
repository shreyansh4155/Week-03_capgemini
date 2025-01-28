package DataStructure.LinkedList.DoublyLinkedList.LibraryManagementSystem;

class Library {
    private Book head;
    private Book tail;
    private int size;

    public Library() {
        head = null;
        tail = null;
        size = 0;
    }

    // Add a book at the end of the library
    public void addBookAtEnd(String title, String author, String genre, int bookId, String availabilityStatus) {
        Book newBook = new Book(title, author, genre, bookId, availabilityStatus);
        if (head == null) { // If the list is empty
            head = tail = newBook;
        } else {
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
        }
        size++;
    }

    // Add a book at the beginning of the library
    public void addBookAtBeginning(String title, String author, String genre, int bookId, String availabilityStatus) {
        Book newBook = new Book(title, author, genre, bookId, availabilityStatus);
        if (head == null) { // If the list is empty
            head = tail = newBook;
        } else {
            newBook.next = head;
            head.prev = newBook;
            head = newBook;
        }
        size++;
    }

    // Add a book at a specific position
    public void addBookAtPosition(int position, String title, String author, String genre, int bookId, String availabilityStatus) {
        if (position < 1 || position > size + 1) {
            System.out.println("Invalid position");
            return;
        }

        if (position == 1) {
            addBookAtBeginning(title, author, genre, bookId, availabilityStatus);
            return;
        }

        if (position == size + 1) {
            addBookAtEnd(title, author, genre, bookId, availabilityStatus);
            return;
        }

        Book newBook = new Book(title, author, genre, bookId, availabilityStatus);
        Book current = head;
        for (int i = 1; i < position - 1; i++) {
            current = current.next;
        }
        newBook.next = current.next;
        newBook.prev = current;
        if (current.next != null) {
            current.next.prev = newBook;
        }
        current.next = newBook;
        size++;
    }

    // Remove a book by its ID
    public void removeBookById(int bookId) {
        Book current = head;
        while (current != null) {
            if (current.bookId == bookId) {
                if (current.prev != null) {
                    current.prev.next = current.next;
                }
                if (current.next != null) {
                    current.next.prev = current.prev;
                }
                if (current == head) {
                    head = current.next;
                }
                if (current == tail) {
                    tail = current.prev;
                }
                size--;
                return;
            }
            current = current.next;
        }
        System.out.println("Book not found");
    }

    // Search for a book by title or author
    public void searchByTitleOrAuthor(String searchTerm) {
        Book current = head;
        while (current != null) {
            if (current.title.equalsIgnoreCase(searchTerm) || current.author.equalsIgnoreCase(searchTerm)) {
                System.out.println("Book Found: Title: " + current.title + ", Author: " + current.author + ", Genre: " + current.genre + ", ID: " + current.bookId + ", Availability: " + current.availabilityStatus);
                return;
            }
            current = current.next;
        }
        System.out.println("Book not found");
    }

    // Update the availability status of a book by its ID
    public void updateAvailabilityStatus(int bookId, String newStatus) {
        Book current = head;
        while (current != null) {
            if (current.bookId == bookId) {
                current.availabilityStatus = newStatus;
                System.out.println("Updated Availability Status for Book ID " + bookId + " to " + newStatus);
                return;
            }
            current = current.next;
        }
        System.out.println("Book not found");
    }

    // Display all books in the library from the beginning
    public void displayBooksForward() {
        Book current = head;
        while (current != null) {
            System.out.println("Title: " + current.title + ", Author: " + current.author + ", Genre: " + current.genre + ", ID: " + current.bookId + ", Availability: " + current.availabilityStatus);
            current = current.next;
        }
    }

    // Display all books in the library from the end (reverse order)
    public void displayBooksReverse() {
        Book current = tail;
        while (current != null) {
            System.out.println("Title: " + current.title + ", Author: " + current.author + ", Genre: " + current.genre + ", ID: " + current.bookId + ", Availability: " + current.availabilityStatus);
            current = current.prev;
        }
    }

    // Count the total number of books in the library
    public int countBooks() {
        return size;
    }
}


