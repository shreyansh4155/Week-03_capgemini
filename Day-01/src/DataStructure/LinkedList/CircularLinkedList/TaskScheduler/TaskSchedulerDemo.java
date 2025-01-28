package DataStructure.LinkedList.CircularLinkedList.TaskScheduler;

public class TaskSchedulerDemo {
    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();

        // Adding tasks
        scheduler.addTaskAtEnd(1, "Task 1", 5, "2025-02-10");
        scheduler.addTaskAtEnd(2, "Task 2", 3, "2025-02-12");
        scheduler.addTaskAtBeginning(3, "Task 3", 2, "2025-02-14");
        scheduler.addTaskAtPosition(2, 4, "Task 4", 1, "2025-02-15");

        // Display all tasks
        System.out.println("All Tasks:");
        scheduler.displayAllTasks();

        // View current task and move to the next one
        System.out.println("\nViewing Current Task and Moving to Next:");
        scheduler.viewCurrentTask();  // Should show Task 3
        scheduler.viewCurrentTask();  // Should show Task 1
        scheduler.viewCurrentTask();  // Should show Task 2

        // Search for tasks with priority 1
        System.out.println("\nSearching for tasks with priority 1:");
        scheduler.searchByPriority(1);

        // Remove a task by Task ID
        System.out.println("\nRemoving Task with ID 2:");
        scheduler.removeTaskById(2);
        scheduler.displayAllTasks();  // Should not display Task 2

        // Display all tasks after removal
        System.out.println("\nAll Tasks After Removal:");
        scheduler.displayAllTasks();

        // Add more tasks and check task count
        scheduler.addTaskAtEnd(5, "Task 5", 4, "2025-02-16");
        System.out.println("Total Tasks: " + scheduler.getSize());
    }
}
