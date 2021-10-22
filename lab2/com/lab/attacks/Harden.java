package com.lab.attacks;

import ru.ifmo.se.pokemon.*;

public class Harden extends StatusMove {
    public Harden() {
        super(Type.NORMAL, 0,0);
    }

    @Override
    public String describe() {
        return "use Harden";
    }

    @Override
    protected void applySelfEffects(Pokemon pokemon) {
        pokemon.setMod(Stat.DEFENSE, 1);
    }
}

