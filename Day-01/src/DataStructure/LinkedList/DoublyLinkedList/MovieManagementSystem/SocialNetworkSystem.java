package DataStructure.LinkedList.DoublyLinkedList.MovieManagementSystem;

import DataStructure.LinkedList.DoublyLinkedList.MovieManagementSystem.Movie;
import DataStructure.LinkedList.DoublyLinkedList.MovieManagementSystem.MovieLinkedList;

import java.util.List;

public class SocialNetworkSystem {
    public static void main(String[] args) {
        // Existing social network code...

        // Movie Management System
        MovieLinkedList movieList = new MovieLinkedList();

        // Add movies
        movieList.addAtEnd(new Movie("Inception", "Christopher Nolan", 2010, 8.8));
        movieList.addAtEnd(new Movie("The Godfather", "Francis Ford Coppola", 1972, 9.2));
        movieList.addAtBeginning(new Movie("Pulp Fiction", "Quentin Tarantino", 1994, 8.9));
        movieList.addAtPosition(new Movie("The Dark Knight", "Christopher Nolan", 2008, 9.0), 2);

        System.out.println("\nAll movies (forward order):");
        movieList.displayForward();

        System.out.println("\nAll movies (reverse order):");
        movieList.displayReverse();

        // Remove a movie
        movieList.removeByTitle("Pulp Fiction");

        // Search by director
        List<Movie> nolanMovies = movieList.searchByDirector("Christopher Nolan");
        System.out.println("\nChristopher Nolan movies:");
        for (Movie movie : nolanMovies) {
            System.out.println(movie);
        }

        // Update rating
        movieList.updateRating("Inception", 9.0);

        System.out.println("\nUpdated movie list:");
        movieList.displayForward();
    }
}

