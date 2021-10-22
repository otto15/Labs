package com.lab.attacks;

import ru.ifmo.se.pokemon.*;

public class WoodHammer extends PhysicalMove {
    public WoodHammer() {
        super(Type.GRASS, 120, 100);
    }

    @Override
    public String describe() {
        return "use Wood Hammer";
    }

    @Override
    protected void applySelfDamage(Pokemon att, double damage) {
        att.setMod(Stat.HP, (int) Math.round(damage / 3));
    }
}
