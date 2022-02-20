package enums;

public enum Mood {
    HAPPY("радостное"){
        public int a = 2;
        public void setA(int a) {
            this.a = a;
        }
        public int getA() {
            return a;
        }
    }, SAD("грустное"), NORMAL("нормальное"), ANGRY("злое");

    private String representation;

    Mood(String representation) {
        this.representation = representation;
    }

    public String getRepresentation() {
        return representation;
    }

    public void setRepresentation(String s) {
        representation = s;
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
