package interfaces;

import classes.Cover;

public interface Coverable {
    void changeCoveredStatus();

    boolean isCovered();

    void quitCover(Cover cover);

    void setCover(Cover cover);
}
