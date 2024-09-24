package src.homeWorkThree.task1.building;

public class Apartment {
    private Integer apartmentNumber;
    private Room[] rooms;

    public Apartment(int apartmentNumber, Room[] rooms) {
        this.apartmentNumber = apartmentNumber;
        this.rooms = rooms;
    }

    public int getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(int apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public Room[] getRooms() {
        return rooms;
    }

    public void setRooms(Room[] rooms) {
        this.rooms = rooms;
    }

    public void print() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "Apartment number = " + apartmentNumber +
                ", rooms in the apartment = " + rooms.length;
    }
}
