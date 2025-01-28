package DataStructure.LinkedList.SinglyLinkedList.socialMediaFriendConnection;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String userId;
    private String name;
    private int age;
    private List<String> friendIds;
    private User next;

    public User(String userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friendIds = new ArrayList<>();
        this.next = null;
    }

    // Getters and setters
    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<String> getFriendIds() {
        return friendIds;
    }

    public User getNext() {
        return next;
    }

    public void setNext(User next) {
        this.next = next;
    }

    public void addFriend(String friendId) {
        if (!friendIds.contains(friendId)) {
            friendIds.add(friendId);
        }
    }

    public void removeFriend(String friendId) {
        friendIds.remove(friendId);
    }

    @Override
    public String toString() {
        return "User ID: " + userId + ", Name: " + name + ", Age: " + age + ", Friends: " + friendIds.size();
    }
}

