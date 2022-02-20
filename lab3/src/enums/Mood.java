package enums;

public enum Mood {
    HAPPY("радостное"), SAD("грустное"), NORMAL("нормальное"), ANGRY("злое");

    private final String representation;

    Mood(String representation) {
        this.representation = representation;
    }

    public String getRepresentation() {
        return representation;
    }

    @Override
    public String toString() {
        return getClass().getName() + "[name: " + name() + ", representation: " + representation + "]";
    }


    public static void main(String[] args) {
        Mood[] ms = Mood.values();
        for (Mood m : ms) {
            System.out.println(m);
            System.out.println(m.getRepresentation() + " " + m.hashCode());
        }
    }
}
