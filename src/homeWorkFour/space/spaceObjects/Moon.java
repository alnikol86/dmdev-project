package src.homeWorkFour.space.spaceObjects;

public class Moon extends Satellite{

    private Boolean onOrbitPlanet;

    public Moon(double mass, double diameter, boolean natural, boolean onOrbitPlanet) {
        super(mass, diameter, natural);
        this.onOrbitPlanet = onOrbitPlanet;
    }

    public boolean hasPlanetMoon(){
        return onOrbitPlanet;
    }

    @Override
    public boolean compareMass(SpaceObject other) {
        return this.mass == other.getMass();
    }

    @Override
    public String toString() {
        return "Moon with mass " + mass + ", and diameter " + diameter + ", and natural - " + natural + ", and on orbit the planet - " + onOrbitPlanet;
    }
}
