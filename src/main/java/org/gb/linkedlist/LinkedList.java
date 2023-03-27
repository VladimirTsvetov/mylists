package org.gb.linkedlist;

import org.gb.list.List;

public class LinkedList<E> implements List<E> {
    private int size = 0;
    private Node<E> first;
    private Node<E> last;

    private static class Node<E> {
        E item;
        Node<E> prev;
        Node<E> next;

        Node(Node<E> prev, E item, Node<E> next) {
            this.prev = prev;
            this.item = item;
            this.next = next;
        }

        public Node<E> getNext() {
            return this.next;
        }

        public Node<E> getPrev() {
            return this.prev;
        }

        public void setItem(E item) {
            this.item = item;
        }

        public void setPrev(Node<E> prev) {
            this.prev = prev;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }

    public LinkedList() {
        this.last = new Node(this.first, null,null);
        this.first = new Node(null, null, this.last);
    }

    public void addLast(E element) {
        Node<E> current = this.last;
        current.setItem(element);
        this.last = new Node(current, null, null);
        current.setNext(this.last);
        ++this.size;
    }

    public void addFirst(E element) {
        Node<E> current = this.first;
        current.setItem(element);
        this.first = new Node(null, null, current);
        current.setPrev(this.first);
        ++this.size;
    }

    private Node<E> getNode(int index) {
        Node<E> node = this.first.getNext();

        for(int i = 0; i < index; ++i) {
            node = node.getNext();
        }

        return node;
    }

    public E get(int index) {
        if (index >= 0 && index < this.size) {
            return this.getNode(index).item;
        } else {
            throw new IndexOutOfBoundsException(index);
        }
    }

    public boolean removeElement(E element) {
        int index = this.indexOf(element);
        if (index > 0) {
            this.remove(index);
            return true;
        } else {
            return false;
        }
    }

    public void remove(int index) {
        if (index >= 0 && index < this.size) {
            Node<E> node = this.getNode(index);
            Node<E> prev = node.getPrev();
            Node<E> next = node.getNext();
            prev.setNext(next);
            next.setPrev(prev);
            --this.size;
        } else {
            throw new IndexOutOfBoundsException(index);
        }
    }

    public int size() {
        return this.size;
    }

    public int indexOf(E element) {
        int count = 0;

        for(Node<E> current = this.first.getNext(); current != null; ++count) {
            if (current.item.equals(element)) {
                return count;
            }

            current = current.getNext();
        }

        return -1;
    }

    public boolean contains(E element) {
        int count = 0;

        for(Node<E> current = this.first.getNext(); current != null; ++count) {
            if (current.item.equals(element)) {
                return true;
            }

            current = current.getNext();
        }

        return false;
    }

    public void add(int index, E element) {
        if (index >= 0 && index < this.size) {
            Node<E> prev = this.getNode(index);
            Node<E> next = this.getNode(index + 1);
            Node<E> current = new Node(prev, element, next);
            prev.setNext(current);
            next.setPrev(current);
            ++this.size;
        } else {
            throw new IndexOutOfBoundsException(index);
        }
    }


}
