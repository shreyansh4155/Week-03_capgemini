package DataStructure.LinkedList.DoublyLinkedList.UndoRedoFunctionalityForTextEditor;

public class TextEditorWithUndoRedo {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor(10); // Max history size is 10

        // Adding some text states
        editor.addTextState("Hello");
        editor.addTextState("Hello, World!");
        editor.addTextState("Hello, World! How are you?");
        editor.addTextState("Hello, World! How are you? I'm good.");

        // Display current state
        editor.displayCurrentState();

        // Undo actions
        editor.undo(); // Should go to previous state
        editor.undo(); // Should go to the next previous state

        // Redo actions
        editor.redo(); // Should go back to the next state
        editor.redo(); // Should go to the next next state

        // Add more states and see history size limit
        editor.addTextState("New state after redo.");
        editor.addTextState("Another new state.");
        editor.addTextState("Last state.");
        System.out.println("History size: " + editor.getHistorySize());
    }
}
