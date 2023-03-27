package org.gb.list;

public interface List<E> {
    E get(int index);

    boolean removeElement(E element);

    void remove(int index);

    int size();

    int indexOf(E element);

    boolean contains(E element);

    void add(int index, E element);
}
