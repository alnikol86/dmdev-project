package src.homeWorkEight;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Crystal {
    private final AtomicInteger redCrystals = new AtomicInteger(0);
    private final AtomicInteger whiteCrystals = new AtomicInteger(0);
    private final Random random = new Random();
    private boolean crystalsCollectedToday = false;

    // Генерация кристаллов в начале дня (от 2 до 5)
    public synchronized void generateCrystals() {
        if (!crystalsCollectedToday) {
            int totalCrystals = random.nextInt(4) + 2; // от 2 до 5 кристаллов
            int red = random.nextInt(totalCrystals + 1);
            int white = totalCrystals - red;
            redCrystals.set(red);
            whiteCrystals.set(white);
            crystalsCollectedToday = true;
            //System.out.println("Generated: " + red + " red and " + white + " white crystals.");
        }
    }

    // Метод сбора кристаллов: первый поток забирает все, второй - пустой
    public synchronized int[] collectCrystals() {
        if (!crystalsCollectedToday) {
            return new int[] { 0, 0 }; // если кристаллы уже собраны
        }
        int availableRed = redCrystals.getAndSet(0);
        int availableWhite = whiteCrystals.getAndSet(0);
        crystalsCollectedToday = false; // сбрасываем для следующего дня
        return new int[] { availableRed, availableWhite };
    }
}