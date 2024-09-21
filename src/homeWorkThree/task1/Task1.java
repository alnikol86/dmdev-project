package src.homeWorkThree.task1;

import java.util.Random;

/**
 * Представить в виде классов и их композиции следующую модель.
 * <p>
 * - Каждый дом содержит свой номер (int), и множество этажей (массив).
 * <p>
 * - Каждый этаж содержит номер этажа (int), и множество квартир (массив).
 * <p>
 * - Каждая квартира содержит свой номер (int), и множество комнат (массив).
 * <p>
 * - Каждая комната содержит поле проходная она или нет (boolean).
 * <p>
 * В каждом классе реализовать метод print, который на консоль выводит информацию об объекте (должны присутствовать все поля объекта!).
 * <p>
 * Например, метод print класса этаж должен выводить на консоль:
 * <p>
 * “Этаж 2, количество квартир 18”
 * <p>
 * Создание всех объектов вынести в отдельный класс с методом main.
 * <p>
 * Там же реализовать метод printAllInformation, который на вход принимает объект типа дом, и выводит информацию о нем, его этажах, квартирах и комнатах, вызывая методы print.
 */
public class Task1 {
    public static void main(String[] args) {
        House house = createHouse();
        printAllInformation(house);

    }

    private static House createHouse() {
        return new House(1, createFloors());
    }

    private static Floor[] createFloors() {
        Floor[] floors = new Floor[new Random().nextInt(5) + 5];
        for (int i = 0; i < floors.length; i++) {
            floors[i] = new Floor(i + 1, createApartments());
        }
        return floors;
    }

    private static Apartment[] createApartments() {
        Apartment[] apartments = new Apartment[new Random().nextInt(5)+5];
        for (int i = 0; i < apartments.length; i++) {
            Room[] rooms = new Room[new Random().nextInt(3)+2];
            for (int j = 0; j < rooms.length; j++) {
                rooms[j] = createRoom();
            }
            apartments[i] = new Apartment(i+1, rooms);
        }
        return apartments;
    }

    private static Room createRoom() {
        int walkThrough = new Random().nextInt(2);
        if (walkThrough == 0) {
            return new Room(true);
        } else {
            return new Room(false);
        }
    }

    private static void printAllInformation(House house) {
        house.print();
        Floor[] floors = house.getFloors();
        for (int floor = 0; floor < floors.length; floor++) {
            floors[floor].print();
            for (int apartment = 0; apartment < floors[floor].getApartments().length; apartment++) {
                Apartment[] apartments = floors[floor].getApartments();
                apartments[apartment].print();
                for (int room = 0; room < apartments[apartment].getRooms().length; room++) {
                    Room[] rooms = apartments[apartment].getRooms();
                    rooms[room].print();
                }
            }
        }
    }

}

