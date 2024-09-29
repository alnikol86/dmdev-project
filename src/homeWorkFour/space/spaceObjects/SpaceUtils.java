package src.homeWorkFour.space.spaceObjects;

public final class SpaceUtils {
    private SpaceUtils() {}

    public static double calculateGravity(SpaceObject obj1, SpaceObject obj2) {
        double distance = Math.random() * 1000; // случайное расстояние
        return ((obj1.getMass() * obj1.getDiameter()) * (obj2.getMass() * obj2.getDiameter())) / (distance * distance);
    }

    public static boolean isStar(SpaceObject obj) {
        return obj instanceof Star;
    }

}
