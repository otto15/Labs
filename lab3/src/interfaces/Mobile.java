package interfaces;


public interface Mobile<T> {
    void changeLocation(T destination);

    T getLocation();
}
