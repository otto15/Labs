import abstractions.Location;
import classes.*;
import classes.Character;
import enums.Mood;
import exceptions.NoLightSourcesException;
import interfaces.MyAnnotation;

import java.lang.reflect.*;

public class Main {
    public static void main(String[] args) throws NoLightSourcesException {

        Room kitchen = new Room("Столовая");
        Room hallway = new Room("Прихожая");
        Room malyshRoom = new Room("Комната Малыша");
        Cover tent = new Cover("Палатка", malyshRoom, 2);
        Character malysh = new Character("Малыш", malyshRoom);
        FlyingCharacter karlson = new FlyingCharacter("Карлсон", malyshRoom, "Three Ends", 100.0);
        Character betan = new Character("Бетан", kitchen);
        Character pelle = new Character("Пелле", kitchen);
        Lamp mwLight = new Lamp("MW-Light", 50, kitchen);
        Lamp myLamp = new Lamp("My-Lamp", 30, kitchen);
        Lamp torch = new Lamp("Nice Torch", 30, tent);


        karlson.setCover(tent);
        malysh.setCover(tent);
        karlson.setMood(Mood.HAPPY);
        malysh.setMood(Mood.HAPPY);
        tent.outputIlluminationLevel();
        malysh.turnOnLamp(torch);
        karlson.turnOffLamp(torch);
        tent.outputIlluminationLevel();
        tent.changeLocation(hallway);
        mwLight.outputStatus();
        kitchen.outputIlluminationLevel();
        tent.changeLocation(kitchen);

        karlson.launch();
        betan.turnOnLamp(mwLight);
        pelle.turnOnLamp(myLamp);
        System.out.println(kitchen.getLightProportions());
//        try {
//            System.out.println(kitchen.getLightProportions());
//        } catch (NoLightSourcesException e) {
//            System.out.println(e.getMessage());
//        }
        try {
            System.out.println(malyshRoom.getLightProportions());
        } catch (NoLightSourcesException e) {
            System.out.println(e.getMessage());
        }
        malysh.unexpectedMoodChange();

        betan.changeLocationByTeleport(malyshRoom);
        //betan.setCover(tent);
        FlyingCharacter.Propeller.a();
        System.out.println(FlyingCharacter.Propeller.b);
        String s = "puk";
        try {
            Class<?> c = Class.forName(s);
            Field name = malysh.getClass().getDeclaredField("name");
            MyAnnotation anno = name.getAnnotation(MyAnnotation.class);
            System.out.println(anno.str());
            name.setAccessible(true);
            System.out.println(name.get(malysh));
            Method m = malysh.getClass().getMethod("unexpectedMoodChange");
            m.invoke(karlson);
        } catch (NoSuchFieldException | IllegalAccessException | NoSuchMethodException | InvocationTargetException | ClassNotFoundException e) {
            System.out.println("Lox");
        }
        FlyingCharacter.Propeller.y();

        FlyingCharacter.Propeller p = karlson.new Propeller("min", 123.0);
        Location.LightInformationPair lp = new Location.LightInformationPair(mwLight, 100.0);
        System.out.println(lp);
        Mood.HAPPY.setRepresentation("123");
        System.out.println(Mood.HAPPY.getRepresentation());
    }
}
