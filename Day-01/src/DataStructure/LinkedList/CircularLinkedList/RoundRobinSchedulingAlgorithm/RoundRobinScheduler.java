package DataStructure.LinkedList.CircularLinkedList.RoundRobinSchedulingAlgorithm;

public class RoundRobinScheduler {
    public static void main(String[] args) {
        CircularLinkedList processQueue = new CircularLinkedList();

        // Add processes
        processQueue.addProcess(1, 10, 1);
        processQueue.addProcess(2, 5, 2);
        processQueue.addProcess(3, 8, 1);

        System.out.println("Initial Queue:");
        processQueue.displayProcesses();

        int timeQuantum = 3;
        System.out.println("\nSimulating Round-Robin Scheduling with Time Quantum = " + timeQuantum);
        processQueue.roundRobin(timeQuantum);
    }
}
