package com.lab.attacks;

import ru.ifmo.se.pokemon.*;

public class RockSlide extends PhysicalMove {
    public RockSlide() {
        super(Type.ROCK, 75, 90);
    }

    @Override
    public String describe() {
        return "use Rock Slide";
    }

    @Override
    protected void applyOppEffects(Pokemon defender) {
        if (0.3 > Math.random()) {
            Effect.flinch(defender);
        }
    }
}
