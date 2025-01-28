package DataStructure.LinkedList.SinglyLinkedList.InventoryManagementSystem;

public class InventoryItem {
    private String itemName;
    private String itemId;
    private int quantity;
    private double price;
    private InventoryItem next;

    public InventoryItem(String itemName, String itemId, int quantity, double price) {
        this.itemName = itemName;
        this.itemId = itemId;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }

    // Getters and setters
    public String getItemName() {
        return itemName;
    }

    public String getItemId() {
        return itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public InventoryItem getNext() {
        return next;
    }

    public void setNext(InventoryItem next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Item: " + itemName + ", ID: " + itemId + ", Quantity: " + quantity + ", Price: $" + price;
    }
}
