package classes;

import abstractions.Location;
import interfaces.Switchable;

public class Lamp extends LightSource implements Switchable {
    private boolean status = false;

    public Lamp(String name, int lightPower, Location location) {
        super(name, lightPower, location);
    }

    @Override
    public int getLightPower() {
        if (isTurnedOn()) {
            return super.getLightPower();
        }
        return 0;
    }

    @Override
    public void changeStatus() {
        status = !status;
        if (status) {
            System.out.println(getName() + " был включен");
        } else {
            System.out.println(getName() + " был выключен");
        }
    }

    @Override
    public boolean isTurnedOn() {
        return status;
    }

    @Override
    public void outputStatus() {
        System.out.print(getName());
        if (isTurnedOn()) {
            System.out.println(" включён");
        }
        System.out.println(" выключен");
    }

    @Override
    public void turnOn() {
        if (isTurnedOn()) {
            System.out.println(getName() + " уже включен");
        } else {
            changeStatus();
        }
    }

    @Override
    public void turnOff() {
        if (!isTurnedOn()) {
            System.out.println(getName() + " уже выключен");
        } else {
            changeStatus();
        }
    }

    @Override
    public String toString() {
        return super.toString() + "[status: " + status + "]";
    }

}
