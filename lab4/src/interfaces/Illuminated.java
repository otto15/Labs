package interfaces;

import classes.LightSource;

import java.util.ArrayList;

public interface Illuminated {
    void outputIlluminationLevel();

    int calculateIllumination();

    int estimateDayLightIllumination();

    void addLightSource(LightSource newLightSource);

    void removeLightSource(LightSource lightSourceBeingDeleted);

    ArrayList<LightSource> getLightSources();
}
