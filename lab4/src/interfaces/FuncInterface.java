package interfaces;

@FunctionalInterface
public interface FuncInterface {
    static int a() {
        return 1;
    };
    int c();
    default String b() {
        return "123";
    };
}
