package classes;

import java.util.Objects;

import abstractions.Location;
import interfaces.Mobile;


public class LightSource implements Mobile<Location> {
    private String name;
    private int lightPower;
    private Location location;

    public LightSource(String name, int lightPower, Location location) {
        this.name = name;
        this.lightPower = lightPower;
        this.location = location;
        this.location.addLightSource(this);
    }

    public String getName() {
        return name;
    }

    public int getLightPower() {
        return lightPower;
    }

    @Override
    public void changeLocation(Location destination) {
        location.removeLightSource(this);
        location = destination;
        System.out.println(name + " переместился в " + destination.getName());
        destination.addLightSource(this);
    }

    @Override
    public Location getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return getClass().getName() + "[name: " + name + ", lightPower: " + lightPower + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lightPower);
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        if (otherObject == null) return false;
        if (getClass() != otherObject.getClass()) {
            return false;
        }
        LightSource otherLightSource = (LightSource) otherObject;

        return name.equals(otherLightSource.name) && lightPower == otherLightSource.lightPower;
    }

}
