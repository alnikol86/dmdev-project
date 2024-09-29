package src.homeWorkFour.space.spaceObjects;

public class Asteroid extends CelestialBody{
    private Double speed;

    public Asteroid(double mass, double diameter, double speed) {
        super(mass, diameter);
        this.speed = speed;
    }

    public double getSpeed() {
        return speed;
    }

    @Override
    public boolean compareMass(SpaceObject other) {
        return this.mass == other.getMass();
    }

    @Override
    public String toString() {
        return "Asteroid with mass " + mass + ", and diameter " + diameter + ", and speed " + speed;
    }
}
