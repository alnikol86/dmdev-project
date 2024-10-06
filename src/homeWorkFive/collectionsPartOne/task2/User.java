package src.homeWorkFive.collectionsPartOne.task2;

public class User {
    private Integer id;
    private String name;
    private Integer age;

    public User(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "User{id=" + id + ", name='" + name + "', age=" + age + "}";
    }
}
