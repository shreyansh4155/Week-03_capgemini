package DataStructure.LinkedList.CircularLinkedList.TaskScheduler;

class TaskScheduler {
    private Task head;
    private Task tail;
    private int size;

    // Constructor to initialize the task scheduler
    public TaskScheduler() {
        head = null;
        tail = null;
        size = 0;
    }

    // Add a task at the beginning of the circular linked list
    public void addTaskAtBeginning(int taskId, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = tail = newTask;
            head.next = head;  // Circular reference
        } else {
            newTask.next = head;
            head = newTask;
            tail.next = head; // Update tail's next to the new head
        }
        size++;
    }

    // Add a task at the end of the circular linked list
    public void addTaskAtEnd(int taskId, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = tail = newTask;
            head.next = head;  // Circular reference
        } else {
            tail.next = newTask;
            tail = newTask;
            tail.next = head;  // Ensure circular link
        }
        size++;
    }

    // Add a task at a specific position in the circular linked list
    public void addTaskAtPosition(int position, int taskId, String taskName, int priority, String dueDate) {
        if (position < 1 || position > size + 1) {
            System.out.println("Invalid position.");
            return;
        }
        if (position == 1) {
            addTaskAtBeginning(taskId, taskName, priority, dueDate);
            return;
        }
        if (position == size + 1) {
            addTaskAtEnd(taskId, taskName, priority, dueDate);
            return;
        }

        Task newTask = new Task(taskId, taskName, priority, dueDate);
        Task current = head;
        for (int i = 1; i < position - 1; i++) {
            current = current.next;
        }
        newTask.next = current.next;
        current.next = newTask;
        size++;
    }

    // Remove a task by Task ID
    public void removeTaskById(int taskId) {
        if (head == null) {
            System.out.println("Task list is empty.");
            return;
        }

        Task current = head;
        Task previous = null;

        // Check if the task to be removed is the head node
        if (head.taskId == taskId) {
            if (head == tail) {
                head = tail = null; // If there's only one task
            } else {
                head = head.next;
                tail.next = head; // Maintain circular link
            }
            size--;
            return;
        }

        // Traverse to find the task
        do {
            previous = current;
            current = current.next;
            if (current.taskId == taskId) {
                previous.next = current.next;
                if (current == tail) {
                    tail = previous; // Update the tail if necessary
                }
                size--;
                return;
            }
        } while (current != head);

        System.out.println("Task not found.");
    }

    // View the current task and move to the next task
    public void viewCurrentTask() {
        if (head != null) {
            System.out.println("Current Task: " + head.taskName + " (ID: " + head.taskId + ")");
            head = head.next;  // Move to the next task in the circular list
        } else {
            System.out.println("No tasks available.");
        }
    }

    // Display all tasks in the list starting from the head node
    public void displayAllTasks() {
        if (head == null) {
            System.out.println("Task list is empty.");
            return;
        }
        Task current = head;
        do {
            System.out.println("Task ID: " + current.taskId + ", Task Name: " + current.taskName + ", Priority: " + current.priority + ", Due Date: " + current.dueDate);
            current = current.next;
        } while (current != head); // Loop until we come back to the head
    }

    // Search for a task by Priority
    public void searchByPriority(int priority) {
        if (head == null) {
            System.out.println("Task list is empty.");
            return;
        }
        Task current = head;
        boolean found = false;
        do {
            if (current.priority == priority) {
                System.out.println("Found Task: ID: " + current.taskId + ", Name: " + current.taskName + ", Due Date: " + current.dueDate);
                found = true;
            }
            current = current.next;
        } while (current != head);

        if (!found) {
            System.out.println("No tasks found with priority: " + priority);
        }
    }

    // Get the total number of tasks
    public int getSize() {
        return size;
    }
}

