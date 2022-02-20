package classes;

import abstractions.Location;
import enums.Mood;
import exceptions.SomeError;
import interfaces.*;

import java.util.Objects;

public class Character implements
        HasMood, Mobile<Location>, Coverable, FuncInterface {
    @MyAnnotation(str = "me")
    private final String name;
    private Location location;
    private Mood moodState;
    private boolean covered = false;

    public Character(String name, Location location) {
        this(name, location, Mood.NORMAL);
    }

    public Character(String name, Location location, Mood moodState) {
        if ((name == null) || (name.isEmpty())) {
            throw new IllegalArgumentException("Некорректное имя");
        }
        if (location == null) {
            throw new IllegalArgumentException("Некорректное местоположение");
        }
        if (moodState == null) {
            throw new IllegalArgumentException("Некорректное настроение");
        }
        this.name = name;
        this.location = location;
        this.moodState = moodState;
    }

    @Override
    public int c() {
        return 2;
    }

    public String getName() {
        return name;
    }

    public void turnOnLamp(Lamp lamp) {
        if (lamp == null) {
            throw new IllegalArgumentException("Некорректный искусственный источник света");
        }
        System.out.println(getName() + " пытается включить " + lamp.getName());
        if (location.equals(lamp.getLocation())) {
            lamp.turnOn();
        } else {
            System.out.println("У " + name + " не получилось выключить " + lamp.getName() + ": " + lamp.getName() + " находится в другой комнате");
        }
    }

    public void turnOffLamp(Lamp lamp) {
        if (lamp == null) {
            throw new IllegalArgumentException("Некорректный искусственный источник света");
        }
        System.out.println(getName() + " пытается выключить " + lamp.getName());
        if (location.equals(lamp.getLocation())) {
            lamp.turnOff();
        } else {
            System.out.println("У " + name + " не получилось включить " + lamp.getName() + ": " + lamp.getName() + " находится в другой комнате");
        }
    }

    @MyAnnotation(num = 3, str = "me")
    public void unexpectedMoodChange() {
        System.out.println("У " + name + " возможна резкая перемена настроения");
        class MoodGenerator {
            private Mood currentMoodState;

            MoodGenerator(Mood currentMoodState) {
                this.currentMoodState = currentMoodState;
            }

            public static int t() {
                return 2;
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
            System.out.println(MoodGenerator.t());
        } else {
            System.out.println("Настроение не поменялось");
        }
    }

    public void changeLocationByTeleport(Location destination) {
        if (destination == null) {
            throw new IllegalArgumentException("Некоректный пункт назначения");
        }
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
        if (cover == null) {
            throw new IllegalArgumentException("Некоректное укрытие");
        }
        cover.addCharacter(this);
        System.out.println(name + " укрылся в " + cover.getName());
    }


    @Override
    public void quitCover(Cover cover) {
        if (cover == null) {
            throw new IllegalArgumentException("Некоректное укрытие");
        }
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
        if (destination == null) {
            throw new IllegalArgumentException("Некоректный пункт назначения");
        }
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
