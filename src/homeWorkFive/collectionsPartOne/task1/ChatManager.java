package src.homeWorkFive.collectionsPartOne.task1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * Задание 1
 * Дан список чатов.
 * Каждый чат состоит из двух полей: название и количество пользователей в этом чате.
 *
 * Задача:
 *
 * - Удалить с помощью итератора из этого списка те чаты, что содержат менее 1000 пользователей.
 *
 * - Оставшиеся чаты отсортировать с помощью компараторов по убыванию по количеству пользователей,
 * а если это количество совпадает, то по названию в алфавитном порядке.
 *
 * - Также предоставить сортировку чатов по названию по умолчанию.
 */

public class ChatManager {
    public static void main(String[] args) {
        List<Chat> chats = new ArrayList<>();
        chats.add(new Chat("General", 1200));
        chats.add(new Chat("Programming", 500));
        chats.add(new Chat("Music", 2000));
        chats.add(new Chat("Gaming", 700));
        chats.add(new Chat("Tech", 1500));

        // Удаление чатов с количеством пользователей менее 1000
        Iterator<Chat> iterator = chats.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getUserCount() < 1000) {
                iterator.remove();
            }
        }

        // Сортировка по количеству пользователей по убыванию и по названию в алфавитном порядке
        chats.sort(new Comparator<Chat>() {
            @Override
            public int compare(Chat c1, Chat c2) {
                int userCountComparison = Integer.compare(c2.getUserCount(), c1.getUserCount()); // Сортировка по убыванию
                if (userCountComparison != 0) {
                    return userCountComparison;
                } else {
                    return c1.getName().compareTo(c2.getName()); // Сортировка по названию в алфавитном порядке
                }
            }
        });

        // Вывод отсортированного списка чатов
        System.out.println("Sorted chats:");
        for (Chat chat : chats) {
            System.out.println(chat);
        }
    }
}
