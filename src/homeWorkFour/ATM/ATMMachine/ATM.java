package src.homeWorkFour.ATM.ATMMachine;


/**
 * Задание 1
 *
 * Создать класс, описывающий банкомат.
 *
 * Банкомат задается тремя свойствами:
 * - количеством купюр номиналом 10, 20 и 50.
 *
 * Создать конструктор с тремя параметрами - количеством купюр каждого номинала.
 *
 * Сделать методы для добавления денег в банкомат.
 *
 * Сделать метод, снимающий деньги: он принимает сумму денег, а возвращает булево значение - успешность выполнения операции.
 *
 * При снятии денег метод должен распечатывать каким количеством купюр какого номинала выдаётся сумма.
 * Сначала банкомат будет пытаться рассчитаться 50, далее добавит недостающие 20, и только затем 10
 * (не нужно рассматривать более сложные варианты выдачи наличных, чтобы не усложнять алгоритм).
 */

public class ATM {
    private Integer count10; // купюры номиналом 10
    private Integer count20; // купюры номиналом 20
    private Integer count50; // купюры номиналом 50

    public ATM(int count10, int count20, int count50) {
        this.count10 = count10;
        this.count20 = count20;
        this.count50 = count50;
    }

    public void addMoney(int count10, int count20, int count50) {
        this.count10 += count10;
        this.count20 += count20;
        this.count50 += count50;
    }

    public boolean withdraw(int amount) {
        // Проверим, возможно ли снять такую сумму
        if (amount <= 0 || amount % 10 != 0) {
            System.out.println("Invalid amount to withdraw.");
            return false;
        }

        int needed50 = Math.min(amount / 50, count50); // Максимально возможное количество купюр 50
        amount -= needed50 * 50;

        int needed20 = Math.min(amount / 20, count20); // Максимально возможное количество купюр 20
        amount -= needed20 * 20;

        int needed10 = Math.min(amount / 10, count10); // Максимально возможное количество купюр 10
        amount -= needed10 * 10;

        // Если сумма не равна 0 после всех вычитаний, значит, мы не можем выдать такую сумму
        if (amount != 0) {
            System.out.println("The specified amount cannot be issued.");
            return false;
        }

        // Если удалось рассчитать нужные купюры, уменьшим их количество
        count50 -= needed50;
        count20 -= needed20;
        count10 -= needed10;

        // Распечатаем, какими купюрами выдана сумма
        System.out.println("Issued:");
        if (needed50 > 0) System.out.println("Banknotes 50: " + needed50);
        if (needed20 > 0) System.out.println("Banknotes 20: " + needed20);
        if (needed10 > 0) System.out.println("Banknotes 10: " + needed10);

        return true;
    }
}
