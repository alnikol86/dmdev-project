package src.homeWorkFour.space.spaceObjects;

public abstract class CelestialBody implements SpaceObject {
    Double mass;
    Double diameter;

    public CelestialBody(double mass, double diameter) {
        this.mass = mass;
        this.diameter = diameter;
    }

    @Override
    public double getMass() {
        return this.mass;
    }

    @Override
    public double getDiameter() {
        return this.diameter;
    }

    @Override
    public double calculateDiameter() {
        return this.diameter;
    }

    @Override
    public boolean compareMass(SpaceObject other) {
        return Double.compare(this.mass, other.getMass()) == 0;
    }

    @Override
    public abstract String toString();
}
