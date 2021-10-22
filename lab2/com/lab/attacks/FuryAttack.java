package com.lab.attacks;

import ru.ifmo.se.pokemon.*;

public class FuryAttack extends PhysicalMove {
    public FuryAttack() {
        super(Type.NORMAL, 15, 85);
        // Fury Attack hits 2-5 times per turn used (3/8 - probability for 2, 3 hits; 1/8 - 4, 5)
        for (int i = 0; i < 4; i++) {
            double prob = (i < 2) ? 3.0 / 8 : 1.0 / 8;
            if (prob > Math.random()) {
                this.hits++;
            } else {
                break;
            }
        }
    }

    @Override
    public String describe() {
        return "use Fury Attack";
    }

}
