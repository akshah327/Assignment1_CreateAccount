package utils;

/**
 * Created by anujshah on 7/10/16.
 */
public interface InterfaceIndexedList<T> extends InterfaceList<T>
{
    void add (int index, T element);

    void set (int index, T element);

    T remove (int index);

    int indexOf(T element);
}
