package classes;

import abstractions.Location;
import enums.Mood;
import interfaces.AbleToRelocateObject;
import interfaces.Coverable;
import interfaces.HasMood;
import interfaces.Mobile;

import java.util.Objects;
import java.util.SortedMap;

public class Character implements
        HasMood, Mobile<Location>, Coverable {
    private String name;
    private Location location;
    private Mood moodState;
    private boolean covered = false;

    public Character(String name, Location location) {
        this(name, location, Mood.NORMAL);
    }

    public Character(String name, Location location, Mood moodState) {
        this.name = name;
        this.location = location;
        this.moodState = moodState;
    }

    public String getName() {
        return name;
    }

    public void turnOnLamp(Lamp lamp) {
        System.out.println(getName() + " пытается включить " + lamp.getName());
        if (location.equals(lamp.getLocation())) {
            lamp.turnOn();
        } else {
            System.out.println("У " + name + " не получилось выключить " + lamp.getName() + ": " + lamp.getName() + " находится в другой комнате");
        }
    }

    public void turnOffLamp(Lamp lamp) {
        System.out.println(getName() + " пытается выключить " + lamp.getName());
        if (location.equals(lamp.getLocation())) {
            lamp.turnOff();
        } else {
            System.out.println("У " + name + " не получилось включить " + lamp.getName() + ": " + lamp.getName() + " находится в другой комнате");
        }
    }

    public void unexpectedMoodChange() {
        System.out.println("У " + name + " возможна резкая перемена настроения");
        class MoodGenerator {
            private Mood currentMoodState;

            MoodGenerator(Mood currentMoodState) {
                this.currentMoodState = currentMoodState;
            }

            public Mood generateNextMoodState() {
                int min = 1, max = Mood.values().length - 1;
                int randSwitch = (int) (Math.random() * (max - min + 1)) + min;
                return Mood.values()[(currentMoodState.ordinal() + randSwitch) % Mood.values().length];
            }
        }

        if (Math.random() < 0.2) {
            MoodGenerator newMood = new MoodGenerator(moodState);
            setMood(newMood.generateNextMoodState());
        } else {
            System.out.println("Настроение не поменялось");
        }
    }

    public void changeLocationByTeleport(Location destination) {
        AbleToRelocateObject teleport = new AbleToRelocateObject() {
            @Override
            public void relocate(Location destination) {
                location = destination;
                System.out.println(Character.this.name + " внезапно телепортировался в " + destination.getName());
            }
        };
        teleport.relocate(destination);
    }

    @Override
    public void changeCoveredStatus() {
        covered = !covered;
    }

    @Override
    public boolean isCovered() {
        return covered;
    }

    @Override
    public void setCover(Cover cover) {
        cover.addCharacter(this);
        System.out.println(name + " укрылся в " + cover.getName());
    }


    @Override
    public void quitCover(Cover cover) {
        cover.removeCharacter(this);
        System.out.println(name + " вышел из " + cover.getName());
    }

    @Override
    public String getMood() {
        return moodState.getRepresentation();
    }

    @Override
    public void setMood(Mood newMood) {
        moodState = newMood;
        System.out.println("У " + name + " теперь " + getMood() + " настроение");
    }

    @Override
    public void changeLocation(Location destination) {
        location = destination;
        if (!covered) {
            System.out.println(getName() + " переместился в " + location.getName());
        }
    }

    @Override
    public Location getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return getClass().getName() + "[name: " + name + ", location: " + location.getName() + ", mood: "
                + moodState.getRepresentation() + ", covered: " + covered + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, location, moodState, covered);
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        if (otherObject == null) return false;
        if (getClass() != otherObject.getClass()) {
            return false;
        }
        Character otherCharacter = (Character) otherObject;


        return name.equals(otherCharacter.name) && location.equals(otherCharacter.location)
                && moodState.equals(otherCharacter.moodState)
                && covered == otherCharacter.covered;
    }

}
