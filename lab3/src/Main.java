import abstractions.Location;
import classes.*;
import classes.Character;
import enums.Mood;
import exceptions.NoLightSourcesException;
import interfaces.AbleToRelocateObject;
import interfaces.Coverable;

public class Main {
    public static void main(String[] args) {

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
        try {
            System.out.println(kitchen.getLightProportions());
        } catch (NoLightSourcesException e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println(malyshRoom.getLightProportions());
        } catch (NoLightSourcesException e) {
            System.out.println(e.getMessage());
        }
        malysh.unexpectedMoodChange();

        betan.changeLocationByTeleport(malyshRoom);
        //betan.setCover(tent);

    }
}
