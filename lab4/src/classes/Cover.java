package classes;

import abstractions.Location;
import exceptions.FullCoverException;
import interfaces.Mobile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Cover extends Location implements Mobile<Room> {
    private Room location;
    private int capacity;
    private ArrayList<Character> coveredCharacters = new ArrayList<>();

    public Cover(String name, Room location, int capacity) {
        super(name);
        if (capacity < 0) {
            throw new IllegalArgumentException("Неверный формат вместимости. Вместимость должная быть неотрицательной.");
        }
        if (location == null) {
            throw new IllegalArgumentException("Некорректное местоположение");
        }
        this.capacity = capacity;
        this.location = location;
    }

    public ArrayList<Character> getCoveredCharacters() {
        return coveredCharacters;
    }

    public void addCharacter(Character character) {
        if (character == null) {
            throw new IllegalArgumentException("Некоректный персонаж");
        }
        if (coveredCharacters.size() == capacity) {
            throw new FullCoverException("Нельзя укрыть " + character.getName() + ", так как " + getName() + " заполнен");
        }
        coveredCharacters.add(character);
        character.changeCoveredStatus();
        character.changeLocation(this);
    }

    public void removeCharacter(Character character) {
        if (character == null) {
            throw new IllegalArgumentException("Некоректный персонаж");
        }
        coveredCharacters.remove(character);
        character.changeCoveredStatus();
        character.changeLocation(location);
    }

    @Override
    public void changeLocation(Room destination) {
        if (destination == null) {
            throw new IllegalArgumentException("Некоректный пункт назначения");
        }
        location = destination;
        System.out.println(getName() + " переместился в " + location.getName());
    }

    @Override
    public Room getLocation() {
        return location;
    }

    @Override
    public int hashCode() {
        return super.hashCode() + Objects.hash(location, coveredCharacters);
    }

    @Override
    public boolean equals(Object otherObject) {
        if (!super.equals(otherObject)) {
            return false;
        }
        Cover otherCover = (Cover) otherObject;

        return location.equals(otherCover.location) && coveredCharacters.equals(otherCover.coveredCharacters);
    }

    @Override
    public String toString() {
        return super.toString() + "[location: " + location + ", covered characters: " + Arrays.toString(coveredCharacters.toArray());
    }
}
