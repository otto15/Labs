package com.lab.attacks;

import ru.ifmo.se.pokemon.*;

public class Facade extends PhysicalMove {
    public Facade() {
        super(Type.NORMAL, 70, 100);
    }

    @Override
    public String describe() {
        return "use Facade";
    }

    @Override
    protected void applyOppDamage(Pokemon def, double damage) {
        Status defCondition = def.getCondition();
        if (defCondition.equals(Status.BURN) || defCondition.equals(Status.POISON) || defCondition.equals(Status.PARALYZE)) {
            super.applyOppDamage(def, damage * 2);
        }
        super.applyOppDamage(def, damage);
    }
}
