package com.lab.attacks;

import ru.ifmo.se.pokemon.*;

public class StoneEdge extends PhysicalMove {
    public StoneEdge() {
        super(Type.ROCK, 100, 80);
    }

    @Override
    public String describe() {
        return "use Stone Edge";
    }

    @Override
    public double calcCriticalHit(Pokemon var1, Pokemon var2) {
        if (var1.getStat(Stat.SPEED) / 256.0D > Math.random()) {
            System.out.println("critical");
            return 2.0D;
        } else {
            return 1.0D;
        }
    }
}
