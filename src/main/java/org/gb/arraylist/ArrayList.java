package org.gb.arraylist;

import org.gb.list.List;

public class ArrayList<E> implements List<E> {
    private int capacity = 0;
    private int size = 0;
    private final int CAPACITY = 16;
    private Object[] arr;

    public ArrayList() {
        this.arr = new Object[CAPACITY];
        this.capacity = CAPACITY;
    }

    public ArrayList(int capacity) {
        this.capacity = capacity;
        this.arr = new Object[capacity];
    }

    private void increaseCapacity() {
        this.capacity *= 2;
        Object[] newArray = new Object[this.capacity];

        for(int i = 0; i < this.arr.length; ++i) {
            newArray[i] = this.arr[i];
            this.arr[i] = null;
        }

        this.arr = newArray;
    }

    @Override
    public E get(int index) {
        if (index >= 0 && index < this.size) {
            return (E)this.arr[index];
        } else {
            throw new IndexOutOfBoundsException(index);
        }
    }

    @Override
    public boolean removeElement(E element) {
        int adr = this.indexOf(element);
        if (adr > 0) {
            this.remove(adr);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void remove(int index) {
        if (index >= 0 && index < this.size) {
            this.arr[index] = null;
        } else {
            throw new IndexOutOfBoundsException(index);
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int indexOf(E element) {
        int counter = 0;

        do {
            if (counter >= this.size) {
                return -1;
            }
        } while(!this.arr[counter].equals(element));

        return counter;
    }

    @Override
    public boolean contains(E element) {
        return this.indexOf(element) > 0;
    }

    @Override
    public void add(int index, E element) {
        if (index >= 0) {
            if (this.size + 1 >= this.capacity) {
                this.increaseCapacity();
            }

            if (index > this.size) {
                index = this.size;
            }

            for(int i = this.size; i >= index; --i) {
                this.arr[i + 1] = this.arr[i];
            }

            this.arr[index] = element;
            ++this.size;
        }

    }
}
