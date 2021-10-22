package com.lab.pokemons;


import com.lab.attacks.*;
import ru.ifmo.se.pokemon.*;

public class Linoone extends Zigzagoon {
    public Linoone(String name, int level) {
        super(name, level);
        setType(Type.NORMAL);
        setStats(78, 70, 61, 50, 61, 100);
        addMove(new Slam());
    }
}
