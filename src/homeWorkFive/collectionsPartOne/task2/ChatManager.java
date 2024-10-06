package src.homeWorkFive.collectionsPartOne.task2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Дан список чатов с предыдущего задания, только вместо поля “количество пользователей”
 * будет список объектов типа Пользователь, который имеет 3 поля: id (целочисленный идентификатор), имя и возраст.
 *
 * Задача:
 *
 * - Преобразовать список чатов в один список пользователей всех чатов, возраст которых больше 18 лет
 *
 * - С помощью итератора посчитать средний возраст всех оставшихся пользователей.
 */
public class ChatManager {
    public static void main(String[] args) {
        List<User> users1 = new ArrayList<>();
        users1.add(new User(1, "Alice", 25));
        users1.add(new User(2, "Bob", 17));
        users1.add(new User(3, "Charlie", 20));

        List<User> users2 = new ArrayList<>();
        users2.add(new User(4, "Dave", 30));
        users2.add(new User(5, "Eve", 15));

        List<Chat> chats = new ArrayList<>();
        chats.add(new Chat("Chat1", users1));
        chats.add(new Chat("Chat2", users2));

        // Преобразуем список чатов в один список пользователей старше 18 лет
        List<User> filteredUsers = new ArrayList<>();
        for (Chat chat : chats) {
            for (User user : chat.getUsers()) {
                if (user.getAge() > 18) {
                    filteredUsers.add(user);
                }
            }
        }

        // Посчитаем средний возраст с помощью итератора
        Iterator<User> iterator = filteredUsers.iterator();
        int totalAge = 0;
        int count = 0;

        while (iterator.hasNext()) {
            User user = iterator.next();
            totalAge += user.getAge();
            count++;
        }

        if (count > 0) {
            double averageAge = (double) totalAge / count;
            System.out.println("The average age of users is over 18 years old: " + averageAge);
        } else {
            System.out.println("No users over 18 years old.");
        }
    }
}
