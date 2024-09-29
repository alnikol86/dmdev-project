package src.homeWorkFour.space.spaceObjects;

public class Planet extends CelestialBody{
    private boolean hasAtmosphere;

    public Planet(double mass, double diameter, boolean hasAtmosphere) {
        super(mass, diameter);
        this.hasAtmosphere = hasAtmosphere;
    }

    public boolean hasLife() {
        return hasAtmosphere;
    }

    @Override
    public boolean compareMass(SpaceObject other) {
        return this.mass == other.getMass();
    }

    @Override
    public String toString() {
        return "Planet with mass " + mass + " and diameter " + diameter + " and has atmosphere - " + hasAtmosphere;
    }
}
