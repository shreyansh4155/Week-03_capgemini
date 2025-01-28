package DataStructure.LinkedList.SinglyLinkedList.InventoryManagementSystem;

import java.util.Comparator;

public class InventoryLinkedList {
    private InventoryItem head;

    public InventoryLinkedList() {
        this.head = null;
    }

    // Add an item at the beginning
    public void addAtBeginning(InventoryItem item) {
        item.setNext(head);
        head = item;
    }

    // Add an item at the end
    public void addAtEnd(InventoryItem item) {
        if (head == null) {
            head = item;
            return;
        }
        InventoryItem current = head;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(item);
    }

    // Add an item at a specific position
    public void addAtPosition(InventoryItem item, int position) {
        if (position <= 0) {
            addAtBeginning(item);
            return;
        }
        InventoryItem current = head;
        for (int i = 1; i < position && current != null; i++) {
            current = current.getNext();
        }
        if (current == null) {
            addAtEnd(item);
        } else {
            item.setNext(current.getNext());
            current.setNext(item);
        }
    }

    // Remove an item based on Item ID
    public void removeByItemId(String itemId) {
        if (head == null) return;
        if (head.getItemId().equals(itemId)) {
            head = head.getNext();
            return;
        }
        InventoryItem current = head;
        InventoryItem prev = null;
        while (current != null && !current.getItemId().equals(itemId)) {
            prev = current;
            current = current.getNext();
        }
        if (current != null) {
            prev.setNext(current.getNext());
        }
    }

    // Update the quantity of an item by Item ID
    public void updateQuantity(String itemId, int newQuantity) {
        InventoryItem item = searchByItemId(itemId);
        if (item != null) {
            item.setQuantity(newQuantity);
            System.out.println("Quantity updated successfully for Item ID: " + itemId);
        } else {
            System.out.println("Item with ID " + itemId + " not found.");
        }
    }

    // Search for an item based on Item ID
    public InventoryItem searchByItemId(String itemId) {
        InventoryItem current = head;
        while (current != null) {
            if (current.getItemId().equals(itemId)) {
                return current;
            }
            current = current.getNext();
        }
        return null;
    }

    // Search for an item based on Item Name
    public InventoryItem searchByItemName(String itemName) {
        InventoryItem current = head;
        while (current != null) {
            if (current.getItemName().equalsIgnoreCase(itemName)) {
                return current;
            }
            current = current.getNext();
        }
        return null;
    }

    // Calculate and display the total value of inventory
    public double calculateTotalInventoryValue() {
        double totalValue = 0;
        InventoryItem current = head;
        while (current != null) {
            totalValue += current.getQuantity() * current.getPrice();
            current = current.getNext();
        }
        return totalValue;
    }

    // Sort the inventory based on Item Name or Price
    public void sort(boolean byName, boolean ascending) {
        if (head == null || head.getNext() == null) return;

        head = mergeSort(head, byName, ascending);
    }

    private InventoryItem mergeSort(InventoryItem head, boolean byName, boolean ascending) {
        if (head == null || head.getNext() == null) {
            return head;
        }

        InventoryItem middle = getMiddle(head);
        InventoryItem nextOfMiddle = middle.getNext();
        middle.setNext(null);

        InventoryItem left = mergeSort(head, byName, ascending);
        InventoryItem right = mergeSort(nextOfMiddle, byName, ascending);

        return merge(left, right, byName, ascending);
    }

    private InventoryItem merge(InventoryItem a, InventoryItem b, boolean byName, boolean ascending) {
        InventoryItem result = null;
        Comparator<InventoryItem> comparator = byName ?
                Comparator.comparing(InventoryItem::getItemName) :
                Comparator.comparing(InventoryItem::getPrice);

        if (!ascending) {
            comparator = comparator.reversed();
        }

        if (comparator.compare(a, b) <= 0) {
            result = a;
            result.setNext(merge(a.getNext(), b, byName, ascending));
        } else {
            result = b;
            result.setNext(merge(a, b.getNext(), byName, ascending));
        }
        return result;
    }

    private InventoryItem getMiddle(InventoryItem head) {
        if (head == null) return head;
        InventoryItem slow = head, fast = head;
        while (fast.getNext() != null && fast.getNext().getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        return slow;
    }

    // Display all items
    public void displayAllItems() {
        InventoryItem current = head;
        while (current != null) {
            System.out.println(current);
            current = current.getNext();
        }
    }
}





