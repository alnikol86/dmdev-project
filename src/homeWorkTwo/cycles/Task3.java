package src.homeWorkTwo.cycles;

/**
 * Программист Ваня сразу после окончания курсов dmdev устроился в IT компанию на позицию Junior Java Developer с зарплатой 600$ в месяц.
 * Ему обещали, что будут поднимать зарплату на 400$ каждые 6 месяцев.
 * 300$ в месяц Ваня тратит на еду и развлечения.
 * 10% от зарплаты Ваня ежемесячно переводит на счет брокера, чтобы инвестировать в акции с доходностью 2% в месяц.
 * <p>
 * Посчитать, сколько Ваня будет иметь средств на своем счету и на счету брокера за 3 года и 2 месяца.
 * <p>
 * Для интереса: попробовать увеличить процент, которые Ваня инвестирует из своей зарплаты
 */
public class Task3 {
    public static void main(String[] args) {
        int months = 38; // 3 года и 2 месяца
        double startingSalary = 600;
        double salaryIncrease = 400;
        int salaryIncreaseInterval = 6; // Повышение зарплаты каждые 6 месяцев
        double expenses = 300; // ежемесячные траты
        double investmentRate = 0.10; // 10% от зарплаты на инвестиции
        double investmentYield = 0.02; // 2% доходность в месяц

        double totalSavings = 0; // Личные накпления
        double brokerAccount = 0; // Счет у брокера

        for (int month = 1; month <= months; month++) {
            // Рассчитываем текущую зарплату
            double currentSalary = calculateSalary(month, startingSalary, salaryIncrease, salaryIncreaseInterval);
            //System.out.println(currentSalary);
            // Рассчитываем расходы
            double remainingSalary = currentSalary - expenses;

            // Рассчитываем сумму для инвестиций
            double investmentAmount = currentSalary * investmentRate;
            brokerAccount += investmentAmount;
            brokerAccount += calculateInvestmentYield(brokerAccount, investmentYield);

            // Остатлок на личный счет
            totalSavings += (remainingSalary - investmentAmount);
        }

        System.out.println("Personal savings: $" + totalSavings);
        System.out.println("Broker account: $" + brokerAccount);
    }


    // Метод расчета текущей зарплаты
    private static double calculateSalary(int month, double startingSalary, double salaryIncrease, int interval) {
        int periods = (month - 1) / interval; // Количество периодов повышения зарплаты
        return startingSalary + periods * salaryIncrease;
    }

    // Метод расчета доходности на брокерском счете
    private static double calculateInvestmentYield(double brokerAccount, double investmentYield) {
        return brokerAccount * investmentYield;
    }
}

