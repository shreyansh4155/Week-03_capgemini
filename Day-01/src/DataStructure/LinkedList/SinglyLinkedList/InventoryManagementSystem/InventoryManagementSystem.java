package DataStructure.LinkedList.SinglyLinkedList.InventoryManagementSystem;

public class InventoryManagementSystem {
    public static void main(String[] args) {
        InventoryLinkedList inventory = new InventoryLinkedList();

        // Add items
        inventory.addAtEnd(new InventoryItem("Laptop", "L001", 10, 999.99));
        inventory.addAtEnd(new InventoryItem("Mouse", "M001", 50, 19.99));
        inventory.addAtBeginning(new InventoryItem("Keyboard", "K001", 30, 49.99));
        inventory.addAtPosition(new InventoryItem("Monitor", "MON001", 15, 199.99), 2);

        System.out.println("All items:");
        inventory.displayAllItems();

        // Search for an item
        InventoryItem foundItem = inventory.searchByItemId("M001");
        System.out.println("\nFound item: " + (foundItem != null ? foundItem : "Not found"));

        // Update quantity
        inventory.updateQuantity("K001", 40);

        // Remove an item
        inventory.removeByItemId("MON001");

        // Calculate total inventory value
        System.out.println("\nTotal inventory value: $" + inventory.calculateTotalInventoryValue());

        // Sort by name (ascending)
        inventory.sort(true, true);
        System.out.println("\nSorted by name (ascending):");
        inventory.displayAllItems();

        // Sort by price (descending)
        inventory.sort(false, false);
        System.out.println("\nSorted by price (descending):");
        inventory.displayAllItems();
    }
}
