package DataStructure.LinkedList.CircularLinkedList.OnlineTicketReservation;

class CircularLinkedList {
    private Ticket head = null;

    // Add a new ticket at the end of the circular linked list
    public void addTicket(int ticketID, String customerName, String movieName, String seatNumber, String bookingTime) {
        Ticket newTicket = new Ticket(ticketID, customerName, movieName, seatNumber, bookingTime);
        if (head == null) {
            head = newTicket;
            head.next = head; // Circular link
        } else {
            Ticket temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newTicket;
            newTicket.next = head;
        }
    }

    // Remove a ticket by Ticket ID
    public void removeTicket(int ticketID) {
        if (head == null) {
            System.out.println("No tickets to remove.");
            return;
        }

        Ticket temp = head, prev = null;

        // Check if the head itself is to be removed
        if (temp.ticketID == ticketID) {
            if (temp.next == head) { // Single node case
                head = null;
                return;
            }

            // Find the last node to update its next pointer
            Ticket last = head;
            while (last.next != head) {
                last = last.next;
            }
            head = head.next;
            last.next = head;
            return;
        }

        // Traverse to find the ticket
        do {
            prev = temp;
            temp = temp.next;
        } while (temp != head && temp.ticketID != ticketID);

        if (temp.ticketID == ticketID) {
            prev.next = temp.next;
        } else {
            System.out.println("Ticket with ID " + ticketID + " not found.");
        }
    }

    // Display all tickets in the list
    public void displayTickets() {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }

        Ticket temp = head;
        System.out.println("Current Tickets:");
        do {
            System.out.println("Ticket ID: " + temp.ticketID + ", Customer Name: " + temp.customerName +
                    ", Movie Name: " + temp.movieName + ", Seat Number: " + temp.seatNumber +
                    ", Booking Time: " + temp.bookingTime);
            temp = temp.next;
        } while (temp != head);
    }

    // Search for tickets by Customer Name or Movie Name
    public void searchTickets(String searchTerm) {
        if (head == null) {
            System.out.println("No tickets to search.");
            return;
        }

        Ticket temp = head;
        boolean found = false;
        System.out.println("Search Results for \"" + searchTerm + "\":");
        do {
            if (temp.customerName.equalsIgnoreCase(searchTerm) || temp.movieName.equalsIgnoreCase(searchTerm)) {
                System.out.println("Ticket ID: " + temp.ticketID + ", Customer Name: " + temp.customerName +
                        ", Movie Name: " + temp.movieName + ", Seat Number: " + temp.seatNumber +
                        ", Booking Time: " + temp.bookingTime);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("No tickets found for \"" + searchTerm + "\".");
        }
    }

    // Calculate the total number of booked tickets
    public int totalTickets() {
        if (head == null) {
            return 0;
        }

        Ticket temp = head;
        int count = 0;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);

        return count;
    }
}
