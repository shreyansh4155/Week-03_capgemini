package DataStructure.LinkedList.DoublyLinkedList.MovieManagementSystem;

public class Movie {
    private String title;
    private String director;
    private int year;
    private double rating;
    private Movie prev;
    private Movie next;

    public Movie(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.prev = null;
        this.next = null;
    }

    // Getters and setters
    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director;
    }

    public int getYear() {
        return year;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public Movie getPrev() {
        return prev;
    }

    public void setPrev(Movie prev) {
        this.prev = prev;
    }

    public Movie getNext() {
        return next;
    }

    public void setNext(Movie next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Movie: " + title + ", Director: " + director + ", Year: " + year + ", Rating: " + rating;
    }
}

