// Pokemon.jar

import ru.ifmo.se.pokemon.*;
import com.lab.pokemons.*;

public class Main {
    public static void main(String[] args) {
        Battle b = new Battle();

        Uxie uxi = new Uxie("Uxi", 1);
        Zigzagoon zig = new Zigzagoon("Zig", 1);
        Linoone lin = new Linoone("Lina", 1);
        Oddish odd = new Oddish("Odd", 1);
        Gloom glo = new Gloom("Glo", 1);
        Bellossom bel = new Bellossom("Bel", 1);

        b.addAlly(uxi);
        b.addAlly(zig);
        b.addAlly(glo);

        b.addFoe(lin);
        b.addFoe(odd);
        b.addFoe(bel);

        b.go();
    }
}
