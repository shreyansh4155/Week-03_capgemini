package DataStructure.LinkedList.CircularLinkedList.RoundRobinSchedulingAlgorithm;

class CircularLinkedList {
    private Process head = null;

    // Add a new process to the end of the circular linked list
    public void addProcess(int processID, int burstTime, int priority) {
        Process newProcess = new Process(processID, burstTime, priority);
        if (head == null) {
            head = newProcess;
            head.next = head; // Circular link
        } else {
            Process temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newProcess;
            newProcess.next = head;
        }
    }

    // Remove a process by Process ID
    public void removeProcess(int processID) {
        if (head == null) return;

        Process temp = head, prev = null;

        // Check if the head itself is to be removed
        if (temp.processID == processID) {
            if (temp.next == head) { // Single node case
                head = null;
                return;
            }

            // Find the last node to update its next pointer
            Process last = head;
            while (last.next != head) {
                last = last.next;
            }
            head = head.next;
            last.next = head;
            return;
        }

        // Traverse to find the process
        do {
            prev = temp;
            temp = temp.next;
        } while (temp != head && temp.processID != processID);

        if (temp.processID == processID) {
            prev.next = temp.next;
        }
    }

    // Display the processes in the circular queue
    public void displayProcesses() {
        if (head == null) {
            System.out.println("No processes in the queue.");
            return;
        }

        Process temp = head;
        System.out.println("Processes in the queue:");
        do {
            System.out.println("ProcessID: " + temp.processID + ", BurstTime: " + temp.burstTime + ", Priority: " + temp.priority);
            temp = temp.next;
        } while (temp != head);
    }

    // Simulate the round-robin scheduling
    public void roundRobin(int timeQuantum) {
        if (head == null) {
            System.out.println("No processes to schedule.");
            return;
        }

        int totalTime = 0;
        int processCount = 0;
        int totalWaitingTime = 0;
        int totalTurnAroundTime = 0;

        Process current = head;

        while (head != null) {
            if (current.burstTime > timeQuantum) {
                totalTime += timeQuantum;
                current.burstTime -= timeQuantum;
                System.out.println("Process " + current.processID + " executed for " + timeQuantum + " units.");
                current = current.next;
            } else {
                totalTime += current.burstTime;
                System.out.println("Process " + current.processID + " completed execution.");
                totalTurnAroundTime += totalTime;
                totalWaitingTime += (totalTime - current.burstTime);
                Process temp = current;
                current = current.next;
                removeProcess(temp.processID);
            }
            displayProcesses();
        }

        System.out.println("Average Waiting Time: " + (double) totalWaitingTime / processCount);
        System.out.println("Average Turn-Around Time: " + (double) totalTurnAroundTime / processCount);
    }
}

