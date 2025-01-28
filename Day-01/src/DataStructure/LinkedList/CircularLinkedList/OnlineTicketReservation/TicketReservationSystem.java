package DataStructure.LinkedList.CircularLinkedList.OnlineTicketReservation;

public class TicketReservationSystem {
    public static void main(String[] args) {
        CircularLinkedList ticketList = new CircularLinkedList();

        // Add tickets
        ticketList.addTicket(1, "Alice", "Avatar 2", "A1", "10:00 AM");
        ticketList.addTicket(2, "Bob", "Inception", "B2", "1:00 PM");
        ticketList.addTicket(3, "Charlie", "Avatar 2", "A3", "3:00 PM");

        // Display tickets
        ticketList.displayTickets();

        // Search for tickets
        System.out.println("\nSearching for tickets booked by 'Alice':");
        ticketList.searchTickets("Alice");

        System.out.println("\nSearching for tickets for the movie 'Avatar 2':");
        ticketList.searchTickets("Avatar 2");

        // Remove a ticket
        System.out.println("\nRemoving ticket with ID 2:");
        ticketList.removeTicket(2);

        // Display tickets after removal
        ticketList.displayTickets();

        // Display total number of tickets
        System.out.println("\nTotal Tickets: " + ticketList.totalTickets());
    }
}
