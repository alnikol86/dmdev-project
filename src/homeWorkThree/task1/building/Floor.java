package src.homeWorkThree.task1.building;


public class Floor {
    private Integer floorNumber;
    private Apartment[] apartments;

    public Floor(int floorNumber, Apartment[] apartments) {
        this.floorNumber = floorNumber;
        this.apartments = apartments;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public Apartment[] getApartments() {
        return apartments;
    }

    public void setApartments(Apartment[] apartments) {
        this.apartments = apartments;
    }

    public void print() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "Floor number = " + floorNumber +
                ", apartments on the floor = " + apartments.length;
    }
}
