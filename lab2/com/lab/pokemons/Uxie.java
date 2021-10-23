package com.lab.pokemons;

import com.lab.attacks.*;
import ru.ifmo.se.pokemon.*;

public class Uxie extends Pokemon {
    public Uxie(String name, int level) {
        super(name, level);
        setType(Type.PSYCHIC);
        setStats(75, 75, 130, 75, 130, 95);
        setMove(new WoodHammer(), new Harden(), new RockPolish(), new StoneEdge());
    }
}
