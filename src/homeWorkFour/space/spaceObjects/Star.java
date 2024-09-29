package src.homeWorkFour.space.spaceObjects;

public class Star extends CelestialBody{
    private Double luminosity;

    public Star(double mass, double diameter, double luminosity) {
        super(mass, diameter);
        this.luminosity = luminosity;
    }

    public double calculateLuminosity() {
        return this.luminosity;
    }

    @Override
    public boolean compareMass(SpaceObject other) {
        return this.mass == other.getMass();
    }

    @Override
    public String toString() {
        return "Star with mass " + mass + " and luminosity " + luminosity;
    }
}
