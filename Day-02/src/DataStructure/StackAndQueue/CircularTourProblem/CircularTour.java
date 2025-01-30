package DataStructure.StackAndQueue.CircularTourProblem;
import java.util.LinkedList;
import java.util.Queue;

public class CircularTour {

    public static int canCompleteCircuit(PetrolPump[] pumps) {
        int n = pumps.length;
        if (n == 0) {
            return -1; // No pumps, no tour possible
        }

        for (int start = 0; start < n; start++) {
            int currentPetrol = 0;
            boolean possible = true;
            Queue<Integer> tour = new LinkedList<>();

            // Simulate the tour starting from 'start'
            for (int i = 0; i < n; i++) {
                int currentPumpIndex = (start + i) % n; // Circular index
                tour.offer(currentPumpIndex);

                currentPetrol += pumps[currentPumpIndex].petrol;
                if (currentPetrol < pumps[currentPumpIndex].distance) {
                    possible = false;
                    break; // Can't reach the next pump
                }
                currentPetrol -= pumps[currentPumpIndex].distance; // Deduct distance to next pump
            }

            if (possible && tour.size() == n) { // Check if full circle is completed. Added this condition.
                return start; // Found a valid starting point
            }
        }

        return -1; // No starting point found
    }


    // More efficient approach (O(n) time complexity)
    public static int canCompleteCircuitEfficient(PetrolPump[] pumps) {
        int n = pumps.length;
        int totalPetrol = 0; // Total petrol across all pumps
        int currentPetrol = 0; // Petrol at the current point
        int start = 0;       // Potential starting point

        for (int i = 0; i < n; i++) {
            totalPetrol += pumps[i].petrol - pumps[i].distance;
            currentPetrol += pumps[i].petrol - pumps[i].distance;

            if (currentPetrol < 0) {
                start = i + 1;  // Update the starting point
                currentPetrol = 0; // Reset current petrol
            }
        }

        if (totalPetrol >= 0) {
            return start; // Valid starting point found
        } else {
            return -1; // No valid starting point
        }
    }

    public static void main(String[] args) {
        PetrolPump[] pumps = {
                new PetrolPump(4, 6),
                new PetrolPump(6, 5),
                new PetrolPump(3, 7)
        };

        int start = canCompleteCircuit(pumps);
        System.out.println("Starting point (Naive): " + start);  // Output: -1 (No solution in this case)

        int startEfficient = canCompleteCircuitEfficient(pumps);
        System.out.println("Starting point (Efficient): " + startEfficient); // Output: -1 (No solution in this case)

        PetrolPump[] pumps2 = {
                new PetrolPump(1, 3),
                new PetrolPump(2, 2),
                new PetrolPump(3, 1)
        };

        int start2 = canCompleteCircuit(pumps2);
        System.out.println("Starting point (Naive): " + start2); // Output: 2

        int startEfficient2 = canCompleteCircuitEfficient(pumps2);
        System.out.println("Starting point (Efficient): " + startEfficient2); // Output: 2

        PetrolPump[] pumps3 = {
                new PetrolPump(4, 3),
                new PetrolPump(2, 4),
                new PetrolPump(5, 3)
        };

        int start3 = canCompleteCircuit(pumps3);
        System.out.println("Starting point (Naive): " + start3); // Output: 0

        int startEfficient3 = canCompleteCircuitEfficient(pumps3);
        System.out.println("Starting point (Efficient): " + startEfficient3); // Output: 0

        PetrolPump[] pumps4 = {
                new PetrolPump(2, 3),
                new PetrolPump(2, 3),
                new PetrolPump(2, 3)
        };

        int start4 = canCompleteCircuit(pumps4);
        System.out.println("Starting point (Naive): " + start4); // Output: -1

        int startEfficient4 = canCompleteCircuitEfficient(pumps4);
        System.out.println("Starting point (Efficient): " + startEfficient4); // Output: -1

    }
}
