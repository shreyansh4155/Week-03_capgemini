package DataStructure.LinkedList.DoublyLinkedList.UndoRedoFunctionalityForTextEditor;

class TextState {
    String text;
    TextState next;
    TextState prev;

    public TextState(String text) {
        this.text = text;
        this.next = null;
        this.prev = null;
    }
}
