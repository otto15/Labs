package com.lab.pokemons;

import com.lab.attacks.*;
import ru.ifmo.se.pokemon.*;

public class Oddish extends Pokemon {
    public Oddish(String name, int level) {
        super(name, level);
        setMove(new Swagger(), new DoubleTeam());
    }
}
