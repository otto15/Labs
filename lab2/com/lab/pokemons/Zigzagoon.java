package com.lab.pokemons;

import com.lab.attacks.*;
import ru.ifmo.se.pokemon.*;

public class Zigzagoon extends Pokemon {
    public Zigzagoon(String name, int level) {
        super(name, level);
        setType(Type.NORMAL);
        setStats(38, 30, 41, 30, 41, 60);
        setMove(new WorkUp(), new Facade(), new Swagger());
    }
}
