package DataStructure.LinkedList.SinglyLinkedList.socialMediaFriendConnection;

import java.util.ArrayList;
import java.util.List;

public class SocialNetwork {
    private User head;

    public SocialNetwork() {
        this.head = null;
    }

    // Add a new user
    public void addUser(User user) {
        if (head == null) {
            head = user;
        } else {
            User current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(user);
        }
    }

    // Add a friend connection between two users
    public void addFriendConnection(String userId1, String userId2) {
        User user1 = findUserById(userId1);
        User user2 = findUserById(userId2);

        if (user1 != null && user2 != null) {
            user1.addFriend(userId2);
            user2.addFriend(userId1);
            System.out.println("Friend connection added between " + user1.getName() + " and " + user2.getName());
        } else {
            System.out.println("One or both users not found.");
        }
    }

    // Remove a friend connection
    public void removeFriendConnection(String userId1, String userId2) {
        User user1 = findUserById(userId1);
        User user2 = findUserById(userId2);

        if (user1 != null && user2 != null) {
            user1.removeFriend(userId2);
            user2.removeFriend(userId1);
            System.out.println("Friend connection removed between " + user1.getName() + " and " + user2.getName());
        } else {
            System.out.println("One or both users not found.");
        }
    }

    // Find mutual friends between two users
    public List<String> findMutualFriends(String userId1, String userId2) {
        User user1 = findUserById(userId1);
        User user2 = findUserById(userId2);

        if (user1 != null && user2 != null) {
            List<String> mutualFriends = new ArrayList<>(user1.getFriendIds());
            mutualFriends.retainAll(user2.getFriendIds());
            return mutualFriends;
        } else {
            System.out.println("One or both users not found.");
            return new ArrayList<>();
        }
    }

    // Display all friends of a specific user
    public void displayFriends(String userId) {
        User user = findUserById(userId);
        if (user != null) {
            System.out.println("Friends of " + user.getName() + ":");
            for (String friendId : user.getFriendIds()) {
                User friend = findUserById(friendId);
                if (friend != null) {
                    System.out.println(friend);
                }
            }
        } else {
            System.out.println("User not found.");
        }
    }

    // Search for a user by User ID
    public User findUserById(String userId) {
        User current = head;
        while (current != null) {
            if (current.getUserId().equals(userId)) {
                return current;
            }
            current = current.getNext();
        }
        return null;
    }

    // Search for a user by Name
    public User findUserByName(String name) {
        User current = head;
        while (current != null) {
            if (current.getName().equalsIgnoreCase(name)) {
                return current;
            }
            current = current.getNext();
        }
        return null;
    }

    // Count the number of friends for each user
    public void countFriendsForAllUsers() {
        User current = head;
        while (current != null) {
            System.out.println(current.getName() + " has " + current.getFriendIds().size() + " friends");
            current = current.getNext();
        }
    }

    // Display all users
    public void displayAllUsers() {
        User current = head;
        while (current != null) {
            System.out.println(current);
            current = current.getNext();
        }
    }
}

