package src.homeWorkThree.task1.building;

public class Room {
    private Boolean walkThroughRoom;

    public Room(boolean walkThroughRoom) {
        this.walkThroughRoom = walkThroughRoom;
    }

    public boolean isWalkThroughRoom() {
        return walkThroughRoom;
    }

    public void setWalkThroughRoom(boolean walkThroughRoom) {
        this.walkThroughRoom = walkThroughRoom;
    }

    public void print() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "Walk-through room = " + walkThroughRoom;
    }
}
