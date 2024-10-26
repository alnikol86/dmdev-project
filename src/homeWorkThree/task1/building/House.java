package src.homeWorkThree.task1.building;

public class House {
    private Integer homeNumber;
    private Floor[] floors;

    public House(int homeNumber, Floor[] floors) {
        this.homeNumber = homeNumber;
        this.floors = floors;
    }

    public int getHomeNumber() {
        return homeNumber;
    }

    public void setHomeNumber(int homeNumber) {
        this.homeNumber = homeNumber;
    }

    public Floor[] getFloors() {
        return floors;
    }

    public void setFloors(Floor[] floors) {
        this.floors = floors;
    }

    public void print() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "House number = " + homeNumber +
                ", floors in the house = " + floors.length;
    }
}
