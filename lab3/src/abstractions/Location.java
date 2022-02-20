package abstractions;

import classes.LightSource;
import exceptions.NoLightSourcesException;
import interfaces.Illuminated;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public abstract class Location implements Illuminated {
    private String name;
    private ArrayList<LightSource> lightSources = new ArrayList<>();

    public Location(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    @Override
    public void outputIlluminationLevel() {
        int illuminationLevel = calculateIllumination();
        System.out.print("В " + name);
        if (illuminationLevel < 20) {
            System.out.println(" темно");
        } else if (illuminationLevel < 60) {
            System.out.println(" средний уровень освещения");
        } else if (illuminationLevel < 80) {
            System.out.println(" ярко");
        } else {
            System.out.println(" очень ярко");
        }
    }

    @Override
    public int calculateIllumination() {
        int level = estimateDayLightIllumination();
        for (LightSource singleLightSource : lightSources) {
            level += singleLightSource.getLightPower();
        }
        return level;
    }

    @Override
    public int estimateDayLightIllumination() {
        int currentHour = LocalDateTime.now().getHour();
        if (6 <= currentHour && currentHour < 10 ||
                14 <= currentHour && currentHour < 17) {
            return 40;
        } else if (10 <= currentHour && currentHour < 14) {
            return 60;
        } else if (17 <= currentHour && currentHour < 20) {
            return 20;
        } else {
            return 10;
        }
    }

    @Override
    public void addLightSource(LightSource newLightSource) {
        lightSources.add(newLightSource);
        System.out.println("В " + name + " появился новый источник света, " + newLightSource.getName());
    }

    @Override
    public void removeLightSource(LightSource lightSourceBeingDeleted) {
        lightSources.remove(lightSourceBeingDeleted);
        System.out.println("В " + name + " теперь нет источника света, " + lightSourceBeingDeleted.getName());
    }

    @Override
    public ArrayList<LightSource> getLightSources() {
        return lightSources;
    }

    @Override
    public String toString() {
        return getClass().getName() + "[name: " + name + ", light sources: " + Arrays.toString(lightSources.toArray());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lightSources);
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        if (otherObject == null) return false;
        if (getClass() != otherObject.getClass()) {
            return false;
        }
        Location otherLocation = (Location) otherObject;


        return name.equals(otherLocation.name) && lightSources.equals(otherLocation.lightSources);
    }

    public ArrayList<LightInformationPair> getLightProportions() throws NoLightSourcesException {
        if (lightSources.isEmpty()) {
            throw new NoLightSourcesException("У " + name + " нет искусственных источников света.");
        }
        ArrayList<LightInformationPair> proportions = new ArrayList<>();
        for (LightSource lightSource: lightSources) {
            proportions.add(new LightInformationPair(lightSource, ((double) lightSource.getLightPower() / calculateIllumination()) * 100));
        }
        return proportions;
    }

    public static class LightInformationPair {
        private LightSource lightSource;
        private Double percentageOfTotalLightning;

        LightInformationPair(LightSource lightSource, Double percentageOfTotalLightning) {
            this.lightSource = lightSource;
            this.percentageOfTotalLightning = percentageOfTotalLightning;
        }

        public LightSource getFirst() {
            return lightSource;
        }

        public Double getSecond() {
            return percentageOfTotalLightning;
        }

        @Override
        public String toString() {
            return "[" + getFirst().getName() + ": " + new DecimalFormat("#0.00").format(getSecond()) + "%]";
        }
    }
}
