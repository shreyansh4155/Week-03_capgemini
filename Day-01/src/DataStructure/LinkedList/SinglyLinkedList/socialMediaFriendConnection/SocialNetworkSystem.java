package DataStructure.LinkedList.SinglyLinkedList.socialMediaFriendConnection;

import java.util.List;

public class SocialNetworkSystem {
    public static void main(String[] args) {
        SocialNetwork network = new SocialNetwork();

        // Add users
        network.addUser(new User("U001", "Alice", 25));
        network.addUser(new User("U002", "Bob", 30));
        network.addUser(new User("U003", "Charlie", 28));
        network.addUser(new User("U004", "David", 22));

        System.out.println("All users:");
        network.displayAllUsers();

        // Add friend connections
        network.addFriendConnection("U001", "U002");
        network.addFriendConnection("U001", "U003");
        network.addFriendConnection("U002", "U003");
        network.addFriendConnection("U002", "U004");

        System.out.println("\nFriends of Alice:");
        network.displayFriends("U001");

        // Remove a friend connection
        network.removeFriendConnection("U001", "U002");

        System.out.println("\nFriends of Alice after removing Bob:");
        network.displayFriends("U001");

        // Find mutual friends
        List<String> mutualFriends = network.findMutualFriends("U001", "U002");
        System.out.println("\nMutual friends between Alice and Bob: " + mutualFriends);

        // Search for a user by name
        User foundUser = network.findUserByName("Charlie");
        System.out.println("\nFound user: " + (foundUser != null ? foundUser : "Not found"));

        // Count friends for all users
        System.out.println("\nFriend count for all users:");
        network.countFriendsForAllUsers();
    }
}
