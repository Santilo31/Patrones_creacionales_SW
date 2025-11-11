package prototype;

public interface Prototype<T> {
    T clonar();

    default boolean puedeClonarse() {
        return true;
    }
}