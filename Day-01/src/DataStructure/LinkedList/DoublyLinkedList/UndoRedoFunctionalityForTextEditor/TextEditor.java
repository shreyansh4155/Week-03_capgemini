package DataStructure.LinkedList.DoublyLinkedList.UndoRedoFunctionalityForTextEditor;

class TextEditor {
    private TextState currentState;
    private TextState head;
    private TextState tail;
    private int historySize;
    private int maxHistorySize;

    // Constructor to initialize the text editor with a maximum history size
    public TextEditor(int maxHistorySize) {
        this.currentState = null;
        this.head = null;
        this.tail = null;
        this.historySize = 0;
        this.maxHistorySize = maxHistorySize;
    }

    // Add a new state to the text history
    public void addTextState(String newText) {
        TextState newState = new TextState(newText);

        // If there is a current state, link it properly
        if (currentState != null) {
            currentState.next = newState;
            newState.prev = currentState;
        }

        // Set the new state as the current state
        currentState = newState;

        // Update head if this is the first state
        if (head == null) {
            head = currentState;
        }

        // If history size exceeds the max limit, remove the oldest state (tail)
        if (historySize == maxHistorySize) {
            removeOldestState();
        } else {
            historySize++;
        }
    }

    // Remove the oldest state (tail)
    private void removeOldestState() {
        if (tail != null) {
            tail = tail.next; // Move tail pointer to the next node
            if (tail != null) {
                tail.prev = null; // Remove reference to the previous tail
            }
            historySize--;
        }
    }

    // Undo: Move to the previous state
    public void undo() {
        if (currentState != null && currentState.prev != null) {
            currentState = currentState.prev;
            System.out.println("Undo: " + currentState.text);
        } else {
            System.out.println("No more states to undo.");
        }
    }

    // Redo: Move to the next state
    public void redo() {
        if (currentState != null && currentState.next != null) {
            currentState = currentState.next;
            System.out.println("Redo: " + currentState.text);
        } else {
            System.out.println("No more states to redo.");
        }
    }

    // Display the current text state
    public void displayCurrentState() {
        if (currentState != null) {
            System.out.println("Current State: " + currentState.text);
        } else {
            System.out.println("No text state available.");
        }
    }

    // Get the history size (number of states stored)
    public int getHistorySize() {
        return historySize;
    }
}
