package classes;

import enums.Mood;
import abstractions.Location;
import interfaces.Flyable;
import interfaces.Switchable;

public class FlyingCharacter extends Character implements Flyable {
    private boolean onFlight;
    private Propeller propeller;

    public FlyingCharacter(String name, Location location, String propellerModelName, Double propellerRevolutionSpeed) {
        this(name, location, Mood.NORMAL, propellerModelName, propellerRevolutionSpeed);
    }

    public FlyingCharacter(String name, Location location, Mood moodState, String propellerModelName, Double propellerRevolutionSpeed) {
        super(name, location, moodState);
        propeller = new Propeller(propellerModelName, propellerRevolutionSpeed);
    }

    @Override
    public void launch() {
        System.out.println(getName() + " пытается взлететь");
        propeller.turnOn();
        System.out.println(getName() + " в воздухе");
    }

    @Override
    public void land() {
        System.out.println(getName() + " пытается приземлиться");
        propeller.turnOff();
        System.out.println(getName() + " на земле");
    }

    public class Propeller implements Switchable {
        private String modelName;
        private Double revolutionSpeed;

        public Propeller(String modelName, Double revolutionSpeed) {
            this.modelName = modelName;
            this.revolutionSpeed = revolutionSpeed;
        }

        @Override
        public void changeStatus() {
            onFlight = !onFlight;
            System.out.print(modelName);
            if (onFlight) {
                System.out.println(" был включен");
            } else {
                System.out.println(" был выключен");
            }
        }

        @Override
        public boolean isTurnedOn() {
            return onFlight;
        }

        @Override
        public void outputStatus() {
            System.out.print(modelName);
            if (isTurnedOn()) {
                System.out.println(" включён");
            }
            System.out.println(" выключен");
        }

        @Override
        public void turnOn() {
            if (isTurnedOn()) {
                System.out.println(modelName + " уже включен");
            } else {
                changeStatus();
            }
        }

        @Override
        public void turnOff() {
            if (!isTurnedOn()) {
                System.out.println(modelName + " уже выключен");
            } else {
                changeStatus();
            }
        }

    }
}
