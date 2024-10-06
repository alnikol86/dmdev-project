package src.homeWorkFive.collectionsPartOne.task2;

import java.util.List;

public class Chat {
    private String name;
    private List<User> users;

    public Chat(String name, List<User> users) {
        this.name = name;
        this.users = users;
    }

    public List<User> getUsers() {
        return users;
    }
}
