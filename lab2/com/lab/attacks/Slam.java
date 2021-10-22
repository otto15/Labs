package com.lab.attacks;

import ru.ifmo.se.pokemon.*;

public class Slam extends PhysicalMove {
    public Slam() {
        super(Type.NORMAL, 80, 75);
    }

    @Override
    public String describe() {
        return "use Slam";
    }
}
