package src.homeWorkOne;

public class Task1 {
    public static void main(String[] args) {

        int minutes1 = 12;
        int minutes2 = 23;
        int minutes3 = 31;
        int minutes4 = 60;
        int minutes5 = 59;
        int minutes6 = 0;

        getQuarterOfHour(minutes1);
        getQuarterOfHour(minutes2);
        getQuarterOfHour(minutes3);
        getQuarterOfHour(minutes4);
        getQuarterOfHour(minutes5);
        getQuarterOfHour(minutes6);
    }

    public static void getQuarterOfHour(int minutes) {
        if (minutes <= 15) {
            System.out.println(minutes + " falls in the first quarter");
        } else if (minutes <= 30) {
            System.out.println(minutes + " falls in the second quarter");
        } else if (minutes <= 45) {
            System.out.println(minutes + " falls in the third quarter");
        } else if (minutes <= 59) {
            System.out.println(minutes + " falls in the fourth quarter");
        } else {
            System.out.println(minutes + " is not acceptable as a minute in an hour");
        }
    }
}
