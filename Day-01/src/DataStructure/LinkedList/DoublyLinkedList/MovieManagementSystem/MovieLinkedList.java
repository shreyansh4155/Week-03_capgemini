package DataStructure.LinkedList.DoublyLinkedList.MovieManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class MovieLinkedList {
    private Movie head;
    private Movie tail;

    public MovieLinkedList() {
        this.head = null;
        this.tail = null;
    }

    // Add a movie at the beginning
    public void addAtBeginning(Movie movie) {
        if (head == null) {
            head = tail = movie;
        } else {
            movie.setNext(head);
            head.setPrev(movie);
            head = movie;
        }
    }

    // Add a movie at the end
    public void addAtEnd(Movie movie) {
        if (tail == null) {
            head = tail = movie;
        } else {
            movie.setPrev(tail);
            tail.setNext(movie);
            tail = movie;
        }
    }

    // Add a movie at a specific position
    public void addAtPosition(Movie movie, int position) {
        if (position <= 0) {
            addAtBeginning(movie);
            return;
        }
        Movie current = head;
        for (int i = 1; i < position && current != null; i++) {
            current = current.getNext();
        }
        if (current == null) {
            addAtEnd(movie);
        } else {
            movie.setNext(current);
            movie.setPrev(current.getPrev());
            current.getPrev().setNext(movie);
            current.setPrev(movie);
        }
    }

    // Remove a movie by title
    public void removeByTitle(String title) {
        Movie current = head;
        while (current != null) {
            if (current.getTitle().equalsIgnoreCase(title)) {
                if (current.getPrev() == null) {
                    head = current.getNext();
                    if (head != null) {
                        head.setPrev(null);
                    }
                } else if (current.getNext() == null) {
                    tail = current.getPrev();
                    tail.setNext(null);
                } else {
                    current.getPrev().setNext(current.getNext());
                    current.getNext().setPrev(current.getPrev());
                }
                System.out.println("Movie '" + title + "' removed successfully.");
                return;
            }
            current = current.getNext();
        }
        System.out.println("Movie '" + title + "' not found.");
    }

    // Search for movies by director
    public List<Movie> searchByDirector(String director) {
        List<Movie> result = new ArrayList<>();
        Movie current = head;
        while (current != null) {
            if (current.getDirector().equalsIgnoreCase(director)) {
                result.add(current);
            }
            current = current.getNext();
        }
        return result;
    }

    // Search for movies by rating
    public List<Movie> searchByRating(double rating) {
        List<Movie> result = new ArrayList<>();
        Movie current = head;
        while (current != null) {
            if (current.getRating() == rating) {
                result.add(current);
            }
            current = current.getNext();
        }
        return result;
    }

    // Display all movies in forward order
    public void displayForward() {
        Movie current = head;
        while (current != null) {
            System.out.println(current);
            current = current.getNext();
        }
    }

    // Display all movies in reverse order
    public void displayReverse() {
        Movie current = tail;
        while (current != null) {
            System.out.println(current);
            current = current.getPrev();
        }
    }

    // Update a movie's rating based on the title
    public void updateRating(String title, double newRating) {
        Movie current = head;
        while (current != null) {
            if (current.getTitle().equalsIgnoreCase(title)) {
                current.setRating(newRating);
                System.out.println("Rating updated for movie '" + title + "'");
                return;
            }
            current = current.getNext();
        }
        System.out.println("Movie '" + title + "' not found.");
    }
}
