package src.homeWorkFive.collectionsPartOne.task1;

public class Chat implements Comparable<Chat>{
    private String name;
    private Integer userCount;

    public Chat(String name, int userCount) {
        this.name = name;
        this.userCount = userCount;
    }

    public String getName() {
        return name;
    }

    public int getUserCount() {
        return userCount;
    }

    // Сортировка по умолчанию — по названию
    @Override
    public int compareTo(Chat other) {
        return this.name.compareTo(other.name);
    }

    @Override
    public String toString() {
        return "Chat{name='" + name + "', userCount=" + userCount + "}";
    }
}
