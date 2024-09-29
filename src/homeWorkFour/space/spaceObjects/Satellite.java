package src.homeWorkFour.space.spaceObjects;

public abstract class Satellite extends CelestialBody{

    Boolean natural;
    public Satellite(double mass, double diameter, boolean natural ) {
        super(mass, diameter);
        this.natural = natural;
    }

    @Override
    public abstract String toString();
}
