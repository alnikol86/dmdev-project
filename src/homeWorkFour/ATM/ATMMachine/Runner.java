package src.homeWorkFour.ATM.ATMMachine;

public class Runner {
    public static void main(String[] args) {
        ATM atm = new ATM(1, 1, 1);
        atm.addMoney(5, 2, 1);
        atm.withdraw(200);
        System.out.println();
        atm.withdraw(500);
    }
}
