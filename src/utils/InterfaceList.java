package utils;

/**
 * Created by anujshah on 7/10/16.
 */
public interface InterfaceList<T>
{
    void add(T element);

    void remove(T element);

    boolean contains(T element);

    boolean isEmpty();

    int size();

    T get(T element);

    T getNext();

    void reset();
}
