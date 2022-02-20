package classes;

import java.util.Objects;

import abstractions.Location;
import interfaces.Mobile;


public class LightSource implements Mobile<Location> {
    private String name;
    private int lightPower;
    private Location location;

    public LightSource(String name, int lightPower, Location location) {
        if ((name == null) || (name.isEmpty())) {
            throw new IllegalArgumentException("Некорректное имя");
        }
        if ((lightPower <= 0)) {
            throw new IllegalArgumentException("Неверный формат скорости. Скорость должна быть положительной.");
        }
        if (location == null) {
            throw new IllegalArgumentException("Некорректное местоположение");
        }
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
        if (destination == null) {
            throw new IllegalArgumentException("Некоректный пункт назначения");
        }
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
